package com.joao.springaopreview.dao;

import com.joao.springaopreview.domain.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount() {
        System.out.println(getClass() + ": Doing my DB work: adding account");
    }

    public void addAccount(Account account) {
        System.out.println(getClass() + ": Add Account with values");
    }
}
