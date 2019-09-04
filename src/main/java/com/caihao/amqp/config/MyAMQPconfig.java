package com.caihao.amqp.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author CaiHao
 * @create 2019-09-04 下午 17:48:57
 */
@Configuration
public class MyAMQPconfig {

    //消息类型转换器
    @Bean
    public MessageConverter myMessageConverter(){

        //将默认的转换器改成json转换器
        Jackson2JsonMessageConverter messageConverter = new Jackson2JsonMessageConverter();

        return messageConverter;

    }


}
