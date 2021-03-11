package com.ruyuan.little.project.rocketmq.api.pay.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 查询支付状态的响应结果
 *
 * @author little
 */
public class QueryPayStatusResponse {

    /**
     * 用户手机号
     */
    private String phoneNumber;

    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 用户支付账号
     */
    private String userPayAccount;

    /**
     * 订单应付金额
     */
    private BigDecimal payableAmount;

    /**
     * 第三方支付交易流水号
     */
    private String  transactionNumber;
    /**
     * 第三方支付完成支付的时间
     */
    private Date    finishPayTime;
    /**
     * 第三方支付响应状态码
     */
    private String  responseCode;
    /**
     * 支付交易状态
     */
    private Integer payTransactionStatus;

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

    public String getUserPayAccount() {
        return userPayAccount;
    }

    public void setUserPayAccount(String userPayAccount) {
        this.userPayAccount = userPayAccount;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public Integer getPayTransactionStatus() {
        return payTransactionStatus;
    }

    public void setPayTransactionStatus(Integer payTransactionStatus) {
        this.payTransactionStatus = payTransactionStatus;
    }

    public BigDecimal getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }

    public Date getFinishPayTime() {
        return finishPayTime;
    }

    public void setFinishPayTime(Date finishPayTime) {
        this.finishPayTime = finishPayTime;
    }
}
