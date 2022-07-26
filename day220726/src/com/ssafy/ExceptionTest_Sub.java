package com.ssafy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionTest_Sub {

    public static void main(String[] args) {
        //a.txt 파일을 읽어서 콘솔에 출력
        /*
        * <입출력 4대 클래스>

        * Stream -> 연속된 바이트의 흐름.

        *   InputStream         OutputStream        <== 바이트 단위
        * ===================================
        *     Reader                Write           <== 문자 단위
대표 메서드      read()                write()
        *
        * */

        // 정석은 root 폴더 기준으로 전체경로 할당해주는게 기본이지만,
        // ide 툴에서만 현재 프로젝트까지의 경로는 생략이 가능해서 a.txt로 선언.
//        FileReader fr = new FileReader("/Users/unknownflower/Desktop/workspace/Java/day220726/a.txt");

        // try에서 선언된 fr의 close를 보장해준다 !
        try(FileReader fr = new FileReader("day220726/a.txt");){
            int ch;

            ch = fr.read();

            while((ch = fr.read()) != -1){
                System.out.println((char)ch);
            }

        } catch (FileNotFoundException e){
            System.out.println(e.toString());
            System.out.println(e);
            System.out.println(e.getMessage());
            e.printStackTrace();
            return;
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
        System.out.printf(">>> 마지막 문장 !");
    }
}