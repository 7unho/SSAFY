<%--
  Created by IntelliJ IDEA.
  User: unknownflower
  Date: 2022/09/16
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String id = request.getParameter("id");
    String password = request.getParameter("password");
%>
<html>
<head>
    <title>Result</title>
</head>
<body>
  전달 ID : <%=id%><br>
  전달 PW : <%=password%><br>
</body>
</html>
