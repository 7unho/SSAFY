package com.ssafy.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
    static void dataPrint(List<String> list) {
        for (int i = 0; i < list.size(); i++ ) {
            System.out.println("index : " + i + ", 데이터 : " + list.get(i));
        }
    }
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();

        list1.add("길동");
        list1.add("주원");
        list1.add("라임");
        list1.add(0, "김유신");
        dataPrint(list1);
        System.out.println("===============");

        LinkedList<String> list2 = new LinkedList<>();
        list2.add("싸피");
        list2.add("8기");
        list2.add("13반");
        dataPrint(list2);


        System.out.println("ArrayList vs LinkedList 속도 테스트");
        System.out.println("===============");
        long start, end;

        start = System.currentTimeMillis();
        ArrayList<Person> list3 = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            list3.add(new Person());
        }

        end = System.currentTimeMillis();
        System.out.println("총 소요 시간 : " + (end - start));

        start = System.currentTimeMillis();
        LinkedList<Person> list4 = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            list4.add(new Person());
        }
        end = System.currentTimeMillis();
        System.out.println("총 소요 시간 : " + (end - start));


        System.out.println("=========================");
        System.out.println("재 인덱싱 테스트");

        start = System.currentTimeMillis();
        ArrayList<Person> list5 = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            list5.add(0, new Person());
        }

        end = System.currentTimeMillis();
        System.out.println("총 소요 시간 : " + (end - start));

        start = System.currentTimeMillis();
        LinkedList<Person> list6 = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            list6.add(0, new Person());
        }
        end = System.currentTimeMillis();
        System.out.println("총 소요 시간 : " + (end - start));



    }
}