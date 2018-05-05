package com.study.spring;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

public class Sender {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("rabbit-spring.xml");
        RabbitTemplate template = context.getBean("rabbitTemplate", RabbitTemplate.class);
        template.convertAndSend("foo.message", "Hello World");
        TimeUnit.SECONDS.sleep(5);
        context.close();
    }
}
