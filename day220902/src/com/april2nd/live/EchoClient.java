package com.april2nd.live;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) throws Exception {
        // 3. 서버 접속 요청 70.12.50.120
        // new Socket(String host, int port);
        Socket s = new Socket("70.12.50.120", 5000);
//        Socket s = new Socket("localhost", 8080);
        System.out.println("서버 접속 성공 !!");

        // 4. 소켓을 통한 입출력 ( 통신 )을 위한 객체 생성
        OutputStream out = s.getOutputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

        // 6. 메시지 읽기 read
        String fromMsg = in.readLine();
        System.out.println("서버로부터 받은 데이터 >> " + fromMsg);

        // 7. 메시지 보내기 write
        String toMsg = "교수님 짱 ! !!";
        out.write(toMsg.getBytes());
    }
}
