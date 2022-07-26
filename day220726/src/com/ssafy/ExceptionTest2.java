package com.ssafy;

public class ExceptionTest2 {
    public static void main(String[] args) {

        // regular expression
        //if(!args[0].matches("[0-9]+") || !args[0].matches("[\\d]+")

        // ArrayIndexOutOfBoundsException
        // NumberFormatException            발생 가능성⬆ ️
        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);

            System.out.printf("a= %d, b= %d\n", a, b);

            // ArithmeticException              발생 가능성⬆ ️
            System.out.printf("a / b : %d\n", a/b);

        } catch (ArrayIndexOutOfBoundsException e){
            System.err.println("두 개의 정수를 입력하세요 !");
        } catch (NumberFormatException e){
            e.printStackTrace();
        } catch (ArithmeticException e){
            e.printStackTrace();
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
