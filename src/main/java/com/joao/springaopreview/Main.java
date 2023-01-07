package com.joao.springaopreview;

import com.joao.springaopreview.config.SpringConfig;
import com.joao.springaopreview.dao.AccountDAO;
import com.joao.springaopreview.dao.MembershipDAO;
import com.joao.springaopreview.domain.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        // @BEFORE Aspect usage

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        accountDAO.addAccount();

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        membershipDAO.addMember();

        accountDAO.addAccount(new Account("Joao", "Basic"));

        accountDAO.addAccount(new Account("Joao", "Basic"), true);

        accountDAO.setName("foobar");
        accountDAO.setServiceCode("silver");

        String name = accountDAO.getName();
        String serviceCode = accountDAO.getServiceCode();

        // END @BEFORE Aspect usage

        // @AFTER RETURN Aspect usage
        List<Account> result =  accountDAO.findAccounts();
        System.out.println("Main Method result: " + result);

        // END @AFTER RETURN Aspect usage

        context.close();
    }
}