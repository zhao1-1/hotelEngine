package com.ruyuan.little.project.rocketmq.api.message.listener;

import com.alibaba.fastjson.JSON;
import com.ruyuan.little.project.rocketmq.api.message.dto.OrderInfo;
import com.ruyuan.little.project.rocketmq.api.message.dto.OrderMessage;
import com.ruyuan.little.project.rocketmq.api.message.manager.OrderMessageCommand;
import com.ruyuan.little.project.rocketmq.api.message.manager.OrderMessageCommandFactory;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author <a href="mailto:little@163.com">little</a>
 * version: 1.0
 * Description:订单状态顺序消息
 **/
@Component
public class OrderMessageListener implements MessageListenerOrderly {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderMessageListener.class);

    @Autowired
    private OrderMessageCommandFactory orderMessageCommandFactory;

    @Override
    public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
        for (MessageExt msg : msgs) {
            String content = new String(msg.getBody(), StandardCharsets.UTF_8);
            LOGGER.info("received order  message:{}", content);

            // 订单消息
            OrderMessage orderMessage = JSON.parseObject(content, OrderMessage.class);
            // 订单内容
            OrderInfo orderInfo = JSON.parseObject(orderMessage.getContent(), OrderInfo.class);
            // 创建订单消息命令
            OrderMessageCommand orderMessageCommand = orderMessageCommandFactory.create(orderMessage.getMessageType());
            // 发送消息
            try {
                orderMessageCommand.send(orderInfo);
            } catch (Exception e) {
                LOGGER.error("push wx message fail error message:{}", e.getMessage());
            }
        }

        return ConsumeOrderlyStatus.SUCCESS;
    }
}