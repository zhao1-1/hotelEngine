package com.ruyuan.little.project.rocketmq.api.coupon.dto;

/**
 * @author <a href="mailto:little@163.com">little</a>
 * version: 1.0
 * Description:完成订单消息dto
 **/
public class OrderFinishedMessageDTO {

    /**
     * 订单id
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
     * 用户id
     */
    private Integer userId;

    /**
     * 手机号
     */
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getBeid() {
        return beid;
    }

    public void setBeid(Integer beid) {
        this.beid = beid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}