package com.joao.springaopreview.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@Order(3)
public class ApiAnalyticsAspect {

    private final Logger logger = Logger.getLogger(ApiAnalyticsAspect.class.getName());

    @Before("com.joao.springaopreview.aspect.SharedAopExpressions.combinedPointcutExpressions()")
    public void anotherAspectAdvice() {
        System.out.println("\n====>>> Executing @before advice for pointcut for new Aspect ApiAnalyticsAspect");
    }
}
