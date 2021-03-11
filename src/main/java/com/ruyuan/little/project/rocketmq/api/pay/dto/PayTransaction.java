package com.ruyuan.little.project.rocketmq.api.pay.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author <a href="mailto:little@163.com">little</a>
 * version: 1.0
 * Description:支付流水
 **/
public class PayTransaction {

    /**
     * id
     */
    private Long       id;
    /**
     * 订单编号
     */
    private String     orderNo;
    /**
     * 订单应付金额
     */
    private BigDecimal payableAmount;

    /**
     * 用户支付账号
     */
    private String  userPayAccount;
    /**
     * 交易渠道
     */
    private Integer transactionChannel;
    /**
     * 第三方支付交易编号
     */
    private String  transactionNumber;
    /**
     * 第三方支付完成支付的时间
     */
    private String  finishPayTime;
    /**
     * 第三方支付的响应状态码
     */
    private String  responseCode;
    /**
     * 支付交易状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date    gmtCreate;
    /**
     * 修改时间
     */
    private Date    gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getTransactionChannel() {
        return transactionChannel;
    }

    public void setTransactionChannel(Integer transactionChannel) {
        this.transactionChannel = transactionChannel;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public String getFinishPayTime() {
        return finishPayTime;
    }

    public void setFinishPayTime(String finishPayTime) {
        this.finishPayTime = finishPayTime;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public BigDecimal getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }
}