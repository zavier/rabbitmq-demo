package com.study.workqueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class WorkPublisher {
    private static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // 参数依次为：队列名称、持久化、连接专用、自动删除（无消费者时）、其他属性
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World!";
        // 参数依次为 exchange、routingKey(路由键)、其他属性、消息体
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}
