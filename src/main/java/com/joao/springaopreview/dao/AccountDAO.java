package com.joao.springaopreview.dao;

import com.joao.springaopreview.domain.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
public class AccountDAO {

    private final Logger logger = Logger.getLogger(AccountDAO.class.getName());

    private String name;
    private String serviceCode;

    public void addAccount() {
        logger.info(getClass() + ": Doing my DB work: adding account");
    }

    public void addAccount(Account account) {
        logger.info(getClass() + ": Add Account with values: " + account);
    }

    public void addAccount(Account account, boolean active) {
        logger.info(getClass() + ": Add Account with values: " + account + ", active: " + active);
    }

    public String getName() {
        logger.info(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        logger.info(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        logger.info(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        logger.info(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    public List<Account> findAccounts() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("First", "Basic"));
        accounts.add(new Account("Second", "Intermediate"));
        accounts.add(new Account("Third", "Advanced"));

        return accounts;
    }

    public List<Account> findAccountsThrowException() throws Exception {
        throw new Exception("Something was wrong");
    }
}
