package util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect


public class MyAspectAnno {
    @Before("execution(* dao.AccountDao.*(..))")
    public void myBeFore(JoinPoint joinPoint){
        System.out.println("method strat:"+joinPoint.getSignature().getName());
    }
    @AfterReturning("execution(* dao.AccountDao*(..))")
    public void myAfterReturn(JoinPoint joinPoint){
        System.out.println("method afterReturn"+joinPoint.getSignature().getName());
    }
    @AfterThrowing(value = "execution(* dao.AccountDao.search*(..))",throwing = "th")
    public void myAfterThrow(JoinPoint joinPoint,Throwable th){
        System.out.println(th+"Exception was thrown in "+joinPoint.getSignature().getName());
    }
}
