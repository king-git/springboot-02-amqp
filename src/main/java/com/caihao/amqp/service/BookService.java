package com.caihao.amqp.service;

import com.caihao.amqp.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author CaiHao
 * @create 2019-09-05 17:10:24
 */
@Service
public class BookService {

    @RabbitListener(queues = {"atguigu.news"})
    public void receive(Book book){

        System.err.println("收到消息==="+book);

    }


    @RabbitListener(queues = {"atguigu"})
    public void  receive2(Message message){
        byte[] body = message.getBody();
        MessageProperties messageProperties = message.getMessageProperties();
        
        System.err.println("body======"+body);
        System.err.println("messageProperties======"+messageProperties);

    }


}
