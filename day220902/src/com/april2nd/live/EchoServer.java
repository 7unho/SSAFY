package com.april2nd.live;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws Exception {

        // 1. 서버소켓 객체생성
        // 실행되는 현재 JVM PC의 IP와 Port 번호
        ServerSocket ss = new ServerSocket(8080);

        // 2. 클라이언트 접속 대기
        System.out.println("서버 시작 [접속 대기 중]....");
        while(true) {
            try{
                Socket s = ss.accept();
                System.out.println("클라이언트 접속 성공 ! :D");

                System.out.println(s.getInetAddress().getHostAddress());

                // 4. 소켓을 통한 입출력 ( 통신 )을 위한 객체 생성
                OutputStream out = s.getOutputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

                // 5. 메시지 보내기 write
                String toMsg = "일타싸피 만점 받으세요 ~!\n";
                out.write(toMsg.getBytes());

                String fromMsg = in.readLine();
                System.out.println("클라이언트로부터 받은 데이터 >> " + fromMsg);
            } catch (IOException e){
//                System.out.println(e.getStackTrace());
            }
        }
    }
}
