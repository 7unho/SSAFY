package com.april2nd.controller;

import com.april2nd.model.Book;
import com.april2nd.model.Calculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BookServlet", value = "/book")
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String action = request.getParameter("action");

        if(action == null || action.equals("bookForm")){
            //JSP 페이지 이동 -> (forward, redirect)
            RequestDispatcher dispatcher = request.getRequestDispatcher("/regist.jsp");
            dispatcher.forward(request, response);
        } else if(action.equals("regist")){
            String isbn = request.getParameter("isbn");
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            int price = Integer.parseInt(request.getParameter("price"));
            String desc = request.getParameter("desc");

            Book book = new Book(isbn, title, author, price, desc);

            request.setAttribute("book", book);
            request.getRequestDispatcher("regist_result.jsp").forward(request, response);
        }
    }
}
