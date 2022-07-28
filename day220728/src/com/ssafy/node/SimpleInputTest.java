package com.ssafy.node;

import java.io.*;

public class SimpleInputTest {
    private String data1 = "자바는 객체지향 언어입니다.";
    private void read2(){
        byte[] buffer = new byte[10];
        try(InputStream input = new ByteArrayInputStream(data1.getBytes())){
            int read = -1;
            while((read = input.read(buffer)) > 0){
                System.out.printf("읽은 개수 : %d, 문자열 : %s\n", read, new String(buffer));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void read3(){
        char[] buffer = new char[data1.length()];
        try(Reader input = new CharArrayReader(data1.toCharArray())){
            int read = -1;
            while((read = input.read(buffer)) > 0){
                System.out.printf("읽은 개수 : %d, 문자열 : %s\n", read, new String(buffer, 0, read));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        SimpleInputTest st = new SimpleInputTest();
        st.read2();
        st.read3();
    }
}
