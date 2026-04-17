package com.rogerio.primary.anotation;

import com.rogerio.primary.anotation.primaryWithBean.Employee;
import com.rogerio.primary.anotation.primaryWithComponent.model.Manager;
import com.rogerio.primary.anotation.primaryWithComponent.service.ManagerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		var context = SpringApplication.run(Application.class, args);

    Employee employee = context.getBean(Employee.class);
    System.out.println(employee);

    ManagerService service = context.getBean(ManagerService.class);
    Manager manager = service.getManager();
    System.out.println(manager.getManagerName());
	}

}
