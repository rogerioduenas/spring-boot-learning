package com.rogerio.aop_auditor_performance.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

  @Around("execution(* com.rogerio.aop_auditor_performance.service.ReportService.fakeHeavyMethod(..))")
  public Object fakeHeavyMethod(ProceedingJoinPoint pjp) throws Throwable {
    long start = System.currentTimeMillis();

    try {
      Object result = pjp.proceed();
      long end = System.currentTimeMillis();

      long duration = end - start;
      System.out.printf("fakeHeavyMethod: %d ms\n", duration);

      return result;

    } catch (Throwable e) {
      long end = System.currentTimeMillis();
      System.out.printf("[PERFORMANCE - ERROR] Method %s failed after %dms.%n",
          pjp.getSignature().getName(),
          (end - start));
      throw e;
    }
  }
}
