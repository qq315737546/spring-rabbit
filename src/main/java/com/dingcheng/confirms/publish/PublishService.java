package com.dingcheng.confirms.publish;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("publishService")
public class PublishService {
    @Autowired  
    private AmqpTemplate amqpTemplate; 
    
    public void send(String exchange, String routingKey, Object message) {  
    	amqpTemplate.convertAndSend(exchange, routingKey, message);
    }  
}
