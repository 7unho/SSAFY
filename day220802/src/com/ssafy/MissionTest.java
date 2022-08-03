package com.ssafy;

import java.util.*;

public class MissionTest {
    static class Person{
        public String name;
        public int age;
        public String job;
        public int score;

        public Person(String name, int age, String job, int score) {
            this.name = name;
            this.age = age;
            this.job = job;
            this.score = score;
        }

//        @Override
//        public int compareTo(Person o) {
//            // return값이 음수인 경우에 스왑해줌
//            // -> this.age < o.age
//
////        return this.age - o.age;
//
//            // 문자열의 경우 override 메서드를 사용 !
//
////        return this.name.compareTo(o.name);
//            return o.name.compareTo(this.name);
//        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", job='" + job + '\'' +
                    ", score=" + score +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[] su = {13, 8, 7, 10, 100, 5};

        for (int i = 0; i < su.length; i++) {
            int temp;
            for (int j = i + 1; j < su.length; j++) {
                if (su[j] < su[i]) {
                    temp = su[j];
                    su[j] = su[i];
                    su[i] = temp;
                }
            }
        }

        System.out.println("========= 미션 1 ========");
        System.out.println(Arrays.toString(su));

        System.out.println("========= 미션 2 ========");
        char[] ch = {'J', 'a', 'v', 'A'};
        String[] names = {"홍길동", "길라임", "김주원"};

        for (int i = 0; i < ch.length; i++) {
            char temp;
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[j] < ch[i]) {
                    temp = ch[j];
                    ch[j] = ch[i];
                    ch[i] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(ch));

//        for (int i = 0; i < names.length; i++) {
//            String temp;
//            for (int j = i + 1; j < names.length; j++) {
//                if(names[j] < names[i]) {
//                    temp = names[j];
//                    names[j] = names[i];
//                    names[i] = temp;
//                }
//            }
//        }
//        for (int i = 0; i < ch.length; i++) {
//            System.out.print(ch[i] + " ");
//        }
//        System.out.println();
        System.out.println("========= 미션 3 ========");

        //String은 comparable을 implements

        Person p = new Person("갓길동", 14, "학생", 95);

        Person[] persons = {p,
                new Person("빛길동", 24, "학생", 95),
                new Person("남길동", 52, "학생", 95),
                new Person("여길동", 25, "학생", 95),
                new Person("킹길동", 35, "학생", 95)};

        Arrays.sort(persons);

        System.out.println(Arrays.toString(persons));

        List<Person> list = new ArrayList<>();
        list.add(p);
        list.add(new Person("빛길동", 24, "학생", 95));
        list.add(new Person("남길동", 52, "학생", 95));
        list.add(new Person("여길동", 25, "학생", 95));
        list.add(new Person("킹길동", 35, "학생", 95));

        // list가 관리하는 클래스가 camparable 일 때,
//        Collections.sort(list);

        // list가 관리하는 클래스가 comparator 일 떄,
//        Collections.sort(list, new Person());
//        System.out.println(list.toString());

        // person을 age 오름차순으로 하되 같은 age의 경우 score로 sort
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.age == o2.age) return o1.score - o2.score;
                return o1.age - o2.age;
            }
        });

        // lambda
        Collections.sort(list, (o1, o2) -> {
           return (o1.age != o2.age) ? o1.age - o2.age : o1.score - o2.score;
        });

        System.out.println(list.toString());
    }
}

