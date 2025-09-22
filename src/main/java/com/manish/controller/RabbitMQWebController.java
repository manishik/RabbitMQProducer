package com.manish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manish.model.Employee;
import com.manish.service.RabbitMQSender;

@RestController
@RequestMapping(value = "/manish-rabbitmq/")
public class RabbitMQWebController {

	@Autowired
	RabbitMQSender rabbitMQSender;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("empName") String empName, @RequestParam("empId") String empId,
			@RequestParam("salary") int salary) {

		Employee employee = new Employee();
		employee.setEmpId(empId);
		employee.setEmpName(empName);
		employee.setSalary(salary);
		rabbitMQSender.send(employee);

		return "Message sent to the RabbitMQ Successfully with Employee Name " + empName;
	}

}
