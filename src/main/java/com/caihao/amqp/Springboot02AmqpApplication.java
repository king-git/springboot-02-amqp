package com.caihao.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 自动配置
 *
 * 1.RabbitAutoConfiguration
 * 2.有自动配置了连接工厂RabbitConnectionFactoryBean
 * 3.rabbitproperties 封装了rabbitmq 的配置
 * 4.rabbitTemplate：给rabbitMQ发送和接受消息
 * 5.AmqpAdmin：rabbitmq系统管理功能组件
 *  AmqpAdmin：创建和删除queue，exchange，binding
 *  6.@EnableRabbit 和 @RabbitListener 监听消息队列的内容
 */


@SpringBootApplication
@EnableRabbit //开启基于注解的rabbitmq模式
public class Springboot02AmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot02AmqpApplication.class, args);
    }

}
