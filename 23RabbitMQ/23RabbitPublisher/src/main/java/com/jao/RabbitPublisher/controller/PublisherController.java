package com.jao.RabbitPublisher.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jao.RabbitPublisher.config.RabbitMQConfig;
import com.jao.RabbitPublisher.model.Models;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path="publish")
@RequiredArgsConstructor
public class PublisherController {
	
	private final RabbitTemplate rabbitTemplate;
	
	@PostMapping(path="order")
	public String postMethodName(@RequestBody Models.Order order) {
		this.rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY_ORDER, order);
		
		return "Order:::OK";
	}
	
	@PostMapping(path="client")
	public String postMethodName(@RequestBody Models.Client client) {
		this.rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY_CLIENT, client);
		
		return "Client:::OK";
	}
}
