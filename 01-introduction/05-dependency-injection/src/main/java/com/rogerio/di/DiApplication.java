package com.rogerio.di;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DiApplication {
	public static void main(String[] args) {
		SpringApplication.run(DiApplication.class, args);
	}

  @Bean
  public CommandLineRunner testIocByConstructor(Car car) {
    return args -> {
      System.out.println(car);
    };
  }

  @Bean
  public CommandLineRunner testIocBySetter(Motorcycle motorcycle) {
    return args -> {
      System.out.println(motorcycle);
    };
  }

}
