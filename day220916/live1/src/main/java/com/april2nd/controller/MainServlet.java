package com.april2nd.controller;

import com.april2nd.model.Calculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MainServlet", value = "/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // form 데이터 전송
        request.setCharacterEncoding("UTF-8");
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String action = request.getParameter("action");

        if(action == null || action.equals("calcForm")){
           //JSP 페이지 이동 -> (forward, redirect)
            RequestDispatcher dispatcher = request.getRequestDispatcher("calc.jsp");
            dispatcher.forward(request, response);
        } else if(action.equals("calc")){
            String su1 = request.getParameter("su1");
            String su2 = request.getParameter("su2");
            String oper = request.getParameter("oper");

            //유효성 검사

            Calculator calc = new Calculator(Integer.parseInt(su1),Integer.parseInt(su2),oper);
            String result = calc.getResult();

            request.setAttribute("res", result);
            request.getRequestDispatcher("calc.jsp").forward(request, response);
        }
    }
}
