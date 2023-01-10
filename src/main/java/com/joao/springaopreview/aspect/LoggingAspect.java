package com.joao.springaopreview.aspect;

import com.joao.springaopreview.domain.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    /*
    @Before("execution(* com.joao.springaopreview.dao.*.addAccount())")
    public void beforeAddAccountAdvice() {
        logger.info("\n====>>> Executing @before advice on addAccount method");
    }
    */

    /*
    @Before("com.joao.springaopreview.aspect.SharedAopExpressions.myPointCutMethod()")
    public void beforePointcut() {
        logger.info("\n====>>> Executing @before advice for pointcut");
    }
    */

    @Before("com.joao.springaopreview.aspect.SharedAopExpressions.combinedPointcutExpressions()")
    public void applyingCombinedPointcut(JoinPoint joinPoint) {
        logger.info("\n====>>> Executing @before advice for pointcut for new Aspect LoggingAspect");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        logger.info("Method: " + methodSignature);

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            logger.info("Arg: " + arg);

            if (arg instanceof Account) {
                Account account = (Account) arg;
                logger.info("Account: name=" + account.getName() + ", level=" + account.getLevel());
            }
        }
    }

    @AfterReturning(pointcut = "execution(* com.joao.springaopreview.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturnFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n=====>>> Executing @AfterReturning on method: " + method);
        logger.info("\n=====>>> result: " + result);
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
        logger.info("\n=====>>> Executing @AfterThrowing on method: " + method);
        logger.info("\n=====>>> The exception: " + exception);
    }

    // executes regardless of the result success or failure(exception)
    @After("execution(* com.joao.springaopreview.dao.AccountDAO.findAccountsThrowException(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n=====>>> Executing @After on method: " + method);
    }

    //
    @Around("execution(* com.joao.springaopreview.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info("\n=====>>> Executing @Around on method: " + method);

        long start = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long stop = System.currentTimeMillis();

        long duration = stop - start;
        logger.info("\n=====>>> Duration: : " + (duration / 1000.0) + " seconds.");

        return result;
    }

    @Around("execution(* com.joao.springaopreview.service.*.fortuneThrowException(..))")
    public Object aroundHandleFortuneException(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info("\n=====>>> Executing @Around on method: " + method);

        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            logger.warning(e.getMessage());
            result = "Reconnection...";
        }

        return result;
    }

    @Around("execution(* com.joao.springaopreview.service.*.fortuneThrowAnotherException(..))")
    public Object aroundThrowFortuneException(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info("\n=====>>> Executing @Around on method: " + method);

        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            logger.warning(e.getMessage());
            throw e;
        }

        return result;
    }

}
