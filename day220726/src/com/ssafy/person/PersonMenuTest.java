package com.ssafy.person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonMenuTest {
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       PersonMenu menu = new PersonMenu();	
       
       menu://라벨설정
       while(true) {	
		System.out.println("<사람메뉴>");
		System.out.println("1.추가 2.검색 3.수정 4.삭제 5.종료");
		System.out.print("번호입력==> ");
		int num = scan.nextInt();
		
		System.out.println();
		switch(num) {
		   case 1: {
			       System.out.print("이름: ");
			       String name = scan.next();
			       System.out.print("나이: ");
			       int age = scan.nextInt();
			       System.out.print("직업: ");
			       String job = scan.next();

			       //3개의 (서로관련성있는)데이터를 한개의 변수로 묶어주기
//			       Person p = new Person();
//			           p.setName(name);
//			           p.setAge(age);
//			           p.setJob(job);

			       Person p = new Person(name, age, job);
			       
//			       menu.insert(name,age,job);
			       menu.insert(p);
		           }break;
		   case 2: {
			         List<Person> persons = menu.select();
			         //사람정보 출력 
			         System.out.println("#사람목록");
			         for(int i=0; i<persons.size(); i++) {
			      	   System.out.println(persons.get(i));
			         } 
		           }break;
		           
		   case 3: {
				       System.out.print("수정할 번호: ");
				       int upNo = scan.nextInt();
				       System.out.print("나이: ");
				       int age = scan.nextInt();
				       System.out.print("직업: ");
				       String job = scan.next();
		
				       Person p = new Person(upNo, null, age, job);
		   
			          menu.update(p);
		            }break;
		   case 4: 
                   System.out.print("삭제할 번호: ");
                   int delNo = scan.nextInt();
			       menu.delete(delNo);
			       break;
			       
		   case 5: break menu;//라벨영역 벗어나기
		}
		System.out.println();
		  //if(num==5) break;
       }//while       
       scan.close();
       
       System.out.println("-- END --");
	}//main
}
