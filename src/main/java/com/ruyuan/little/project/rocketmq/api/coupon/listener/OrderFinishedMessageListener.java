package com.ruyuan.little.project.rocketmq.api.coupon.listener;

import com.alibaba.fastjson.JSON;
import com.ruyuan.little.project.common.dto.CommonResponse;
import com.ruyuan.little.project.common.enums.ErrorCodeEnum;
import com.ruyuan.little.project.common.enums.LittleProjectTypeEnum;
import com.ruyuan.little.project.redis.api.RedisApi;
import com.ruyuan.little.project.rocketmq.api.coupon.dto.OrderFinishedMessageDTO;
import com.ruyuan.little.project.rocketmq.api.coupon.service.CouponService;
import com.ruyuan.little.project.rocketmq.common.constants.RedisKeyConstant;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

/**
 * @author <a href="mailto:little@163.com">little</a>
 * version: 1.0
 * Description:订单退房成功的listener
 **/
@Component
public class OrderFinishedMessageListener implements MessageListenerConcurrently {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFinishedMessageListener.class);

    /**
     * redis dubbo服务
     */
    @Reference(version = "1.0.0",
            interfaceClass = RedisApi.class,
            cluster = "failfast")
    private RedisApi redisApi;

    /**
     * 优惠券服务service组件
     */
    @Autowired
    private CouponService couponService;

    /**
     * 第一次登陆下发的优惠券id
     */
    @Value("${order.finished.couponId}")
    private Integer orderFinishedCouponId;

    /**
     * 第一次登陆优惠券有效天数
     */
    @Value("${order.finished.coupon.day}")
    private Integer orderFinishedCouponDay;

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        String orderNo = null;
        String phoneNumber = null;
        for (MessageExt msg : msgs) {
            try {
                String body = new String(msg.getBody(), StandardCharsets.UTF_8);
                LOGGER.info("received order finished message:{}", body);

                OrderFinishedMessageDTO orderFinishedMessageDTO = JSON.parseObject(body, OrderFinishedMessageDTO.class);

                // 权益分发保证接口的幂等
                orderNo = orderFinishedMessageDTO.getOrderNo();
                phoneNumber = orderFinishedMessageDTO.getPhoneNumber();
                CommonResponse<Boolean> response = redisApi.setnx(RedisKeyConstant.ORDER_FINISHED_DUPLICATION_KEY_PREFIX + orderNo,
                                                                  orderNo,
                                                                  phoneNumber,
                                                                  LittleProjectTypeEnum.ROCKETMQ);
                if (Objects.equals(response.getCode(), ErrorCodeEnum.FAIL.getCode())) {
                    // 请求redis失败
                    LOGGER.info("consumer order finished message redis dubbo interface fail  orderNo:{}", orderNo);
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }

                // 请求redis成功，判断状态码
                if (Objects.equals(response.getData(), Boolean.FALSE)) {
                    // 重复消费订单退房消息 返回
                    LOGGER.info("duplicate consumer order finished message orderNo:{}", orderNo);
                } else {
                    // 未重复消费 分发半折优惠券权益
                    couponService.distributeCoupon(orderFinishedMessageDTO.getBeid(),
                                                   orderFinishedMessageDTO.getUserId(),
                                                   orderFinishedCouponId,
                                                   orderFinishedCouponDay,
                                                   orderFinishedMessageDTO.getId(), phoneNumber);
                    LOGGER.info("distribute orderNo:{} finished order coupon end", orderNo);
                }
            } catch (Exception e) {
                // 调用失败
                LOGGER.info("consumer order finished message fail, error:{}", e);
                if (orderNo != null) {
                    // 删除幂等key
                    redisApi.del(RedisKeyConstant.ORDER_FINISHED_DUPLICATION_KEY_PREFIX + orderNo,
                                 phoneNumber,
                                 LittleProjectTypeEnum.ROCKETMQ);
                }
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}