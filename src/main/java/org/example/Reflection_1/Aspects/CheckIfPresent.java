package org.example.Reflection_1.Aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class CheckIfPresent {

    @Pointcut("execution(* org.example.Reflection_1.Aspects.test.*.*(..))")
    public void p1(){
    }
    @Pointcut("execution(* org.example.Reflection_1.Aspects.test.*.*(..))")
    public void p2(){
    }

    @Around("p1()")
    public void beforeCheck(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("initial : " + joinPoint.getSignature().getDeclaringType().getSimpleName());
        joinPoint.proceed();
    }

    @After("p2()")
    public void afterCheck(JoinPoint joinPoint){
        System.out.println("finish - " + joinPoint.getSignature().getDeclaringType().getSimpleName());
    }



}
