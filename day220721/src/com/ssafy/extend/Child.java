package com.ssafy.extend;

public class Child extends Parent{
	//상속 ==> 부모가 갖는 모든 속성과 기능을 내것처럼 사용할 수 있음.
	//   ==>  상속제외) private멤버,생성자
	
	void callTest() {
	    m1();	
	    m2();	
	    m3();	
//	    m4();	//에러
	}
}


