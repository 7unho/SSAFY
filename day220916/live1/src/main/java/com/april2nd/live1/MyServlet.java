package com.april2nd.live1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MyServlet") // 맨 앞의 '/'는 ContextRoot를 의미. 무조건 있어야 한다.
public class MyServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("init 호출");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service 호출"); //ㅁㄴㅇㅁㄴㅇ
        if(req.getMethod().equals("GET")) doGet(req, resp);
        else doPost(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("destroy 호출");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 브라우저 출력 객체 생성

//        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("<html>");
        out.print(" <body>");
        out.print("     <strong>안녕</strong>");
        out.print("     <input type='button' value='안녕'/>");
        out.print(" </body>");
        out.print("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
