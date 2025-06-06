package com.jao.RabbitPublisher.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	public static final String EXCHANGE = "message_exchange";
	public static final String ROUTING_KEY_CLIENT = "client_routing_key";
	public static final String ROUTING_KEY_ORDER = "ordert_routing_key";
	
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(EXCHANGE);
	}
	
	@Bean
	public MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public AmqpTemplate amqpTemplate(ConnectionFactory connection) {
		final var template=new RabbitTemplate(connection);
		template.setMessageConverter(messageConverter());
		return template;
	}
	
}
