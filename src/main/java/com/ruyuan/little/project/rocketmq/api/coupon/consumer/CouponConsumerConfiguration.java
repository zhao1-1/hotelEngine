package com.ruyuan.little.project.rocketmq.api.coupon.consumer;

import com.ruyuan.little.project.rocketmq.api.coupon.listener.FirstLoginMessageListener;
import com.ruyuan.little.project.rocketmq.api.coupon.listener.OrderFinishedMessageListener;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="mailto:little@163.com">little</a>
 * version: 1.0
 * Description:优惠券模块消费者配置类组件
 **/
@Configuration
public class CouponConsumerConfiguration {

    /**
     * namesrv address
     */
    @Value("${rocketmq.namesrv.address}")
    private String namesrvAddress;

    /**
     * 登录topic
     */
    @Value("${rocketmq.login.topic}")
    private String loginTopic;

    /**
     * 登录消息consumerGroup
     */
    @Value("${rocketmq.login.consumer.group}")
    private String loginConsumerGroup;

    /**
     * 退房订单topic
     */
    @Value("${rocketmq.order.finished.topic}")
    private String orderFinishedTopic;

    /**
     * 退房订单consumerGroup
     */
    @Value("${rocketmq.order.finished.consumer.group}")
    private String orderFinishedConsumerGroup;

    /**
     * 登录消息的consumer bean
     *
     * @return 登录消息的consumer bean
     */
    @Bean(value = "loginConsumer")
    public DefaultMQPushConsumer loginConsumer(@Qualifier(value = "firstLoginMessageListener") FirstLoginMessageListener firstLoginMessageListener) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(loginConsumerGroup);
        consumer.setNamesrvAddr(namesrvAddress);
        consumer.subscribe(loginTopic, "*");
        consumer.setMessageListener(firstLoginMessageListener);
        consumer.start();
        return consumer;
    }

    /**
     * 订单退房消息
     *
     * @return 订单退房消息的consumer bean
     */
    @Bean(value = "orderFinishedConsumer")
    public DefaultMQPushConsumer finishedConsumer(@Qualifier(value = "orderFinishedMessageListener") OrderFinishedMessageListener orderFinishedMessageListener) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(orderFinishedConsumerGroup);
        consumer.setNamesrvAddr(namesrvAddress);
        consumer.subscribe(orderFinishedTopic, "*");
        consumer.setMessageListener(orderFinishedMessageListener);
        consumer.start();
        return consumer;
    }
}