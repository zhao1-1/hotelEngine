package com.ruyuan.little.project.rocketmq.admin.service.impl;

import com.ruyuan.little.project.common.dto.CommonResponse;
import com.ruyuan.little.project.rocketmq.admin.service.AdminOrderService;
import com.ruyuan.little.project.rocketmq.api.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:little@163.com">little</a>
 * version: 1.0
 * Description:
 **/
@Service
public class AdminOrderServiceImpl implements AdminOrderService {

    @Autowired
    private OrderService orderService;

    @Override
    public CommonResponse confirmOrder(String orderNo, String phoneNumber) {
        // TODO 正常调用订单服务的dubbo接口或者操作数据库
        orderService.informConfirmOrder(orderNo, phoneNumber);
        return CommonResponse.success();
    }

    @Override
    public CommonResponse finishedOrder(String orderNo, String phoneNumber) {
        // TODO 正常调用订单服务的dubbo接口或者操作数据库
        orderService.informFinishedOrder(orderNo, phoneNumber);
        return CommonResponse.success();
    }
}