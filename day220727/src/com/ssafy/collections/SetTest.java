package com.ssafy.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        // Set : 중복 데이터 제거, 순서기 없다 ( 인덱스가 없다 ) , null 허용 ?
        Set<String> set = new HashSet<>();
        set.add("Hello");
        set.add(new String("Hello"));
        set.add("TEST");
        set.add(null);
        set.add(null);

        System.out.println(set);
        System.out.println(set.size());

        // 모든 요소를 출력하고 싶을 때
        System.out.println("==========");
        for (String str : set) {
            System.out.println(str);
        }

        // 모든 요소를 출력 2
        System.out.println("==========");
        Iterator<String> it = set.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // 모든 요소를 출력 3

        System.out.println("==========");
        Object[] ob = set.toArray();

        String[] strArr = new String[set.size()];
        set.toArray(strArr);

        for (int i = 0; i < strArr.length; i++) {
            System.out.printf("%d : %s\n", i, strArr[i]);
        }
    }
}
