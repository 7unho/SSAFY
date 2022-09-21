<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- taglib지시어는 확장된 태그(커스텀태그)를 현재문서에서 사용하고자 할때 기술 --%>
<%@taglib prefix="my" uri="/WEB-INF/tld/myTag.tld"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커스텀태그</title>
</head>
<%--customTag_test.jsp --%>
<body>
  <h3>커스텀태그 테스트</h3>
  <hr>
  <my:gildong></my:gildong>
  <hr color="orange">
  <hr color="green">

</body>
</html>









