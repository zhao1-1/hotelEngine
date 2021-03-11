package com.ruyuan.little.project.rocketmq.api.message.dto;

/**
 * @author <a href="mailto:little@163.com">little</a>
 * version: 1.0
 * Description:订单信息
 **/
public class OrderInfo {

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 订单id
     */
    private Integer id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 订单创建时间 Unix时间
     */
    private Integer createTime;

    /**
     * 订单支付时间 Unix时间
     */
    private Integer payTime;

    /**
     * 订单支付时间 Unix时间
     */
    private Integer cancelTime;

    /**
     * 订单商品
     */
    private OrderItem orderItem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getPayTime() {
        return payTime;
    }

    public void setPayTime(Integer payTime) {
        this.payTime = payTime;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public Integer getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Integer cancelTime) {
        this.cancelTime = cancelTime;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}