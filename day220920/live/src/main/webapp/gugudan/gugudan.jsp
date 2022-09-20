<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: unknownflower
  Date: 2022/09/20
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
<% for(int i = 1; i <= 9; i++) {%>
    <tr>
        <% for (int j = 2; j <= 9; j++){ %>
        <td><%= j + "*" + i + "=" + (j * i)%></td>
        <%}%>
    </tr>
    <%}%>
</table>
<hr color="red">
</body>
</html>
