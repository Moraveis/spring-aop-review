package com.joao.springaopreview.aspect;

import com.joao.springaopreview.domain.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
        convertAccountNamesToUpperCase(result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        result.forEach(account -> {
            account.setName(account.getName().toUpperCase());
        });
    }

    @AfterThrowing(pointcut = "execution(* com.joao.springaopreview.dao.AccountDAO.findAccountsThrowException(..))", throwing = "exception")
    public void afterThrowingAccountsAdvice(JoinPoint joinPoint, Throwable exception) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);
        System.out.println("\n=====>>> The exception: " + exception);
    }

    // runs before after throw and executes regardless of the result success or failure(exception)
    @After("execution(* com.joao.springaopreview.dao.AccountDAO.findAccountsThrowException(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @After on method: " + method);
    }


}
