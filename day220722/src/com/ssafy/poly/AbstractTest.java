package com.ssafy.poly;

class A {
    static void draw(Shape s){
        s.draw();
    }
}

public class AbstractTest {
    public static void main(String[] args) {
        A.draw(new Rectangle());
        A.draw(new Circle());
        A.draw(new Triangle());
    }
}
