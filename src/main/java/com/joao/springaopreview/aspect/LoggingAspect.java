package com.joao.springaopreview.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* add*(com.joao.springaopreview.domain.Account))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n====>>> Executing @before advice on any method start with add");
    }
}
