package com.april2nd.live1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Food {

    // 왜 생성자 주입을 사용하는지 !!
    // Autowired는 3가지로 주입가능한데
    // 가장 쉬운 건 필드주입, 가장 권장하는건 생성자 주입.
    // 필드주입이나, setter주입은 순환 참조 가능성이 있다 !!

//    @Autowired // 필드 주입
    A a;

    // 생성자 선언 시 어노테이션 작성 없이도 자동으로 autowired 해준다 !!
//    public Food(A a) {
//        this.a = a;
//    }
    @Autowired // setter 주입
    public void setA(A a) {
        this.a = a;
    }


    @Resource(name = "m1")
    My my1;

    @Resource(name = "m2")
    My my2;

    void eat(){
        System.out.println("배고파 !!");
        a.hello();
        my1.run();
        my2.run();
    }
}
