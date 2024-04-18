package com.example.leaguemanagerapp.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {
    @Pointcut("execution(* com.example.leaguemanagerapp.service..*.*(..))")
    public void serviceMethods() {
    }

  /* @Before("serviceMethods()")
    public void logBeforeServiceMethod(JoinPoint joinPoint) {
        log.info("Before Method:" + joinPoint.getSignature().toShortString() + "; Trigger time: " + System.currentTimeMillis());
    }

    @After("serviceMethods()")
    public void logAfterServiceMethod(JoinPoint joinPoint) {
        log.info("After method: " + joinPoint.getSignature().toShortString() + "; Trigger time: " + System.currentTimeMillis());
    }*/

    @Around("serviceMethods()")
    public void loggingServiceMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info(" Around method:" + proceedingJoinPoint.getSignature().toShortString() + "; Before Trigger time:" + System.currentTimeMillis());
        proceedingJoinPoint.proceed();
        log.info("After the proceed:" + proceedingJoinPoint.getSignature().toShortString() + "; After Trigger time:" + System.currentTimeMillis());

    }
}
