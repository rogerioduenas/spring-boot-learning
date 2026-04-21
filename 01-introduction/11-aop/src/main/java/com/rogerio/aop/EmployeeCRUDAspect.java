package com.rogerio.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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

  @After("execution(* EmployeeManager.getEmployeeById(..))")
  public void logAfterV1(JoinPoint joinPoint) {
    System.out.println("EmployeeCRUDAspect.logAfterV1() : The method " + joinPoint.getSignature().getName() + " has been finished");
  }

  @Around("execution(* EmployeeManager.getEmployeeById(..))")
  public Object logAroundV1(ProceedingJoinPoint joinPoint) throws Throwable {
    System.out.println("EmployeeCRUDAspect.logAroundV1() [BEFORE] : " + joinPoint.getSignature().getName());

    try {
      Object result = joinPoint.proceed();
      System.out.println("EmployeeCRUDAspect.logAroundV1() [AFTER] : Returned -  " + result);
      return result;

    } catch (Throwable e) {
      System.out.println("EmployeeCRUDAspect.logAroundV1() [ERROR] : " + e.getMessage());
      throw e;
    }
  }
}
