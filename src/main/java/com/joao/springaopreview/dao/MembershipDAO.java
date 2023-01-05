package com.joao.springaopreview.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addAccount() {
        System.out.println(getClass() + ": Doing my DB work: adding membership account");
    }
}
