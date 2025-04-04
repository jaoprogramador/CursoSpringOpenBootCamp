package com.jao.RabbitConsumer.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
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
	public static final String QUEUE_CLIENT  = "client_queue";
	public static final String QUEUE_ORDER = "order_queue";
	
	@Bean
	public Queue queueClient() {
		return new Queue(QUEUE_CLIENT);
	}
	
	@Bean
	public Queue queueOrder() {
		return new Queue(QUEUE_ORDER);
	}
	
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(EXCHANGE);
	}
	
	@Bean
	public Binding bindingCliente(Queue queueClient ,TopicExchange topicExchange) {
		return BindingBuilder
				.bind(queueClient)
				.to(topicExchange)
				.with(ROUTING_KEY_CLIENT);
	}
	
	@Bean
	public Binding bindingOrder(Queue queueOrder ,TopicExchange topicExchange) {
		return BindingBuilder
				.bind(queueOrder)
				.to(topicExchange)
				.with(ROUTING_KEY_ORDER);
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
