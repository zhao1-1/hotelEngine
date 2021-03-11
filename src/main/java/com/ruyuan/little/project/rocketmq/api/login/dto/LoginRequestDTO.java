package com.ruyuan.little.project.rocketmq.api.login.dto;

/**
 * @author <a href="mailto:little@163.com">little</a>
 * version: 1.0
 * Description:登录请求的dto
 **/
public class LoginRequestDTO {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名称
     */
    private String nickName;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * token
     */
    private String token;

    /**
     * 小程序id
     */
    private Integer beid;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBeid() {
        return beid;
    }

    public void setBeid(Integer beid) {
        this.beid = beid;
    }

    @Override
    public String toString() {
        return "LoginRequestDTO{" +
                "userId=" + userId +
                ", nickName='" + nickName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", token='" + token + '\'' +
                ", beid=" + beid +
                '}';
    }
}