package com.joao.springaopreview.dao;

import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class MembershipDAO {

    private final Logger logger = Logger.getLogger(MembershipDAO.class.getName());

    public boolean addMember() {
        logger.info(getClass() + ": Doing my DB work: adding membership account");
        return true;
    }
}
