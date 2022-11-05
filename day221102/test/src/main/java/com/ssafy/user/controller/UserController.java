package com.ssafy.user.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.user.model.dto.User;
import com.ssafy.user.model.service.UserService;

@Controller
public class UserController {
	
	UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}

	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@PostMapping("/login")
	public String doLogin(User user, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		User loginUser = service.userSelect(user.getId());
		if(loginUser != null && loginUser.getPwd().equals(user.getPwd())) {
			session.setAttribute("loginUser", loginUser);
			String remember = request.getParameter("remember");
			
			if(remember != null) {
				Cookie cookie = new Cookie("savedId", user.getId());
				   cookie.setPath(request.getContextPath());
				   cookie.setMaxAge(60*60*24*30);
				response.addCookie(cookie);
				
			}else {
				Cookie cookie = new Cookie("savedId", user.getId());
				   cookie.setPath(request.getContextPath());
				   cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			return "redirect:/index";
		}
		else if(loginUser != null && !loginUser.getPwd().equals(user.getPwd())) {
			request.setAttribute("msg", "비밀번호를 확인해주세요");
			return "login";
		}
		else {
			request.setAttribute("msg", "아이디를 확인해주세요");
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String doLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}
	
	@GetMapping("/findpw")
	public String showFindPw() {
		return "findpw";
	}
	
	@PostMapping("/findpw")
	public String findPw(HttpServletRequest request, HttpServletResponse response, HttpSession session, String id) {
		session.removeAttribute("foundUser");
		User user = service.userSelect(id);
		if(user == null) {
			request.setAttribute("msg", "아이디를 찾지 못했습니다.");
			return "findpw";
		}
		else {
			session.setAttribute("foundUser", user);
			return "redirect:/QnA";
		}
	}
	
	@GetMapping("/QnA")
	public String showQnA() {
		return "QnA";
	}
	
	@PostMapping("/QnA")
	public String QnA(String answer, HttpServletRequest request, HttpSession session) {
		User user = (User) session.getAttribute("foundUser");
		if(user.getAnswer().equals(answer)) {
			session.removeAttribute("foundUser");
			request.setAttribute("msg", "비밀번호는 ["+user.getPwd()+"]입니다.");
			return "index";
		}
		request.setAttribute("msg", "비밀번호 찾기 답이 틀렸습니다.");
		return "QnA";
	}
	
	@GetMapping("/regist")
	public String showRegist() {
		return "regist";
	}
	
	@PostMapping("/regist")
	public String regist(User user, HttpServletRequest request) {
		if(service.userSelect(user.getId()) != null) {
			request.setAttribute("msg", "회원 등록 실패: "+user.getId()+"은(는) 이미 사용중인 아이디입니다.");
			return "regist";
		}
		if(user.getPwd().length() < 6) {
			request.setAttribute("msg", "비밀번호는 반드시 6자 이상 입력되어야 합니다.");
			return "regist";
		}
		if(service.regist(user) == 1) {
			request.setAttribute("msg", "회원 등록 성공!");
			return "index";
		}
		else {
			request.setAttribute("msg", "입력을 확인해주세요");
			return "regist";
		}
	}
	
	@GetMapping("/editProfile")
	public String showEditProfile(HttpServletRequest request) {
		return "editProfile";
	}
	
	@GetMapping("/editPwd")
	public String editPwd(HttpSession session) {
		session.setAttribute("state", "editPwd");
		return "editProfile";
	}
	
	@PostMapping("/editProfile")
	public String editProfile(HttpSession session, User user, HttpServletRequest request) {
		String pwd = request.getParameter("pwd");
		String editPwd = request.getParameter("editPwd");
		String editPwd2 = request.getParameter("editPwd2");
		
		User loginUser = (User) session.getAttribute("loginUser");
		loginUser.setName(user.getName());
		loginUser.setAddress(user.getAddress());
		loginUser.setTel(user.getTel());
		if(session.getAttribute("state") == null) {
			session.removeAttribute("state");
			service.modify(loginUser);
			session.setAttribute("loginUser", loginUser);
			request.setAttribute("msg", "회원 정보 수정 성공!");
			return "index";
		}
		else {
			if(pwd == null || editPwd == null || editPwd2 == null || pwd.length()<6 || editPwd.length()<6 || editPwd2.length()<6) {
				request.setAttribute("msg", "비밀번호는 반드시 6자 이상 입력되어야 합니다.");
				return "editProfile";
			}
			else if(!user.getPwd().equals(pwd)) {
				request.setAttribute("msg", "현재 비밀번호가 틀렸습니다.");
				return "editProfile";
			}
			else if(!editPwd.equals(editPwd2)) {
				request.setAttribute("msg", "변경 비밀번호가 일치하지 않습니다.");
				return "editProfile";
			}
			else {
				loginUser.setPwd(editPwd);
				service.modify(loginUser);
				request.setAttribute("msg", "회원 정보 수정 성공!");
				session.setAttribute("loginUser", loginUser);
				return "index";
			}
		}
	}
	
	@GetMapping("/profile")
	public String showProfile(HttpSession session) {
		return "profile";
	}
	
	@GetMapping("/withdraw")
	public String showWithdraw() {
		return "withdraw";
	}
	
	@PostMapping("/withdraw")
	public String showWithdraw(HttpSession session, HttpServletRequest request) {
		User loginUser = (User) session.getAttribute("loginUser");
		String pwd = request.getParameter("pwd");
		if(pwd.length() < 6) {
			request.setAttribute("msg", "비밀번호는 6자 이상입니다.");
			return "withdraw";
		}
		else if(pwd == null || !pwd.equals(loginUser.getPwd())) {
			request.setAttribute("msg", "비밀번호를 확인해주세요");
			return "withdraw";
		}
		else {
			service.remove(loginUser.getId());
			session.invalidate();
			request.setAttribute("msg", "회원탈퇴 완료!");
			return "index";
		}
	}
}

