package com.ssafy;

import java.io.InputStreamReader;

public class ExceptionTest2_sub {
   public static void main(String[] args) {//String[] args={"10", "5"}
	                                       //String[] args={"10"}
                                           //String[] args={"ab", "cd"}
	 /*
	    <매개변수 값>
	    args[0]       args[1]
	      10            5
	      10
	      10            0
	      ab            cd  
	  */
	 //RuntimeException(UncheckedException)의 경우 조건문을 통해 문제를 해결할 수 있음	   
	   
	      if(args.length<2) {
	    	 System.out.println("##두개의 정수를 입력하세요!!");
	    	 return;
	      }else if(!args[0].matches("[0-9]+") || !args[0].matches("[\\d]+")) {
	    	 System.out.println("##숫자만 입력하세요!!");
	    	 return;
	      }else if(args[1]=="0") {
	    	 System.out.println("##0으로 나눌 수 없습니다!!");
	    	 return;
	      }
	      
		  System.out.println("매개변수로 받은 두개의 정수");	 
		  int a = Integer.parseInt(args[0]);  //ArrayIndexOutOfBoundsException, NumberFormatException 발생가능성
		  int b = Integer.parseInt(args[1]);  //ArrayIndexOutOfBoundsException, NumberFormatException 발생가능성
		  System.out.println("a="+a+", b="+b); 
		  System.out.println("a를 b로 나눈 몫 = "+ (a/b)); //ArithmeticException 발생가능성
		  System.out.println("나눗셈을 원활히 수행하였습니다.");


	  
   }//main
}//end class












