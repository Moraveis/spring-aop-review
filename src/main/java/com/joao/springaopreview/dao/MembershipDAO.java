package com.joao.springaopreview.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addMember() {
        System.out.println(getClass() + ": Doing my DB work: adding membership account");
        return true;
    }
}
