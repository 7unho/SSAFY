package com.ssafy.modifier.p1;

public class SamePackageChildClass extends Parent {
    public void method(){
        this.publicVar = 10;
        this.protectVar = 10;
//        this.defaultVar = 10;
//        this.privateVar = 10;
    }
}
