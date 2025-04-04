package com.jao.RabbitConsumer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.jao.RabbitConsumer.config.RabbitMQConfig;
import com.jao.RabbitConsumer.model.Models;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConsumerListener {
	
	@RabbitListener(queues = RabbitMQConfig.QUEUE_CLIENT)
	public void redClientMsg(Models.Client client) {
		log.info("ConsumerListener:::Receiving client:::: "+client.getFullName(),client);
		
	}
	
	@RabbitListener(queues = RabbitMQConfig.QUEUE_ORDER)
	public void redOrdertMsg(Models.Order order) {
		log.info("ConsumerListener:::Receiving order:::: "+order.getProductDesc(),order);
	}

}
