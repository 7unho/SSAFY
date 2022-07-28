package com.ssafy.node;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UseFileStream {
    public static void main(String[] args) {
        UseFileStream st = new UseFileStream();
        // 프로젝트와 무관하게 파일을 찾을 때 : 절대경로
        File readMe = new File("/Users/unknownflower/Desktop/workspace/Java/day220728/src/com/ssafy/node/test.txt");
        System.out.println("readme.txt : " + readMe.exists());

        // 프로젝트 내부에서 파일을 찾을 때
        // 이클립스에선 src가아닌 bin을 포함한 경로로 설정해준다 => 소스파일이 아닌 실행파일 위주이므로 !!
        readMe = new File("./day220728/src/com/ssafy/node/test.txt");
        System.out.println("readme.txt : " + readMe.exists());

        // 특정 클래스 기준으로 파일을 찾을 때
        readMe = new File(UseFileStream.class.getResource("test.txt").getFile());
        System.out.println("readme.txt : " + readMe.exists());

        System.out.printf("buffer size : %d, time = %d\n", 1000, st.fileMove(1000));
    }

    public long fileMove(int bufferSize){
        long start = System.currentTimeMillis();

        File src = new File("./day220728/src/com/ssafy/node/test.txt");
        File target = new File("./day220728/src/com/ssafy/node/target.txt");

        try(FileInputStream fin = new FileInputStream(src)){
            FileOutputStream fout = new FileOutputStream(target);
            byte[] buffer = new byte[bufferSize];
            int read = 0;
            while((read = fin.read(buffer)) > 0){
               fout.write(buffer, 0, read);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return System.currentTimeMillis() - start;
    }
}
