package com.joao.springaopreview.aspect;

import com.joao.springaopreview.domain.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

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

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("Arg: " + arg);

            if (arg instanceof Account) {
                Account account = (Account) arg;
                System.out.println("Account: name=" + account.getName() + ", level=" + account.getLevel());
            }
        }
    }

    @AfterReturning(pointcut = "execution(* com.joao.springaopreview.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturnFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);
        System.out.println("\n=====>>> result: " + result);
    }
}
