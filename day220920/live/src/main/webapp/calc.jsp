<%--
  Created by IntelliJ IDEA.
  User: unknownflower
  Date: 2022/09/20
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.april2nd.live.Calculator" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP계산기</title>
</head>
<body>
<h3>JSP 계산기</h3>
<hr>
<%
    System.out.println("HTTP요청방식(method)="+ request.getMethod()); //"GET" "POST"
%>
<form action="calc.jsp" method="post">
    <input type="text" maxlength="4" size="4" name="su1">
    <select name="oper">
        <option value="+">+</option>
        <option>-</option>
        <option>*</option>
        <option>/</option>
    </select>
    <input type="text" maxlength="4" size="4" name="su2">
    <button>계산</button>
</form>
<hr>
<%
    //자바영역(메소드 영역)
//    HttpServletRequest request = new HttpServletRequest();

    if(request.getMethod().equals("POST")){
        String su1 = request.getParameter("su1");
        String su2 = request.getParameter("su2");
        String oper = request.getParameter("oper");

        //유효성 검사
        System.out.println("su1 >>>" + su1 + "<<<");
        if(su1.equals("") || su2.trim().length() == 0){
            out.print("<font color='red'>데이터를 입력하세요!</font>");
        } else if(!(su1.matches("[0-9]+") && su1.matches("[\\d]+"))){ // + : 1개 이상, * : 0개 이상
            out.print("<font color='red'>숫자만 입력하세요!</font>");
        } else if(oper.equals("/") && su2.equals("0")){
            out.print("<font color='red'>0으로 나눌 수 없습니다 !!</font>");
        } else {
            Calculator calc = new Calculator(Integer.parseInt(su1), Integer.parseInt(su2), oper);
            out.print("<font color='blue'>" + calc.getResult() + "</font>");
        }
    }
%>

<%-- <%= calc.getResult() %> --%>
</body>
</html>