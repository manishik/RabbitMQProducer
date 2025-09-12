package com.manish.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manish.model.Employee;

@Service
public class RabbitMQSender {

	private static final Logger logger = LoggerFactory.getLogger(RabbitMQSender.class);

	@Autowired
	private AmqpTemplate amqpTemplate;

	public void send(Employee employee) {
		amqpTemplate.convertAndSend("manish-direct-exchange", "manishQ", employee);
		logger.info("Send msg = " + employee);

	}
}