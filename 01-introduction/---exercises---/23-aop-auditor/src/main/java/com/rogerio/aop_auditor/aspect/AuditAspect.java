package com.rogerio.aop_auditor.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Aspect
@Component
public class AuditAspect {

  @Before("execution(* com.rogerio.aop_auditor.controller.FinanceController.getRevenue(..))")
  public void logBefore(JoinPoint joinPoint) {
    String formatedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    System.out.printf("[LOG] [%s]: - Action: Revenue consulted | Method: %s \n", formatedDate, joinPoint.getSignature().getName());
  }
}
