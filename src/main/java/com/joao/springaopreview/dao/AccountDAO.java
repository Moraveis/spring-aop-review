package com.joao.springaopreview.dao;

import com.joao.springaopreview.domain.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public void addAccount() {
        System.out.println(getClass() + ": Doing my DB work: adding account");
    }

    public void addAccount(Account account) {
        System.out.println(getClass() + ": Add Account with values: " + account);
    }

    public void addAccount(Account account, boolean active) {
        System.out.println(getClass() + ": Add Account with values: " + account + ", active: " + active);
    }

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
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
