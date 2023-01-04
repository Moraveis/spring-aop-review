package com.joao.springaopreview;

import com.joao.springaopreview.config.SpringConfig;
import com.joao.springaopreview.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        accountDAO.addAccount();

        context.close();
    }
}