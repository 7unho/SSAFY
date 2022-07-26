package com.april2nd.workshop_1.workshop_1.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.april2nd.workshop_1.workshop_1.dto.Book;
import com.april2nd.workshop_1.workshop_1.dto.User;

import java.io.IOException;

// 이 서블릿이 호출되기 위해서는 url 상에 http://server_ip:port/context_name/main 이 필요하다.
@WebServlet("/main")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * get 방식의 요청에 대해 응답하는 메서드이다.
     * front controller pattern을 적용하기 위해 내부적으로 process를 호출한다.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    /**
     * post 방식의 요청에 대해 응답하는 메서드이다.
     * front controller pattern을 적용하기 위해 내부적으로 process를 호출한다.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // post 요청 시 한글 파라미터의 처리를 위해 encoding을 처리한다.
        request.setCharacterEncoding("utf-8");
        process(request, response);
    }

    /**
     * request 객체에서 action 파라미터를 추출해서 실제 비지니스 로직 메서드(ex: doRegist)
     * 호출해준다.
     */
    private void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // request에서 action을 추출해서 실제 비지니스 로직 메서드를 호출한다.
        String action = request.getParameter("action");
        switch (action) {
            case "regist":
                doRegist(request, response);
                break;
            case "login":
                doLogin(request, response);
                break;
            case "logout":
                doLogout(request, response);
                break;
        }
    }

    /**
     * 클라이언트에서 전달된 request를 분석해서 regist_result.jsp에서 보여줄 수 있게 한다.
     *
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doRegist(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // request 객체에서 전달된 parameter를 추출한다.
        String isbn = request.getParameter("isbn");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String desc = request.getParameter("desc");
        // 문자열로 전달된 price는 숫자로 변경해준다.
        int price = Integer.parseInt(request.getParameter("price"));

        // 전달된 파라미터를 이용해서 Book 객체를 생성한다.
        Book book = new Book(isbn, title, author, price, desc);
        // book 객체를 request 영역에 book이라는 이름으로 등록한다.
        request.setAttribute("book", book);
        // 왜 서블릿(=컨트롤러)에서 영역 저장을 할까? -> View(JSP)와 데이터를 공유하기 위해
        // JSP 화면 호출을 위해 RequestDsipatcher의 forward를 사용한다.
        // 이때 연결할 jsp의 이름을 넘겨준다. forward에서 /는 context root를 나타낸다.
        RequestDispatcher dispatcher = request.getRequestDispatcher("/regist_result.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * 로그인 처리한다.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 파라미터에서 id와 pass를 추출한다.
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");

        // id가 ssafy이고 pass가 1234일 경우 김싸피 사용자가 로그인 하는 것으로 간주한다.
        if ("ssafy".equals(id) && "1234".equals(pass)) {
            User user = new User(id, pass, "김싸피");
            // 로그인에 성공했을 경우 Session에 사용자 정보를 저장한다. (키값: loginUser)
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", user);
            // 새로운 url 설정을 위해 redirect로 index.jsp페이지로 이동한다.
            response.sendRedirect("./index.jsp");
        } else {
            // 로그인 실패에 대한 메시지를 request 영역에 설정한다. (키값: msg)
            request.setAttribute("msg", "로그인 실패");
            // 기존의 url을 유지하기 위해 forward로 index.jsp로 이동한다.
            RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath() + "/index.jsp");
            dispatcher.forward(request, response);
        }
    }

    /**
     * 로그아웃 처리한다.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 현재 사용자의 session을 완전히 소멸시킨다.
        HttpSession session = request.getSession();
        session.invalidate();
        // 새로운 url 설정을 위해 redirect로 index.jsp페이지로 이동한다.
        response.sendRedirect("./index.jsp");
    }
}
