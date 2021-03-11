package com.ruyuan.little.project.rocketmq.api.login.controller;

import com.alibaba.fastjson.JSON;
import com.ruyuan.little.project.common.dto.CommonResponse;
import com.ruyuan.little.project.rocketmq.api.login.dto.LoginRequestDTO;
import com.ruyuan.little.project.rocketmq.api.login.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author <a href="mailto:little@163.com">little</a>
 * version: 1.0
 * Description:登录接口
 **/
@RestController
@RequestMapping(value = "/api/login")
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    /**
     * 登陆接口
     */
    @Autowired
    private LoginService loginService;


    /**
     * 登录请求
     *
     * @param loginRequestDTO 登录请求信息
     * @return 结果
     */
    @PostMapping(value = "/wxLogin")
    public CommonResponse wxLogin(@RequestBody LoginRequestDTO loginRequestDTO) {
        // TODO 模拟接收到用户登录请求
        LOGGER.info("login success user info:{} ", JSON.toJSONString(loginRequestDTO));

        // 第一次登陆下发优惠券
        loginService.firstLoginDistributeCoupon(loginRequestDTO);

        return CommonResponse.success();
    }

    /**
     * 重置登录状态 TODO 方便测试使用
     *
     * @param phoneNumber 用户手机号
     * @return 结果
     */
    @GetMapping(value = "/resetLoginStatus")
    public CommonResponse resetFirstLoginStatus(@RequestParam(value = "phoneNumber") String phoneNumber) {
        LOGGER.info("reset user first login status phoneNumber:{}", phoneNumber);
        loginService.resetFirstLoginStatus(phoneNumber);
        return CommonResponse.success();
    }
}