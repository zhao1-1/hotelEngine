package com.ruyuan.little.project.rocketmq.api.message.manager;

import com.ruyuan.little.project.rocketmq.api.message.dto.OrderInfo;

/**
 * @author <a href="mailto:little@163.com">little</a>
 * version: 1.0
 * Description:订单消息command
 **/
public interface OrderMessageCommand<T> {

    /**
     * 执行
     *
     * @param orderInfo 订单信息
     */
    void send(OrderInfo orderInfo);
}
