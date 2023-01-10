package com.joao.springaopreview;

import com.joao.springaopreview.config.SpringConfig;
import com.joao.springaopreview.dao.AccountDAO;
import com.joao.springaopreview.dao.MembershipDAO;
import com.joao.springaopreview.domain.Account;
import com.joao.springaopreview.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(MembershipDAO.class.getName());

    public static void main(String[] args) throws Exception {
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
        List<Account> result = accountDAO.findAccounts();
        logger.info("Main Method result: " + result);

        try {
            accountDAO.findAccountsThrowException();
        } catch (Exception e) {
            logger.info("Main app got a exception" + e.getMessage());
        }

        // END @AFTER RETURN Aspect usage

        TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        logger.info(fortuneService.getFortune());

        logger.info(fortuneService.fortuneThrowException());

        context.close();
    }
}