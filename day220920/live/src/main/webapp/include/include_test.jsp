<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include지시자테스트</title>
   <style type="text/css">
       span{width: 100%}
       table{margin: auto}
       h3,span{text-align: center;}
   </style>
</head>
<%--include_test.jsp(레이아웃 설정페이지) --%>
<body>  
  <h3>include directive(지시자) 테스트</h3>
  <hr>
  <span><%@include  file="menu.jsp" %></span>
  <table>
    <tr>
       <td align="left">
         <font size="-1"><%@include file="shopping.jsp" %></font>
       </td>
       <td width="30">&nbsp;</td>
       <td align="left">
         <font size="-1"><%@include file="news.jsp" %></font>
       </td>
    </tr>
  </table>  
</body>
</html>



