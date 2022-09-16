<%--
  Created by IntelliJ IDEA.
  User: unknownflower
  Date: 2022/09/16
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <table>
    <tr>
      <td>항목</td>
      <td>내용</td>
    </tr>
    <tr>
      <td>도서번호</td>
      <td>${book.isbn}</td>
    </tr>
    <tr>
      <td>도서명</td>
      <td>${book.title}</td>
    </tr>
    <tr>
      <td>저자</td>
      <td>${book.author}</td>
    </tr>
    <tr>
      <td>가격</td>
      <td>${book.title}</td>
    </tr>
    <tr>
      <td>설명</td>
      <td>${book.desc}</td>
    </tr>
  </table>

</body>
</html>
