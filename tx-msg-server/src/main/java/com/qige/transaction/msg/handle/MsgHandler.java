package com.qige.transaction.msg.handle;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MsgHandler {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${mq.msg.exchange}")
    private String exchange;

    public void send(String routingkey, String jsonMsg){
        this.rabbitTemplate.convertAndSend(this.exchange,routingkey, jsonMsg);
    }
}
