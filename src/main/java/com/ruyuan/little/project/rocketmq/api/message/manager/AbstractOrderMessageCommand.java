package com.ruyuan.little.project.rocketmq.api.message.manager;

import com.alibaba.fastjson.JSON;
import com.ruyuan.little.project.common.dto.CommonResponse;
import com.ruyuan.little.project.common.enums.LittleProjectTypeEnum;
import com.ruyuan.little.project.common.enums.MessageTypeEnum;
import com.ruyuan.little.project.message.api.WxSubscribeMessageApi;
import com.ruyuan.little.project.message.dto.WxSubscribeMessageDTO;
import com.ruyuan.little.project.rocketmq.api.message.dto.OrderInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:little@163.com">little</a>
 * version: 1.0
 * Description:订单消息抽象模板方法
 **/
public abstract class AbstractOrderMessageCommand<T> implements OrderMessageCommand<T> {

    /**
     * 日志组件
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractOrderMessageCommand.class);

    /**
     * 微信订阅消息api接口
     */
    private WxSubscribeMessageApi wxSubscribeMessageApi;

    public AbstractOrderMessageCommand(WxSubscribeMessageApi wxSubscribeMessageApi) {
        this.wxSubscribeMessageApi = wxSubscribeMessageApi;
    }

    @Override
    public void send(OrderInfo orderInfo) {
        T wxOrderMessage = this.builderWxOrderMessage(orderInfo);
        this.doSend(wxOrderMessage, orderInfo.getPhoneNumber());
    }

    /**
     * 构建消息内容
     *
     * @param orderInfo 订单信息
     * @return 结果
     */
    protected abstract T builderWxOrderMessage(OrderInfo orderInfo);

    /**
     * 实际发送消息
     *
     * @param wxOrderMessage 消息内容
     * @param phoneNumber    手机号
     */
    private void doSend(T wxOrderMessage, String phoneNumber) {
        WxSubscribeMessageDTO<T> subscribeMessageDTO = new WxSubscribeMessageDTO<>();
        subscribeMessageDTO.setContent(wxOrderMessage);
        subscribeMessageDTO.setLittleProjectTypeEnum(LittleProjectTypeEnum.ROCKETMQ);
        subscribeMessageDTO.setMessageTypeEnum(this.getMessageType());
        subscribeMessageDTO.setPhoneNumber(phoneNumber);
        LOGGER.info("start push order message to weixin param:{}", JSON.toJSONString(subscribeMessageDTO));
        CommonResponse response = wxSubscribeMessageApi.send(subscribeMessageDTO);
        LOGGER.info("end push order message to weixin param:{}, response:{}", JSON.toJSONString(subscribeMessageDTO), JSON.toJSONString(response));
    }

    /**
     * 消息类型
     *
     * @return 消息类型
     */
    protected abstract MessageTypeEnum getMessageType();
}