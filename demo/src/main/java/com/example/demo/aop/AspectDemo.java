package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectDemo {

    @Pointcut("execution(* com.example.demo.service..*.*(..))")
    public void demoPointcut(){

    }

    @Pointcut("execution(* com.example.demo.service.impl.ServiceBImpl.*(..))")
    public void demoPointcutB(){

    }

    @Around("demoPointcut()")
    public Object doAround(ProceedingJoinPoint jp) throws Throwable{
        System.out.println("doAround");
        return jp.proceed();
    }

    @Around("demoPointcutB()")
    public Object doAround2(ProceedingJoinPoint jp) throws Throwable{
        System.out.println("doAround2");
        return jp.proceed();
    }
}
