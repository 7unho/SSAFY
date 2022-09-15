package com.april2nd.live;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener, Runnable {
    //프레임 Center ---> JTextArea (서버가 보낸 메시지를 출력)
    //프레임 South  ---> JTextField (서버에게 보낼 메시지)

    JTextArea ta;//JScrollPane필요한 컴포넌트: JList, JTable, JTextArea
    JScrollPane scroll_ta;

    JTextField tf_send;
    JButton bt_change;//대화명변경

    JPanel southp;

    OutputStream out;//소켓쓰기
    BufferedReader in;//소켓읽기

    public ChatClient() {
        setTitle("대화방");
        ta = new JTextArea();
        ta.setFont(new Font("굴림체", Font.BOLD, 20));
        ta.setLineWrap(true);//너비(가로)를 넘어가는 텍스트가 있다면 자동으로 줄바꿈 
        scroll_ta = new JScrollPane(ta);//스크롤바가 지원되는 TextArea!!
        tf_send = new JTextField(15);
        tf_send.setFont(new Font("굴림체", Font.BOLD, 20));

        bt_change = new JButton("대화명변경");
      /*
        - 최초 대화명 '길동이'
        - 대화시도  : ta출력==>  [길동이]▶ 안녕하세요  
        
        <미션>
        - '대화명변경'버튼 클릭시
            ---> 입력대화상자 보이기
            ---> '변경대화명:'입력   ==> 나길동
            ---> 대화시도 : ta출력  ==> [나길동]▶ 안녕하세욧!! 
       */

        southp = new JPanel();
        southp.add(tf_send);
        southp.add(bt_change);

        add("Center", scroll_ta);//ta);
        add("South", southp);//tf_send);

        setBounds(300, 200, 600, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        connectProcess();//in,out객체생성
        new Thread(this).start();//in객체 사용

        String nickName = JOptionPane.showInputDialog(this, "대화명:");

        //최초 대화명 전달!!
        toServer("100|" + nickName);

        tf_send.addActionListener(this);
        bt_change.addActionListener(this);
    }//생성자

    @Override
    public void actionPerformed(ActionEvent e) {
        Object ob = e.getSource();

        if (ob == tf_send) {//텍스트필드에 엔터가 입력되었을때
            String msg = tf_send.getText();
            if (msg.length() == 0) {//빈값(빈문자열 체크)
                return;
            }
            // 5. 메시지 보내기
            toServer("200|" + msg);
            tf_send.setText("");

        } else if (ob == bt_change) {//대화명변경 버튼 클릭시
            String cNickName = JOptionPane.showInputDialog(this, "변경대화명:");

            // ==> 서버와 클라이언트와의 약속 ( 프로토콜 정의 )
            //     100 : 대화명, 200 : 메시지, 300 : 새로운 대화명
            toServer("300|" + cNickName);
        }
    }//actionPerformed

    public void connectProcess() {//서버소켓과 연결하는 작업
        try {
            Socket s = new Socket("localhost", 8080);//★3. 서버소켓 연결

            //★4.  소켓 입출력 객체생성
            out = s.getOutputStream();
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }//connectProcess

    public void toServer(String msg) {//서버에게 메시지 보내기
        try {
            out.write((msg + "\n").getBytes());//★5. 메시지 보내기 write
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//toServer

    @Override
    public void run() {//스레드 사용이유? GUI와 상관없이(동시에) 서버가 보내는 메시지를 대기해야 하기때문
        try {
            while (true) {
                String msg = in.readLine();//★8. 서버가 보낸 (소켓을 통해 전달된)메시지 읽기
                ta.append(msg + "\n");
                ta.setCaretPosition(ta.getText().length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//run


    public static void main(String[] args) {
        new ChatClient();
    }//main


}


