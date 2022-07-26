package com.ssafy.person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonMenu {//기능정의 (CRUD)

    final int MAX = 100;
	//Person을 담을 배열정의, 데이터(Person) 저장소

	List<Person> persons = new ArrayList<>(); //고정배열
    // persons = {null, null, null, null, null,....}

	int no;


    public void insert(Person p) {//Create
        if (persons.size() < MAX) {
			persons.add(new Person(
					++no,
					p.getName(),
					p.getAge(),
					p.getJob()
			));
		}
    }//insert

    public List<Person> select() {//Read   List에 저장된 Person정보 전달
        return persons;
    }//select

    public void update(Person newPerson) {//Update
        //수정할 Person찾기 (upNo를 통해)
        for (int i = 0; i < persons.size(); i++) {
            Person oldPerson = persons.get(i);
            if (oldPerson.getNo() == newPerson.getNo()) {
                oldPerson.setAge(newPerson.getAge());
                oldPerson.setJob(newPerson.getJob());
                break;//no는 중복되지 않기 때문에
            }
        }
    }//update

    public void delete(int delNo) {//Delete
        for (int i = 0; i < persons.size(); i++) {
            Person oldPerson = persons.get(i);
            if (oldPerson.getNo() == delNo) {
                persons.remove(i);
                break;//no는 중복되지 않기 때문에
            }
        }
    }//delete

}
