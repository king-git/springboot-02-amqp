package com.caihao.amqp;

import com.caihao.amqp.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.DirectExchange;
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

    @Autowired
    private AmqpAdmin amqpAdmin;

    //单播
    @Test
    public void contextLoads() {

        Map<String,Object> map =  new HashMap<>();

        map.put("msg","这是第一个消息测试");
        map.put("datas",Arrays.asList("helloword",123,true));
        //rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",map);
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",new Book("springboot高级","蔡浩"));

    }

    @Test
    public void recMsg(){
        //接收消息
        //Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        //System.err.println("o.class===="+o.getClass());
        //System.err.println("o.===="+o);

        //rabbitTemplate.receiveAndConvert("atguigu.emps");
        rabbitTemplate.receiveAndConvert("atguigu");
        //rabbitTemplate.receiveAndConvert("caihao.news");


    }



    //广播
    @Test
    public void  sendmsg(){

        rabbitTemplate.convertAndSend("exchange.fanout","",new Book("三国演义","罗贯中"));
    }





    public void createExchange(){
        //创建exchange交换器
        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
        System.err.println("创建完成======");
    }

 

}
