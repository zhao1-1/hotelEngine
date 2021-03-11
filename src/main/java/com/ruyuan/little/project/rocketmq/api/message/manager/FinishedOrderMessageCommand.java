package com.ruyuan.little.project.rocketmq.api.message.manager;

import com.ruyuan.little.project.common.enums.MessageTypeEnum;
import com.ruyuan.little.project.message.api.WxSubscribeMessageApi;
import com.ruyuan.little.project.message.dto.FinishedOrderMessageDTO;
import com.ruyuan.little.project.message.dto.ValueDTO;
import com.ruyuan.little.project.rocketmq.api.message.dto.OrderInfo;

/**
 * @author <a href="mailto:little@163.com">little</a>
 * version: 1.0
 * Description:退房订单
 **/
public class FinishedOrderMessageCommand extends AbstractOrderMessageCommand<FinishedOrderMessageDTO> {

    public FinishedOrderMessageCommand(WxSubscribeMessageApi wxSubscribeMessageApi) {
        super(wxSubscribeMessageApi);
    }

    @Override
    protected FinishedOrderMessageDTO builderWxOrderMessage(OrderInfo orderInfo) {
        FinishedOrderMessageDTO finishedOrderMessageDTO = new FinishedOrderMessageDTO();
        ValueDTO character_string1 = new ValueDTO();
        character_string1.setValue(orderInfo.getOrderNo());
        finishedOrderMessageDTO.setCharacter_string1(character_string1);

        ValueDTO thing5 = new ValueDTO();
        thing5.setValue(MessageTypeEnum.WX_FINISHED_ORDER.getDesc());
        finishedOrderMessageDTO.setThing5(thing5);

        return finishedOrderMessageDTO;
    }

    @Override
    protected MessageTypeEnum getMessageType() {
        return MessageTypeEnum.WX_FINISHED_ORDER;
    }
}