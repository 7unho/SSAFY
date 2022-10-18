package com.april2nd.live1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

public class Server implements Runnable {
    //외부클래스: 1.소켓을 통한 접속서비스(접속대기)
    //          2.접속한 클라이언트를 관리(Vector통해)

    ServerSocket ss;
    Vector<Service> v; //접속한 클라이언트 관리

    public Server() {
        System.out.println("Server Start......");
        v = new Vector<>();
        try {
            ss = new ServerSocket(8080);//★1. 서버소켓 객체생성
            new Thread(this).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//외부클래스 생성자

    public void run() {//여러 클라이언트 접속에 대한 대기
        try {
            while (true) {
                Socket s = ss.accept();//★2. 클라이언트 접속대기  (클라이언트 프로그램: new Socket()과 매핑)
                //Service serv = new Service(s);
                //v.add(serv);
                v.add(new Service(s));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//외부 run

    //---------------------------------------------------------------------------
    class Service extends Thread {//내부클래스: 소켓을 통한 입출력 서비스
        //※ Service객체 한개 == 클라이언트 한개!!

        BufferedReader in;//소켓통해 읽기
        OutputStream out;//소켓에 쓰기

        String clientAddr;
        String nickName;

        public Service(Socket s) {

            try {
                //★4 소켓 입출력 객체 생성
                in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                out = s.getOutputStream();
				nickName = in.readLine();
                clientAddr = s.getInetAddress().getHostAddress();
                start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }//내부클래스 생성자

        public void run() {//클라이언트가 보내는 여러메시지를 읽어주는 기능

            try {
                while (true) {
                    String msg = in.readLine();//★6. 클라이언트가 tf를 통해 보낸 메시지 읽기
                    StringTokenizer st = new StringTokenizer(msg, "|");
                    String printMsg;
                    switch (st.nextToken()){
                        case "100":
                            nickName = st.nextToken();
                            System.out.println("### [" + nickName + "]님이 입장하셨습니다.###");
                            messageAll("### [" + nickName + "]님이 입장하셨습니다.###");
                            break;
                        case "200":
                            printMsg = st.nextToken();
                            System.out.println("[" + nickName + "]>>>" + printMsg);
                            messageAll("[" + nickName + "] >>>" + printMsg);
                            break;
                        case "300":
                            String cNickName = st.nextToken();
                            printMsg = "###[" + nickName + "]님이 [" + cNickName + "]님으로 이름변경했습니다.";
                            System.out.println(printMsg);
                            messageAll(printMsg);
                            nickName = cNickName;
                            break;
                    }
                    //msg ==> "100|홍길동"   "200|안녕하세요"
                    //모니터링
                }
            } catch (IOException e) {
                //e.printStackTrace();
                System.out.println("[#클라이언트 접속 끊음]");
            }

        }//내부run

        public void messageTo(String msg) throws IOException {
            //특정 클라이언트에게 메시지 보내기
            out.write((msg + "\n").getBytes());//★7. 실제 클라이언트에게 메시지 보내기
        }//messageTo

        public void messageAll(String msg) {
            //접속한 모든 클라이언트에게 메시지 보내기
            for (int i = 0; i < v.size(); i++) {//전체 클라이언트(Service벡터)
                //i=0길동    1라임      2주원     3유신

                Service serv = v.get(i);
                try {
                    serv.messageTo(msg);
                } catch (IOException e) {
                    //에러발생  ----> 클라이언트 접속 끊음!!(소켓은 사라졌지만 Service객체가 벡터에존재)
                    v.remove(i--);//접속끊긴 클라이언트를 벡터에서 삭제!!
                    //e.printStackTrace();
                    System.out.println("[#클라이언트 접속 끊음]");
                }
            }//for

        }//messageAll


    }//내부클래스 end
    //---------------------------------------------------------------------------

    public static void main(String[] args) {
        new Server();
    }
}
