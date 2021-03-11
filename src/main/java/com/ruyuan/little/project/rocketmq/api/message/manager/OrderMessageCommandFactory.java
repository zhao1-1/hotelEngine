package com.ruyuan.little.project.rocketmq.api.message.manager;

import com.ruyuan.little.project.common.enums.MessageTypeEnum;
import com.ruyuan.little.project.message.api.WxSubscribeMessageApi;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author <a href="mailto:little@163.com">little</a>
 * version: 1.0
 * Description:订单消息命令工厂
 **/
@Component
public class OrderMessageCommandFactory {

    /**
     * mysql dubbo api接口
     */
    @Reference(version = "1.0.0",
            interfaceClass = WxSubscribeMessageApi.class,
            cluster = "failfast")
    private WxSubscribeMessageApi wxSubscribeMessageApi;

    /**
     * 创建command
     *
     * @return 订单消息的command
     */
    public OrderMessageCommand create(MessageTypeEnum messageTypeEnum) {
        if (Objects.equals(messageTypeEnum, MessageTypeEnum.WX_CREATE_ORDER)) {
            // 创建订单
            return new WaitPayOrderMessageCommand(wxSubscribeMessageApi);
        } else if (Objects.equals(messageTypeEnum, MessageTypeEnum.WX_CANCEL_ORDER)) {
            // 取消订单
            return new CancelOrderMessageCommand(wxSubscribeMessageApi);
        } else if (Objects.equals(messageTypeEnum, MessageTypeEnum.WX_PAY_ORDER)) {
            // 支付订单
            return new PayOrderMessageCommand(wxSubscribeMessageApi);
        } else if (Objects.equals(messageTypeEnum, MessageTypeEnum.WX_CONFIRM_ORDER)) {
            // 待支付 创建订单
            return new ConfirmOrderMessageCommand(wxSubscribeMessageApi);
        } else if (Objects.equals(messageTypeEnum, MessageTypeEnum.WX_FINISHED_ORDER)) {
            // 待支付 创建订单
            return new FinishedOrderMessageCommand(wxSubscribeMessageApi);
        }
        return null;
    }
}