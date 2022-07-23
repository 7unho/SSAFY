package com.ssafy.poly.mission3;


public class PersonMenu {
    final int MAX = 100;
    Person[] persons = new Person[MAX];
    static int personCnt;

    public void insert(String name, int age, String job){
        Person param = new Person(
                (personCnt + 1),
                name,
                age,
                job
        );
        persons[personCnt++] = param;
    }
    public void update(int no, int age, String job){
        for (int i = 0; i < personCnt; i++) {
            if(persons[i].getNo() == no){
                persons[i].setNo(no);
                persons[i].setAge(age);
                persons[i].setJob(job);
            }
        }
    }
    public void select(){
        System.out.println("#사람목록");
        for (int i = 0; i < personCnt; i++) {
            System.out.println(persons[i].toString());
        }
    }
    public void delete(int no){
        for (int i = 0; i < personCnt; i++) {
            if(persons[i].getNo() == no){
                persons[i] = persons[personCnt - 1];
                personCnt -= 1;
            }
        }
    }


}
