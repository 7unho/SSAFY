<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h3>end.jsp(결과출력)</h3>
  <%
      request.setCharacterEncoding("UTF-8");
      String username = request.getParameter("username");
  %>
  전달 이름: <%=username %> <%= session.getAttribute("username") %>
</body>
</html>