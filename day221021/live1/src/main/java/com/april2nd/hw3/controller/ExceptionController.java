package com.april2nd.hw3.controller;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 컨트롤러 전역에서 발생하는 예외를 처리하는 부기가능을 가진 클래스(어드바이스)
@ControllerAdvice
public class ExceptionController {
	
//	private static Logger logger = LoggerFactory.getLogger(ExceptionController.class);
	
//	 예외를 어떻게 처리할지 정의
	 @ExceptionHandler(Exception.class)
	 public String handleException(Model model, Exception e) {
		 System.out.println("예외 발생" + e.getCause());
		
	 	// 파라미터 바인딩 예외 발생시
		// e의 instance가 BindException이라면 !
	 	if(e instanceof BindException) {
	 		model.addAttribute("message", "파라미터가 잘 등록되지 않았습니다." );
	 	}
		
	 	return "/hw3/error/errorpage";
	 }
	
}