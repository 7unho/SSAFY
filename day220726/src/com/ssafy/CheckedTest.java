package com.ssafy;

import java.io.FileNotFoundException;

public class CheckedTest {
    static void ssafy() throws ArrayIndexOutOfBoundsException {
        System.out.printf("SSAFY !!");
    }

    static void good() throws FileNotFoundException {
        System.out.printf("GOOD !!");
    }

    // main에서 throws 하면 main을 호출한 JVM에게 넘김
    // main 에서 throws 하게 되면 해당 exception은 체크하지 않겠다는 뜻이 된다.
    public static void main(String[] args) throws FileNotFoundException{
        ssafy();
        good();
    }
}
