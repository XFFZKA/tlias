package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
//@Aspect
@Slf4j
public class TimeAspect {
    //开始时间
    @Around("execution(* com.itheima.service.*.*(..))")   //切入点表达式
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();
        log.info(joinPoint.getSignature()+"方法执行: {} ms", end - start);
        return result;
    }
}
