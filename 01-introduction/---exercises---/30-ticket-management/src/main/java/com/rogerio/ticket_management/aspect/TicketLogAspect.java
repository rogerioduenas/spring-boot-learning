package com.rogerio.ticket_management.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Aspect
@Component
public class TicketLogAspect {

  @After("execution(* com.rogerio.ticket_management.service.TicketService.close(..))")
  public void closeTicket(JoinPoint joinPoint) {
    System.out.printf("The ticket id %s has been closed at %s%n",
        joinPoint.getArgs()[0],
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
  }
}
