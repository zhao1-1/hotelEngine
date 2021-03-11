package com.ruyuan.little.project.rocketmq.api.message.dto;

import com.ruyuan.little.project.common.enums.MessageTypeEnum;

/**
 * @author <a href="mailto:little@163.com">little</a>
 * version: 1.0
 * Description:订单消息
 **/
public class OrderMessage {

    /**
     * 消息内容
     */
    private String content;

    /**
     * 订单消息推送类型 {@link MessageTypeEnum}
     */
    private MessageTypeEnum messageType;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MessageTypeEnum getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageTypeEnum messageType) {
        this.messageType = messageType;
    }
}