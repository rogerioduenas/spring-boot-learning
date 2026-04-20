package com.rogerio.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AopApplication.class, args);

    EmployeeManager manager = context.getBean(EmployeeManager.class);

    manager.getEmployeeById(1);
	}

}
