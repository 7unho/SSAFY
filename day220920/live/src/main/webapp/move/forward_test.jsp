<%--
  Created by IntelliJ IDEA.
  User: unknownflower
  Date: 2022/09/20
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
      RequestDispatcher dispatcher = request.getRequestDispatcher("end.jsp");
      dispatcher.forward(request, response);
    %>
</body>
</html>
