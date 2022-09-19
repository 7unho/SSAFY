package com.live1.live1.member.controller;

import com.live1.live1.member.model.service.MemberService;
import com.live1.live1.member.model.service.MemberServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService;

	public void init(){
		memberService = MemberServiceImpl.getMemberService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String path = "/index.jsp";

		switch (act){
			case "mvjoin":
				path = "/user/join.jsp";
				redirect(request, response, path);
				break;
			case "idcheck":
				int cnt  = idCheck(request, response);
				response.setContentType("text/plain;charset=utf-8");
				PrintWriter out = response.getWriter();

				out.println(cnt);
				break;
			default:
				redirect(request, response, path);
				break;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException{
		response.sendRedirect(request.getContextPath() + path);
	}

	// -- front controller

	private int idCheck(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("userid");
		try {
			int count = memberService.idCheck(userId);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 500;
	}

}
