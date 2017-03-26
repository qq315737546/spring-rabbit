package com.dingcheng.confirms.publish;

import java.util.UUID;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("rabbitTemplatePublishService")
public class RabbitTemplatePublishService {
	@Autowired
	private RabbitTemplate rmqpTemplate;

	public void send(String exchange, String routingKey, Object obj) {
		String msgId = UUID.randomUUID().toString();
		Message message = MessageBuilder.withBody(obj.toString().getBytes())
				.setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN)
				.setCorrelationId(msgId.getBytes()).build();
		CorrelationData date = new CorrelationData(msgId);
		// TODO 将 msgId 与 message 的关系保存起来,例如放到缓存中
		rmqpTemplate.send(exchange, routingKey, message, date);
	}
}
