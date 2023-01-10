package com.joao.springaopreview.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@Order(1)
public class CloudLogAspect {

    private final Logger logger = Logger.getLogger(CloudLogAspect.class.getName());

    @Before("com.joao.springaopreview.aspect.SharedAopExpressions.combinedPointcutExpressions()")
    public void anotherAspectAdvice() {
        logger.info("\n====>>> Executing @before advice for pointcut for new Aspect CloudLogAspect");
    }
}
