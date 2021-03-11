package com.ruyuan.little.project.rocketmq.api.login.service.impl;

import com.alibaba.fastjson.JSON;
import com.ruyuan.little.project.common.dto.CommonResponse;
import com.ruyuan.little.project.common.enums.ErrorCodeEnum;
import com.ruyuan.little.project.common.enums.LittleProjectTypeEnum;
import com.ruyuan.little.project.mysql.api.MysqlApi;
import com.ruyuan.little.project.mysql.dto.MysqlRequestDTO;
import com.ruyuan.little.project.redis.api.RedisApi;
import com.ruyuan.little.project.rocketmq.api.login.dto.LoginRequestDTO;
import com.ruyuan.little.project.rocketmq.api.login.enums.FirstLoginStatusEnum;
import com.ruyuan.little.project.rocketmq.api.login.service.LoginService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author <a href="mailto:little@163.com">little</a>
 * version: 1.0
 * Description:登陆接口service组件实现类
 **/
@Service
public class LoginServiceImpl implements LoginService {

    /**
     * 日志组件
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    @Qualifier(value = "loginMqProducer")
    private DefaultMQProducer loginMqProducer;

    @Value("${rocketmq.login.topic}")
    private String loginTopic;

    /**
     * mysql dubbo api接口
     */
    @Reference(version = "1.0.0",
            interfaceClass = MysqlApi.class,
            cluster = "failfast")
    private MysqlApi mysqlApi;

    /**
     * redis dubbo服务
     */
    @Reference(version = "1.0.0",
            interfaceClass = RedisApi.class,
            cluster = "failfast")
    private RedisApi redisApi;

    @Override
    public void firstLoginDistributeCoupon(LoginRequestDTO loginRequestDTO) {
        if (!isFirstLogin(loginRequestDTO)) {
            // 不是第一次登陆 返回
            LOGGER.info("userId:{} not first login", loginRequestDTO.getUserId());
            return;
        }
        // 更新第一次登陆的标识位
        this.updateFirstLoginStatus(loginRequestDTO.getPhoneNumber(), FirstLoginStatusEnum.NO);

        // 发送第一次登陆成功的消息
        this.sendFirstLoginMessage(loginRequestDTO);
    }

    /**
     * 校验是否是第一次登陆
     *
     * @param loginRequestDTO 登陆信息
     * @return
     */
    private boolean isFirstLogin(LoginRequestDTO loginRequestDTO) {
        MysqlRequestDTO mysqlRequestDTO = new MysqlRequestDTO();
        mysqlRequestDTO.setSql("select first_login_status from t_member where id = ? ");
        ArrayList<Object> params = new ArrayList<>();
        params.add(loginRequestDTO.getUserId());
        mysqlRequestDTO.setParams(params);
        mysqlRequestDTO.setPhoneNumber(loginRequestDTO.getPhoneNumber());
        mysqlRequestDTO.setProjectTypeEnum(LittleProjectTypeEnum.ROCKETMQ);

        LOGGER.info("start query first login status param:{}", JSON.toJSONString(mysqlRequestDTO));
        CommonResponse<List<Map<String, Object>>> response = mysqlApi.query(mysqlRequestDTO);
        LOGGER.info("end query first login status param:{}, response:{}", JSON.toJSONString(mysqlRequestDTO), JSON.toJSONString(response));
        if (Objects.equals(response.getCode(), ErrorCodeEnum.SUCCESS.getCode())
                && !CollectionUtils.isEmpty(response.getData())) {
            Map<String, Object> map = response.getData().get(0);
            return Objects.equals(Integer.valueOf(String.valueOf(map.get("first_login_status"))),
                                  FirstLoginStatusEnum.YES.getStatus());
        }
        return false;
    }

    /**
     * 更新第一次登陆的标志位
     *
     * @param phoneNumber          用户手机号
     * @param firstLoginStatusEnum 登录状态 {@link FirstLoginStatusEnum}
     */
    private void updateFirstLoginStatus(String phoneNumber, FirstLoginStatusEnum firstLoginStatusEnum) {
        MysqlRequestDTO mysqlRequestDTO = new MysqlRequestDTO();
        mysqlRequestDTO.setSql("update t_member set first_login_status = ? WHERE beid = 1563 and mobile = ?");
        ArrayList<Object> params = new ArrayList<>();
        params.add(firstLoginStatusEnum.getStatus());
        params.add(phoneNumber);
        mysqlRequestDTO.setParams(params);
        mysqlRequestDTO.setPhoneNumber(phoneNumber);
        mysqlRequestDTO.setProjectTypeEnum(LittleProjectTypeEnum.ROCKETMQ);

        LOGGER.info("start query first login status param:{}", JSON.toJSONString(mysqlRequestDTO));
        CommonResponse<Integer> response = mysqlApi.update(mysqlRequestDTO);
        LOGGER.info("end query first login status param:{}, response:{}", JSON.toJSONString(mysqlRequestDTO), JSON.toJSONString(response));
    }


    @Override
    public void resetFirstLoginStatus(String phoneNumber) {
        this.updateFirstLoginStatus(phoneNumber, FirstLoginStatusEnum.YES);
    }

    /**
     * 发送首次登陆消息
     *
     * @param loginRequestDTO 登陆请求信息
     */
    private void sendFirstLoginMessage(LoginRequestDTO loginRequestDTO) {
        // 场景一:性能提升  异步发送一个登录成功的消息到mq中
        Message message = new Message();
        message.setTopic(loginTopic);
        // 消息内容用户id
        message.setBody(JSON.toJSONString(loginRequestDTO).getBytes(StandardCharsets.UTF_8));
        try {
            LOGGER.info("start send login success notify message");
            SendResult sendResult = loginMqProducer.send(message);
            LOGGER.info("end send login success notify message, sendResult:{}", JSON.toJSONString(sendResult));
        } catch (Exception e) {
            LOGGER.error("send login success notify message fail, error message:{}", e);
        }
    }


}