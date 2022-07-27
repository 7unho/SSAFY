package com.ssafy;

class A{
    public void happy(){
        System.out.printf("happy !");
    }
}

class Child extends A {
    @Override
    public void happy(){
        System.out.printf("Child Happy!");
    }
}

class My{
    public static void print(A a){
        a.happy();
    }

    public static void go(Ssafy s){
        s.good();
    }
}

interface Ssafy{
    public void good();
}

public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        My.print(new A()
            //무명 extends A
            {
                @Override
                public void happy(){
                    System.out.printf("inner Happy");
                }
            }
        );

        A a = new Child();
        a.happy();

        // 무명 implements Ssafy
        My.go(new Ssafy() {
            @Override
            public void good() {
                System.out.println("아주 좋아요!");
            }
        });
    }
}
