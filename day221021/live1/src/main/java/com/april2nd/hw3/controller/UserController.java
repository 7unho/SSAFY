package com.april2nd.hw3.controller;

import java.util.ArrayList;
import java.util.List;

import com.april2nd.hw3.model.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


// 이 클래스가 컨트롤러 임을 어노테이션으로 설정, 컴포넌트 스캔을 통해 빈으로 등록
@Controller
public class UserController {
	
	/**
	 * '/' 또는 '/index' 요청이 get 방식으로 들어왔을 때 index로 연결한다.
	 * @return
	 */
	@GetMapping({"/hw3", "/hw3/index" })
	public String showIndex() {
		return "hw3/index";
	}
	
	 /**
	  * '/regist' 요청이 get 방식으로 들어왔을 때 regist로 연결한다.
	  * @return
	  */

	 // @RequestMapping(value="/hw3/regist", method = RequestMethod.GET)
	 @GetMapping("/hw3/regist")
	 public String showRegistForm() {
	 	return "hw3/regist";
	 }

	 /**
	  * '/regist' 요청이 post 방식으로 들어왔을 때 전달된 User 객체를 regist_result로 연결한다.
	  * @param user
	  * @return
	  */
	 @PostMapping("/hw3/regist")
	 public String doRegist(Model model, User user) {
	 	// 전달할 객체
	 	model.addAttribute("user" , user);
	 	return "hw3/regist_result";
	 }
	
	 /**
	  * '/list' 요청이 get 방식으로 들어왔을 때 User List를 Model에 담아서 list로 연결한다.
	  * @return
	  */
	 @GetMapping("/hw3/list")
	 public void showList(Model model) {
	 	// 아직 DB에 연결하지 않았으므로 임의로 사용자 정보 4개를 생성해서 list에 담아 전달한다.
	 	List<User> list = new ArrayList<User>();
	 	list.add(new User("ssafy1", "1234", "김싸피", "ssafy1@ssafy.com", 26));
	 	list.add(new User("ssafy2", "1234", "박싸피", "ssafy2@ssafy.com", 26));
	 	list.add(new User("ssafy3", "1234", "이싸피", "ssafy3@ssafy.com", 26));
	 	list.add(new User("ssafy4", "1234", "강싸피", "ssafy4@ssafy.com", 26));
		
	 	model.addAttribute("users", list);
	 }
	
	 /**
	  * '/error/404' 요청이 get 방식으로 들어왔을때 보여줄 페이지
	  * 매핑된 주소를 처리하는 메서드가 존재하지 않을시 표시할 에러 페이지이다.
	  */
	 @GetMapping("/hw3/error/404")
	 public void showError404(Model model) {
	 	// 404 Not Found 처리
		 model.addAttribute("msg", "해당 페이지를 찾을 수 없습니다 !");
	 }
}
