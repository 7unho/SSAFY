<%--
  Created by IntelliJ IDEA.
  User: unknownflower
  Date: 2022/10/18
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>입력 폼</h3>
    <form action="/form" method="POST">
        이름 : <input type="text" name="name"><br>
        나이 : <input type="text" name="age"><br>
        직업 : <input type="text" name="job"><br>
        <button>전달</button>
    </form>

</body>
</html>
