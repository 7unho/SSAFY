package com.april2nd.live1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalcServlet", value = "/CalcServlet")
public class CalcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 브라우저 출력 객체 생성
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("<html>");
        out.print(" <body>");
        out.print("     <form method='POST'>");
        out.print("         <input type='text' name='su1' maxlength='4' size='4'>");
        out.print("             <select name = 'oper'>");
        out.print("                 <option>+</option>");
        out.print("                 <option>-</option>");
        out.print("                 <option>/</option>");
        out.print("                 <option>*</option>");
        out.print("             </select>");
        out.print("         <input type='text' name='su2' maxlength='4' size='4'>");
        out.print("         <button>계산</button>");
        out.print("     </form>");
        out.print(" </body>");
        out.print("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 클라이언트 입력된 데이터 파라미터의 문자 집합 설정 -> POST에서만 설정한다.
        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=utf-8");
        int su1 = Integer.parseInt(request.getParameter("su1"));
        int su2 = Integer.parseInt(request.getParameter("su2"));
        int result = 0;
        String oper = request.getParameter("oper");

        // su1, su2 유효성 검사
//        Calculator cal = new Calculator(Integer.parseInt(su1), Integer.parseInt(su2), oper);
        switch (oper){
            case "+":
                result = su1 + su2;
                break;
            case "-":
                result = su1 - su2;
                break;
            case "*":
                result = su1 * su2;
                break;
            case "/":
                result = su1 / su2;
                break;
        }
        PrintWriter out = response.getWriter();
        out.print("<html>");
        out.print(" <body>");
        out.print("     <form method='POST'>");
        out.print("         <input type='text' name='su1' maxlength='4' size='4' value='" + su1 +"'>");
        out.print("             <select name = 'oper'>");
        out.print("                 <option>+</option>");
        out.print("                 <option>-</option>");
        out.print("                 <option>/</option>");
        out.print("                 <option>*</option>");
        out.print("             </select>");
        out.print("         <input type='text' name='su2' maxlength='4' size='4' value='" + su2 + "'>");
        out.print("         <button>계산</button>");
        out.print("         <strong>" + result + "</strong>");
        out.print("     </form>");
        out.print(" </body>");
        out.print("</html>");
    }
}
