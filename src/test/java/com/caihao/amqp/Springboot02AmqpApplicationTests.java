package com.caihao.amqp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot02AmqpApplicationTests {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void contextLoads() {

        Map<String,Object> map =  new HashMap<>();

        map.put("msg","这是第一个消息测试");
        map.put("datas",Arrays.asList("helloword",123,true));
        rabbitTemplate.convertAndSend("exchange.direct","atguigu",map);

    }

    @Test
    public void recMsg(){

        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");

    }

}
