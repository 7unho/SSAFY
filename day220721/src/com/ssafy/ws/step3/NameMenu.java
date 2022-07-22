package com.ssafy.ws.step3;

public class NameMenu {
    static String[] names = new String[5];

    public static void addName(String name){
        for (int i = 0; i < 5; i ++ ){
            if (names[i] == null) {
                names[i] = name;
                return;
            }
        }
    }

    public static void printInfo(){
        System.out.println("#이름목록");
        for (String name: names) {
            if(name != null) System.out.println(name);
        }
    }

    public static void updateName(String before, String after){
        System.out.printf("before : %s, after : %s\n", before, after);
        for(int i = 0; i < 5; i ++ ){
            if(names[i].equals(before)) {
                names[i] = after;
                return;
            }
        }
    }

    public static void deleteName(String name){
        for(int i = 0; i < 5; i ++ ){
            if(names[i].equals(name)) {
                names[i] = null;
                return;
            }
        }
    }
}
