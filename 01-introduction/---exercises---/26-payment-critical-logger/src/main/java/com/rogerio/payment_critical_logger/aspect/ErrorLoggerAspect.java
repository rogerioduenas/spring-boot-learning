package com.rogerio.payment_critical_logger.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ErrorLoggerAspect {

  @AfterThrowing(
      pointcut = "execution(* com.rogerio.payment_critical_logger.service.PaymentService.*(..))",
      throwing = "error")
  public void logError(JoinPoint joinPoint, Throwable error) {
    String methodName = joinPoint.getSignature().getName();
    String errorMessage = error.getMessage();
    String redColor = "\u001B[31m";
    String resetColor = "\u001B[0m";

    System.out.printf("%s🚨 [SYSTEM ALERT] Method %s throws error: %s%s\n",
        redColor, methodName, errorMessage, resetColor);
  }
}
