package com.ruyuan.little.project.rocketmq.api.order.dto;

/**
 * @author <a href="mailto:little@163.com">little</a>
 * version: 1.0
 * Description:创建订单响应体内容
 **/
public class CreateOrderResponseDTO {

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 订单id
     */
    private Integer orderId;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}