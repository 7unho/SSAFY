<%--
  Created by IntelliJ IDEA.
  User: unknownflower
  Date: 2022/09/20
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>
      <%
          pageContext.setAttribute("k1", "홍길동");
          request.setAttribute("k1", "김준호");
          session.setAttribute("k1", "SSAFYk1");
          session.setAttribute("k2", "SSAFYk2");
          application.setAttribute("k1", "13반");

//          RequestDispatcher dispatcher = request.getRequestDispatcher("b.jsp");
//          dispatcher.forward(request, response);

          response.sendRedirect("b.jsp");
      %>
    </h3>
</body>
</html>
