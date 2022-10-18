<%--
  Created by IntelliJ IDEA.
  User: unknownflower
  Date: 2022/10/18
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>Spring 계산기</h3>
    <hr/>
    <form action="/calResult" method="POST">
        <input type="number" name="su1">
        <select name="oper">
            <option>+</option>
            <option>-</option>
            <option>*</option>
            <option>/</option>
        </select>
        <input type="number" name="su2">
        <button>계산</button>
    </form>
</body>
</html>
