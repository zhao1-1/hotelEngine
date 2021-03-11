package com.ruyuan.little.project.rocketmq.api.hotel.consumer;

import com.ruyuan.little.project.rocketmq.api.hotel.listener.HotelRoomUpdateMessageListener;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="mailto:little@163.com">little</a>
 * version: 1.0
 * Description:房间管理消费者消息
 **/
@Configuration
public class HotelRoomConsumerConfiguration {

    /**
     * namesrv address
     */
    @Value("${rocketmq.namesrv.address}")
    private String namesrvAddress;

    /**
     * 酒店房间topic
     */
    @Value("${rocketmq.hotelRoom.topic}")
    private String hotelRoomTopic;

    /**
     * 酒店房间数据监听的consumer group
     */
    @Value("${rocketmq.hotelRoom.consumer.group}")
    private String hotelRoomConsumerGroup;

    /**
     * 酒店客房消息的consumer bean
     *
     * @return 酒店客房消息的consumer bean
     */
    @Bean(value = "hotelRoomConsumer")
    public DefaultMQPushConsumer hotelRoomConsumer(HotelRoomUpdateMessageListener hotelRoomUpdateMessageListener) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(hotelRoomConsumerGroup);
        consumer.setNamesrvAddr(namesrvAddress);
        consumer.subscribe(hotelRoomTopic, "*");
        consumer.setMessageListener(hotelRoomUpdateMessageListener);
        consumer.start();
        return consumer;
    }
}