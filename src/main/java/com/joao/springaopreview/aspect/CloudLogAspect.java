package com.joao.springaopreview.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CloudLogAspect {

    @Before("com.joao.springaopreview.aspect.SharedAopExpressions.combinedPointcutExpressions()")
    public void anotherAspectAdvice() {
        System.out.println("\n====>>> Executing @before advice for pointcut for new Aspect CloudLogAspect");
    }
}
