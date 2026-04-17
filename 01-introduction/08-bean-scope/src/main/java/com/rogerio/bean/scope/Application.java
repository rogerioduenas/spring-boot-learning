package com.rogerio.bean.scope;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    var context = SpringApplication.run(Application.class, args);

    Person singletonA = context.getBean("personSingleton", Person.class);
    Person singletonB = context.getBean("personSingleton", Person.class);

    singletonA.setName("Mike");

    System.out.println(singletonA.getName());
    System.out.println(singletonB.getName());

    Person prototypeA = context.getBean("personPrototype", Person.class);
    Person prototypeB = context.getBean("personPrototype", Person.class);

    prototypeA.setName("João");
    prototypeB.setName("Maria");

    System.out.println(prototypeA.getName());
    System.out.println(prototypeB.getName());
  }

}
