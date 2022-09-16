<%--
  Created by IntelliJ IDEA.
  User: unknownflower
  Date: 2022/09/16
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>MVC 계산기</title>
</head>
<body>
<form method="post" action="/main">
    <input type="hidden" name="action" value="calc">
    <input type="text" maxlength="4" size="4" name="su1">
    <select name="oper">
        <option>+</option>
        <option>-</option>
        <option>*</option>
        <option>/</option>
    </select>
    <input type="text" maxlength="4" size="4" name="su2">
    <button>계산</button>
</form>
${res}
</body>
</html>
