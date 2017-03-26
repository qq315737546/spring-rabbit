package com.dingcheng.confirms.callback;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.stereotype.Service;

@Service("returnCallBackListener")
public class ReturnCallBackListener implements ReturnCallback {

	@Override
	public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
		String msgId = "";
		if (message.getMessageProperties().getCorrelationId() != null) {
			msgId = new String(message.getMessageProperties().getCorrelationId());
		}
		System.out.println("return--message: msgId:" + msgId + ",msgBody:" + new String(message.getBody())
				+ ",replyCode:" + replyCode + ",replyText:" + replyText + ",exchange:" + exchange + ",routingKey:"
				+ routingKey);
	}

}
