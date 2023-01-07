package com.joao.springaopreview.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    /*
    @Before("execution(* com.joao.springaopreview.dao.*.addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n====>>> Executing @before advice on addAccount method");
    }
    */

    /*
    @Before("com.joao.springaopreview.aspect.SharedAopExpressions.myPointCutMethod()")
    public void beforePointcut() {
        System.out.println("\n====>>> Executing @before advice for pointcut");
    }
    */

    @Before("com.joao.springaopreview.aspect.SharedAopExpressions.combinedPointcutExpressions()")
    public void applyingCombinedPointcut(JoinPoint joinPoint) {
        System.out.println("\n====>>> Executing @before advice for pointcut for new Aspect LoggingAspect");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method: " + methodSignature);
    }
}
