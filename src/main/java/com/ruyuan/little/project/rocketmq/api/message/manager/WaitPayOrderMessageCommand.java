package com.ruyuan.little.project.rocketmq.api.message.manager;

import com.ruyuan.little.project.common.enums.MessageTypeEnum;
import com.ruyuan.little.project.message.api.WxSubscribeMessageApi;
import com.ruyuan.little.project.message.dto.ValueDTO;
import com.ruyuan.little.project.message.dto.WaitPayOrderMessageDTO;
import com.ruyuan.little.project.rocketmq.api.message.dto.OrderInfo;
import com.ruyuan.little.project.rocketmq.common.utils.DateUtil;

import java.util.Date;

/**
 * @author <a href="mailto:little@163.com">little</a>
 * version: 1.0
 * Description:待支付订单消息command
 **/
public class WaitPayOrderMessageCommand extends AbstractOrderMessageCommand<WaitPayOrderMessageDTO> {

    public WaitPayOrderMessageCommand(WxSubscribeMessageApi wxSubscribeMessageApi) {
        super(wxSubscribeMessageApi);
    }

    @Override
    protected WaitPayOrderMessageDTO builderWxOrderMessage(OrderInfo orderInfo) {
        WaitPayOrderMessageDTO waitPayOrderMessageDTO = new WaitPayOrderMessageDTO();
        ValueDTO number1 = new ValueDTO();
        // TODO 由于模板字段只能为数字这里用订单id
        number1.setValue(orderInfo.getId());
        waitPayOrderMessageDTO.setNumber1(number1);

        ValueDTO time2 = new ValueDTO();
        long createTime = orderInfo.getCreateTime() * 1000L;
        time2.setValue(DateUtil.format(new Date(createTime), DateUtil.FULL_TIME_SPLIT_PATTERN));
        waitPayOrderMessageDTO.setTime2(time2);

        ValueDTO time10 = new ValueDTO();
        // 创建时间30分钟之后
        long validTime = (orderInfo.getCreateTime() + 30 * 60) * 1000L;
        time10.setValue(DateUtil.format(new Date(validTime), DateUtil.FULL_TIME_SPLIT_PATTERN));
        waitPayOrderMessageDTO.setTime10(time10);

        ValueDTO thing3 = new ValueDTO();
        thing3.setValue(orderInfo.getOrderItem().getTitle());
        waitPayOrderMessageDTO.setThing3(thing3);
        return waitPayOrderMessageDTO;
    }

    @Override
    protected MessageTypeEnum getMessageType() {
        return MessageTypeEnum.WX_CREATE_ORDER;
    }
}