package com.ssafy.ws.step3;

import java.util.Scanner;

public class NameMenuTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userInput;

        while(true){
            printMenu();
            userInput = sc.nextInt();

            if (userInput == 5) break;

            switch (userInput){
                case 1:
                    System.out.printf("이름입력 : ");
                    NameMenu.addName(sc.next());
                    break;
                case 2:
                    NameMenu.printInfo();
                    break;
                case 3:
                    System.out.printf("기존이름입력 : ");
                    String before = sc.next();

                    System.out.printf("변경이름입력 : ");
                    String after = sc.next();

                    NameMenu.updateName(before, after);
                    break;
                case 4:
                    System.out.print("삭제이름입력 : ");
                    NameMenu.deleteName(sc.next());
                    break;
                default:
                    break;
            }

        }
        System.out.println("-- END --");

    }

    public static void printMenu(){
        System.out.println("<이름메뉴>");
        System.out.println("1.추가 2.검색 3.수정 4.삭제 5.종료");
        System.out.print("번호입력 ==> ");
    }
}
