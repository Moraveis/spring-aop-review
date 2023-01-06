package com.joao.springaopreview.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.joao.springaopreview.dao.*.addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n====>>> Executing @before advice on any method start with add");
    }

    @Before("myPointCutMethod()")
    public void beforePointcut() {
        System.out.println("\n====>>> Executing @before advice for pointcut");
    }

    @Pointcut("execution(boolean com.joao.springaopreview.dao.MembershipDAO.addMember())")
    public void myPointCutMethod() {
    }
}
