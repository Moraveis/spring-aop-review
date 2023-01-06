package com.joao.springaopreview.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SharedAopExpressions {

    @Pointcut("execution(* com.joao.springaopreview.dao.*.*(..))")
    public void forDaoPackage() {
    }

    @Pointcut("execution(* com.joao.springaopreview.dao.*.get*(..))")
    public void getter() {
    }

    @Pointcut("execution(* com.joao.springaopreview.dao.*.set*(..))")
    public void setter() {
    }

    @Pointcut("forDaoPackage() && !(getter()  || setter())")
    public void combinedPointcutExpressions() {
    }

    @Pointcut("execution(boolean com.joao.springaopreview.dao.MembershipDAO.addMember())")
    public void myPointCutMethod() {
    }
}
