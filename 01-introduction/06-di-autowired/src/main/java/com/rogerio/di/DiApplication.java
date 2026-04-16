package com.rogerio.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiApplication {
	public static void main(String[] args) {
		SpringApplication.run(DiApplication.class, args);

    ApplicationContext context = SpringApplication.run(DiApplication.class, args);
    Car car = context.getBean(Car.class);
    System.out.println(car);
  }

}
