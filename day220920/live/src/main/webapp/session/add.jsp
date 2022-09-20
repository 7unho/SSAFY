<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품추가</title>
</head>
<%-- add.jsp --%>
<body>
<%
    //request폼데이터 한글 처리: request.setCharacterEncoding("문자집합");
    request.setCharacterEncoding("utf-8");

    //폼안의 데이터 얻기:   request.getParameter("name");
    String product = request.getParameter("product");
//      session.setAttribute("product", product);

    //ArrayList사용이유: 여러개의 과일명을 저장하기 위해
    ArrayList<String> productList = (ArrayList<String>)session.getAttribute("list");

    if (productList == null) {
        productList = new ArrayList<>();
    }
    productList.add(product);
    //session사용이유: 동일브라우저, 다른페이지에서 함께 공유하기 위해
    session.setAttribute("list", productList);

    out.print("<script>alert('" + product + "(이)가 추가되었습니다!!'); history.back()</script>");
%>
</body>
</html>



