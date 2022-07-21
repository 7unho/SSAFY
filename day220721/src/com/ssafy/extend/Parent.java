package com.ssafy.extend;

public class Parent {//베이스 클래스
   public    void m1() {} //다른 패키지 접근
   protected void m2() {} 
            //같은 패키지 접근,다른 패키지에 있는 자식클래스 접근
             void m3() {m4();} //같은 패키지 접근
   private   void m4() {} //같은 클래스 접근
}
