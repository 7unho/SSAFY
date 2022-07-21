package com.ssafy.modifier.p2;

import com.ssafy.modifier.p1.Parent;
public class OtherPackageSomeClass {
    public void method(){
        Parent p = new Parent();
        p.publicVar = 10;
//        p.defaultvar = 20;
//        p.protectVar = 30;
//        p.privateVar = 40;
    }
}
