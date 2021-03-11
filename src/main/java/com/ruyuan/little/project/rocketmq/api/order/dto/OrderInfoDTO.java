package com.ruyuan.little.project.rocketmq.api.order.dto;

import java.math.BigDecimal;

/**
 * @author <a href="mailto:little@163.com">little</a>
 * version: 1.0
 * Description:创建订单
 **/
public class OrderInfoDTO {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 店铺的id
     */
    private Integer beid;

    /**
     * 开放id
     */
    private String openId;

    /**
     * 房间id
     */
    private Integer roomId;

    /**
     * 酒店id
     */
    private Integer hotelId;

    /**
     * 酒店名字
     */
    private String hotelName;

    /**
     * 订购数量
     */
    private Integer total;

    /**
     * 订单总金额
     */
    private BigDecimal totalPrice;

    /**
     * 房主姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 预定时间
     */
    private String remark;

    /**
     * 入住开始时间
     */
    private String beginDate;

    /**
     * 入住结束时间
     */
    private String endDate;

    /**
     * 订单的状态
     */
    private Integer status;

    /**
     * 订单创建时间 Unix时间
     */
    private Integer createTime;

    /**
     * 订单支付时间 Unix时间
     */
    private Integer payTime;

    /**
     * 订单取消时间 Unix时间
     */
    private Integer cancelTime;

    /**
     * 订单商品信息
     */
    private OrderItemDTO orderItem;

    /**
     * 优惠券id
     */
    private Integer couponId;

    /**
     * 优惠券金额
     */
    private BigDecimal couponMoney;

    /**
     * 用户id
     */
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public BigDecimal getCouponMoney() {
        return couponMoney;
    }

    public void setCouponMoney(BigDecimal couponMoney) {
        this.couponMoney = couponMoney;
    }

    public Integer getPayTime() {
        return payTime;
    }

    public void setPayTime(Integer payTime) {
        this.payTime = payTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 订单的更新时间 unix时间
     */
    private Integer updateTime;

    public Integer getBeid() {
        return beid;
    }

    public void setBeid(Integer beid) {
        this.beid = beid;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public OrderItemDTO getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItemDTO orderItem) {
        this.orderItem = orderItem;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Integer getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Integer cancelTime) {
        this.cancelTime = cancelTime;
    }
}