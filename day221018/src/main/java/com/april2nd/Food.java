package com.april2nd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Food {
    @Autowired
    A a;

    void eat(){
        System.out.println("배고파 !!");
        a.hello();
    }
}
