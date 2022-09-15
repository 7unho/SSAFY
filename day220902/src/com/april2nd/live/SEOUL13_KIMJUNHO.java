package com.april2nd.live;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SEOUL13_KIMJUNHO {
    static final String NICKNAME = "SEOUL13_KIMJUNHO";
    static final String HOST = "127.0.0.1";

    static final int PORT = 1447;
    static final int CODE_SEND = 9901;
    static final int CODE_REQUEST = 9902;
    static final int SIGNAL_ORDER = 9908;
    static final int SIGNAL_CLOSE = 9909;

    // 게임 환경 상수
    static final int TABLE_WIDTH = 254;
    static final int TABLE_HEIGHT = 127;
    static final int NUMBER_OF_BALLS = 6;
    static final int[][] HOLES = {{0, 0}, {127, 0}, {254, 0}, {0, 127}, {127, 127}, {254, 127}};

    public static void main(String[] args) {
        Socket socket = null;
        String recv_data = null;
        byte[] bytes = new byte[1024];
        float[][] balls = new float[NUMBER_OF_BALLS][2];
        int order = 0;

        try{
            socket = new Socket();
            System.out.println("Trying Connect : " + HOST + ":" + PORT);
            socket.connect(new InetSocketAddress(HOST, PORT));
            System.out.println("Connected: " + HOST + ":" + PORT);

            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            String send_data = CODE_SEND + "/" + NICKNAME + "/";
            bytes = send_data.getBytes("UTF-8");
            os.write(bytes);
            os.flush();
            System.out.println("Ready to play!\n------------------");

            while(socket != null){
                // Receive Daty
                bytes = new byte[1024];
                int count_byte = is.read(bytes);
                recv_data = new String(bytes, 0, count_byte, "UTF-8");
                System.out.println("Data Received: " + recv_data);

                // Read Game Data
                String[] split_data = recv_data.split("/");
                int idx = 0;
                try{
                    for (int i = 0; i < NUMBER_OF_BALLS; i++) {
                        for (int j = 0; j < 2; j++) {
                            balls[i][j] = Float.parseFloat(split_data[idx++]);
                        }

                    }
                } catch (Exception e){
                    bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
                    os.write(bytes);
                    os.flush();
                    System.out.println("Received Data has been currupted, Resend Requested. ");
                    continue;
                }

                // Check Signal for Player Order or Close Connection
                if(balls[0][0] == SIGNAL_ORDER){
                    order = (int)balls[0][1];
                    System.out.println("\n You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
                    continue;
                } else if(balls[0][0] == SIGNAL_CLOSE){
                    break;
                }

                // Show Balls' Position
                for (int i = 0; i < NUMBER_OF_BALLS; i++) {
                    System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
                }

                float angle = 0.0f;
                float power = 0.0f;

                float whiteBall_X = balls[0][0];
                float whiteBall_Y = balls[0][1];

                float targetBall_X = balls[1][0];
                float targetBall_Y = balls[1][1];

                float width = Math.abs(targetBall_X - whiteBall_X);
                float height = Math.abs(targetBall_Y - whiteBall_Y);

                double radian = height > 0? Math.atan(width / height): 0;
                angle = (float) ((180.0 / Math.PI) * radian);

                if(whiteBall_X == targetBall_X){
                    if(whiteBall_Y < targetBall_Y) angle = 0;
                    else angle = 180;
                }
                else if (whiteBall_Y == targetBall_Y){
                    if(whiteBall_X < targetBall_X) angle = 90;
                    else angle = 270;
                }

                if(whiteBall_X > targetBall_X && whiteBall_Y > targetBall_Y){
                    radian = Math.atan(width / height);
                    angle = (float) (((180.0 / Math.PI) * radian) + 180);
                }
                else if(whiteBall_X < targetBall_X && whiteBall_Y > targetBall_Y){
                    radian = Math.atan(height / width);
                    angle = (float) (((180.0 / Math.PI) * radian) + 90);
                }

                double distance = Math.sqrt((width * width) + (height * height));
                power = (float) distance;

                String merged_data = angle + "/" + power + "/";
                bytes = merged_data.getBytes("UTF-8");
                os.write(bytes);
                os.flush();
                System.out.println("Data Sent : " + merged_data);
            }

            os.close();
            is.close();
            socket.close();
            System.out.println("Connection Closed. \n-------------");
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
