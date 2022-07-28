package com.ssafy.node;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class NodeDiarytest {
    private void writeDiary(){
        File target = new File(File.separator + "Users" +
                                         File.separator + "unknownflower" +
                                         File.separator + "Desktop" +
                                         File.separator + "workspace" +
                                         File.separator + "Java" +
                                         File.separator + "day220728" +
                                         File.separator + "src" +
                                         File.separator + "com" +
                                         File.separator + "ssafy" +
                                         File.separator + "node" +
                                         File.separator + "test.txt");

        try(Scanner sc = new Scanner(System.in)){
            FileWriter writer = new FileWriter(target, true);
            FileReader reader = new FileReader(target);{
                System.out.println("일기를 작성합니다. 그만두려먼 x를 입력하세요 .");
                writer.write("\n오늘 날짜 : " + new Date() + "\n");

                while(true){
                    String line = sc.nextLine();
                    if(line.equals("x")){
                        break;
                    }else{
                        writer.write(line + "\n");
                    }
                }

                System.out.println("일기 저장 완료");

                char[] buffer = new char[10];
                int read = -1;
                while ((read = reader.read(buffer)) > 0){
                    System.out.println(new String(buffer, 0, read));
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        NodeDiarytest use = new NodeDiarytest();

        use.writeDiary();
    }
}
