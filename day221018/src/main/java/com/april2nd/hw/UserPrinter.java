package com.april2nd.hw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserPrinter {

    @Autowired
    User user;

    public void printUserRank(){
        System.out.println("I'm " + user.getRank() + "user.");
    }
}
