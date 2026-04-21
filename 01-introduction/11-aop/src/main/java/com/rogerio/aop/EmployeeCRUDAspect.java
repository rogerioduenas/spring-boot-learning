package com.rogerio.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeCRUDAspect {

  @Before("execution(* EmployeeManager.getEmployeeById(..))")     //point-cut expression
  public void logBeforeV1(JoinPoint joinPoint) {
    System.out.println("EmployeeCRUDAspect.logBeforeV1() : " + joinPoint.getSignature().getName());
  }

  @AfterReturning(pointcut = "execution(* EmployeeManager.getEmployeeById(..))", returning = "result")
  public void logAfterReturningV1(JoinPoint joinPoint, Object result) {
    System.out.println("EmployeeCRUDAspect.logAfterReturningV1() : " + result);
  }
}
