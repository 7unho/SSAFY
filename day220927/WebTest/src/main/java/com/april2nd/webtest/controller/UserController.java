package com.april2nd.webtest.controller;

import com.april2nd.webtest.dto.User;
import com.april2nd.webtest.model.service.UserService;
import com.april2nd.webtest.model.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserController", value = "/user")
public class UserController extends HttpServlet {
    public UserServiceImpl userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // doGet = FORM method : POST 이외의 모든 요청
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청 분석 -> 컨트롤 타워 느낌
        String action = request.getParameter("action");
        if (action == null) {
            response.sendRedirect(request.getContextPath());
        } else if (action.equals("form")) {
            request.getRequestDispatcher("/user/login.jsp").forward(request, response);
        } else if (action.equals("login")) {
            doLogin(request, response);
        } else if (action.equals("logout")) {
            doLogOut(request, response);
        }
    }

    private void doLogOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();

        response.sendRedirect(request.getContextPath() + "/");
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            String pw = request.getParameter("pw");

            User user = new User();
            user.setId(id);
            user.setPw(pw);

            User userInfo = userService.logIn(user);

            if(userInfo != null) {//로그인 성공
                //로그인 성공시 세션을 사용하여 브라우저에서 계속 유지 ==> 세션 로그인!!
                HttpSession session = request.getSession();
                //4.
                session.setAttribute("userInfo", userInfo);

                //쿠키 설정!!
                String remember = request.getParameter("remember");
                System.out.println("remember>>>"+ remember);

                if(remember != null) {//아이디를 저장하고 싶다!!

//				Cookie cookie = new Cookie(String name,String value);
                    Cookie cookie = new Cookie("savedId", id);
                    cookie.setPath(request.getContextPath() + "/");
                    cookie.setMaxAge(60*60*24*365);//유효기간 1년
                    response.addCookie(cookie); //사용자PC에 저장

                }else {//아이디를 저장하고 싶지않다!!
                    Cookie cookie = new Cookie("savedId", id);
                    cookie.setPath(request.getContextPath() + "/");
                    cookie.setMaxAge(0);//saveId쿠키를 사용하지 않겠음
                    response.addCookie(cookie); //사용자PC에 저장
                }

            }else {
                request.setAttribute("msg", "로그인 실패 !");
                request.getRequestDispatcher("/user/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "로그인 중 에러 발생 !!");
            response.sendRedirect("/error/error.jsp");
        }
    }
}
