package com.ssafy.modifier.p1;

public class SamePackageSomeClass {
    public void method(){
        Parent p = new Parent();
        p.publicVar = 10;
        p.defaultvar = 20;
        p.protectVar = 30;
//        p.privateVar = 40;
    }
}
