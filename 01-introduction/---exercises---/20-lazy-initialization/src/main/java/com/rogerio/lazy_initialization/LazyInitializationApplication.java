package com.rogerio.lazy_initialization;

import com.rogerio.lazy_initialization.service.ServiceA;
import com.rogerio.lazy_initialization.service.ServiceB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LazyInitializationApplication {

	public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(LazyInitializationApplication.class, args);

    ServiceA serviceA = context.getBean(ServiceA.class);
    ServiceB serviceB = context.getBean(ServiceB.class);

    serviceA.executeA();
    serviceB.executeB();
	}

}
