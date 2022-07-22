package com.ssafy.ws.step3;

public class NameMenu2{
    static String[] names;
    final int MAX = 100;
    static int nameCnt;

    public static void addName(String name){
        System.out.println(">>>NameMenu2 추가");
        names[nameCnt++] = name;
    }

    public static void printInfo(){
        System.out.println("#이름목록");
        for (int i = 0; i < nameCnt; i++) {
            System.out.println(names[i]);
        }
    }

    public static void updateName(String before, String after){
        System.out.printf("before : %s, after : %s\n", before, after);
        for(int i = 0; i < nameCnt; i ++ ){
            if(before.equals(names[i])) {
                names[i] = after;
                return;
            }
        }
    }

    public static void deleteName(String name){
        for(int i = 0; i < nameCnt; i ++ ){
            if(name.equals(names[i])) {
                names[i] = names[nameCnt-1];
                nameCnt -= 1;
                return;
            }
        }
    }
}
