package com.ruyuan.little.project.rocketmq.api.login.service;

import com.ruyuan.little.project.rocketmq.api.login.dto.LoginRequestDTO;

/**
 * @author <a href="mailto:little@163.com">little</a>
 * version: 1.0
 * Description:登陆接口service组件
 **/
public interface LoginService {

    /**
     * 第一次登陆分发优惠券
     *
     * @param loginRequestDTO 登陆信息
     */
    void firstLoginDistributeCoupon(LoginRequestDTO loginRequestDTO);

    /**
     * 重置用户的登录状态
     *
     * @param phoneNumber 手机号
     */
    void resetFirstLoginStatus(String phoneNumber);
}