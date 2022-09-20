<%--
  Created by IntelliJ IDEA.
  User: unknownflower
  Date: 2022/09/20
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    pageContext(k1): <%=pageContext.getAttribute("k1")%>
    request(k1): <%=request.getAttribute("k1")%>
    session(k1): <%=session.getAttribute("k1")%>
    session(k2): <%=session.getAttribute("k2")%>
    session(k7): <%=session.getAttribute("k7")%>
    application(k1) = <%=application.getAttribute("k1")%>
</body>
</html>
