package com.april2nd.hw;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("singleton")
public class VipUser implements User{

    @Override
    public String getRank(){
        return "Vip";
    }
}
