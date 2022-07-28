package com.ssafy.serial;

import java.io.*;

public class ObjectStreamTest {
    private static File target =  new File("./day220728/src/com/ssafy/node/target.txt");

    private static void write(){
        Person p = new Person("홍길동2", "pass1234", "123-456", "seoul");

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(target))){
            out.writeObject(p);
            System.out.println("저장 !");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void read(){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(target))){
            Object obj = in.readObject();

            if(obj != null && obj instanceof Person) {
                Person p = (Person)obj;
                System.out.println(p);
            }
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        write();
        read();
    }
}
