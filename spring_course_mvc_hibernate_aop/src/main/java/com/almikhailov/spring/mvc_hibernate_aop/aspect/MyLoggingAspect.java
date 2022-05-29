package com.almikhailov.spring.mvc_hibernate_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Aspect
@Component
public class MyLoggingAspect {

    @Around("execution (* com.almikhailov.spring.mvc_hibernate_aop.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();

        System.out.println("begin of " + methodName);

        Object targetMethodResult = proceedingJoinPoint.proceed();
        System.out.println("End of " + methodName);

        return targetMethodResult;
    }
}
