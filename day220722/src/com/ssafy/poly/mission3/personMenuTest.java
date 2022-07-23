package com.ssafy.poly.mission3;

import java.util.Scanner;

public class personMenuTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userInput;
        PersonMenu pm = new PersonMenu();

        while(true){
            printMenu();
            userInput = sc.nextInt();

            if (userInput == 5) break;

            switch (userInput){
                case 1: {
                    String name, job;
                    int age;

                    System.out.print("이름 : ");
                    name = sc.next();

                    System.out.print("나이 : ");
                    age = sc.nextInt();

                    System.out.print("직업 : ");
                    job = sc.next();

                    pm.insert(name, age, job);
                    break;
                }
                case 2:
                    pm.select();
                    break;
                case 3:{
                    int afterNo, afterAge;
                    String afterJob;

                    System.out.print("수정할 번호 : ");
                    afterNo = sc.nextInt();

                    System.out.print("나이 : ");
                    afterAge = sc.nextInt();

                    System.out.print("직업 : ");
                    afterJob = sc.next();

                    pm.update(afterNo, afterAge, afterJob);

                    break;
                }
                case 4:{
                    int no;
                    System.out.print("삭제할 번호 : ");
                    no = sc.nextInt();

                    pm.delete(no);
                    break;
                }

            }
            System.out.println("== END ==");
        }
    }

    public static void printMenu(){
        System.out.println("<이름메뉴>");
        System.out.println("1.추가 2.검색 3.수정 4.삭제 5.종료");
        System.out.print("번호입력 ==> ");
    }
}
