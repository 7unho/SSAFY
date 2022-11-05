package com.ssafy.hw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



//@RestController // ==> Controller +  ResponseBody 메소드
//@RequestMapping("/controller")
public class BookController {

	@RequestMapping("/m1")
	@ResponseBody 
	public String m1() {
		return "hello"; //hello.jsp 포워드
	}
	
	
	@RequestMapping("/m2")
	public @ResponseBody String m2() {
		return "ssafy"; //ssafy데이터 응답
	}
	
	@RequestMapping("/m3")
	@ResponseBody 
	public String m3() {
		return "good"; //good.jsp 포워드
	}
	
	
	@RequestMapping("/m4")
	@ResponseBody
	public String m4() {
		return "samsung"; //samsung데이터 응답
	}
	
}
