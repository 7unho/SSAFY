package com.ssafy.modifier.poly;

public class PolySpiderTest {
    public static void main(String[] args) {
//        SpiderMan sman = new SpiderMan("peter parker", false);
//        SpiderMan sman2 = sman;
//
//        //com.ssafy.live2.extend.Person;
//        Person person = sman;
//        Object obj = person;

        // 뭐든지 담을 수 있는 만능 주머니
        Object[] objs = new Object[4];
//        objs[0] = sman;
        objs[1] = "hello";
        objs[2] = objs;
        objs[3] = 1; // 기본형인데 왜 될까 ??

    }
}
