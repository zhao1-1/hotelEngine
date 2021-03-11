package com.ruyuan.little.project.rocketmq.api.message.manager;

import com.ruyuan.little.project.common.enums.MessageTypeEnum;
import com.ruyuan.little.project.message.api.WxSubscribeMessageApi;
import com.ruyuan.little.project.message.dto.ConfirmOrderMessageDTO;
import com.ruyuan.little.project.message.dto.ValueDTO;
import com.ruyuan.little.project.rocketmq.api.message.dto.OrderInfo;

/**
 * @author <a href="mailto:little@163.com">little</a>
 * version: 1.0
 * Description:入住订单
 **/
public class ConfirmOrderMessageCommand extends AbstractOrderMessageCommand<ConfirmOrderMessageDTO> {

    public ConfirmOrderMessageCommand(WxSubscribeMessageApi wxSubscribeMessageApi) {
        super(wxSubscribeMessageApi);
    }

    @Override
    protected ConfirmOrderMessageDTO builderWxOrderMessage(OrderInfo orderInfo) {
        ConfirmOrderMessageDTO confirmOrderMessageDTO = new ConfirmOrderMessageDTO();
        ValueDTO thing6 = new ValueDTO();
        thing6.setValue(orderInfo.getOrderItem().getTitle());
        confirmOrderMessageDTO.setThing1(thing6);

        ValueDTO thing2 = new ValueDTO();
        thing2.setValue(MessageTypeEnum.WX_CONFIRM_ORDER.getDesc());
        confirmOrderMessageDTO.setThing2(thing2);

        return confirmOrderMessageDTO;
    }

    @Override
    protected MessageTypeEnum getMessageType() {
        return MessageTypeEnum.WX_CONFIRM_ORDER;
    }
}