package com.ssafy.modifier.p2;

import com.ssafy.modifier.p1.Parent;
public class OtherPackageChildClass extends Parent{
    public void method(){
        this.protectVar = 10;
        this.protectVar = 10;
//        this.defaultVar= 10;
//        this.privateVar = 10;
    }
}
