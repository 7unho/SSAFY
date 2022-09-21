<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.april2nd.live1.dto.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="my" uri="/WEB-INF/tld/myTag.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL테스트</title>
</head>
<%--jstl_test.jsp --%>
<body> 
  <h3>JSTL(JSP Standard Tag Library)테스트</h3>
  <hr>
  <%-- <% if(조건식){
  
  
         } %> --%>  
  <c:if test="true" >
     HTML마크업,text <br>
        조건식 참일때 실행<br>
  </c:if>
  
  <c:if test="some text">
     Some Text
  </c:if>
  
  <c:if test="${2<3 }">
     2는 3보다 작다!! <br>
  </c:if>
  
  <%-- 나이테스트 --%>
  <c:if test="${param.age < 20}">
     <font color="blue">나이가 20미만입니다!!</font><br>
  </c:if>
  
  <c:if test="${param.age >= 20}">
     <font color="blue">나이가 20이상입니다!!</font><br>
  </c:if>
  
  <c:if test="${param.age >= 20 && param.age < 30}">
     <font color="blue">나이가 20대 입니다!!</font><br>
  </c:if>
  <hr>
  <%-- 나이 20대,30대 체크 --%>
  <c:choose> <%-- if  ~  else if  ~   else문과 유사 --%>
     <c:when test="${param.age<20 || param.age>39}">
        <font color="green">나이가 20대 또는 30대가 아닙니다!!</font><br>
     </c:when>
     <c:when test="${param.age < 30 }">  <%--  20~39 --%>
        <font color="green">나이가 20대 입니다!!</font><br>
     </c:when>
     <c:otherwise>
       <font color="green">나이가 30대 입니다!!</font><br>
     </c:otherwise>
  </c:choose>
  <hr>
  <h4>forEach테스트</h4>
  <%--  JSTL안녕!! 홀수줄은 빨강, 짝수줄은 파랑으로 총 10줄을 출력하시오 --%>
  
  <c:forEach begin="0" end="10" var="i" varStatus="stat" step="2">
            인덱스: ${stat.index}, 카운트: ${stat.count}
     JSTL안녕!!==>${i }<br>
  </c:forEach>
  
  <%--
  
       var="i" ==> 새로 정의하는 변수 (begin,end에 정의된 숫자를 사용하기 위해)
        int i=1~10
        
        varStatus = "gildong"  ==> 출력되는 각 행에 번호를 부여 하기 위해
        
       gildong.index  gildong.count
          정의된 값                     1부터 시작하는 값
   
   --%>

  <c:forEach begin="1" end="10" var="i" varStatus="stat">
    <c:if test="${stat.count %2  == 0  }">            
     <font color="blue">JSTL안녕!!</font><br>
    </c:if>
    
    <c:if test="${stat.count %2  == 1  }"> 
     <font color="red">JSTL안녕!!</font><br>
    </c:if> 
  </c:forEach>
  
  <%
      //서블릿(Controller) ==> 영역에 데이터를 저장
      Person p1 = new Person("길동",13,"학생");
      Person p2 = new Person("라임",14,"학생");
      Person p3 = new Person("주원",15,"학생");
      
      List<Person> list = new ArrayList<>();
          /* list.add(p1);
          list.add(p2);
          list.add(p3); */
          
      request.setAttribute("list", list);
  
  %>
  
  <hr>
  <h3>Person정보</h3>
  <!-- 테이블 출력 -->
<%--   <c:if test="${list != null}">--%>  
<%--  <c:if test="${list ne null}"> --%>
<%--  <c:if test="${! empty list}"> --%>
 <c:if test="${not empty list}">
  <table>
     <tr bgcolor="skyblue">
        <th>이름</th>
        <th>나이</th>
        <th>직업</th>
     </tr>
  <c:forEach items="${list}" var="p">
     <tr>
        <td>${p.name }</td>
        <td>${p.age }</td>
        <td>${p.job }</td>
     </tr>
  </c:forEach>
  </table>
  </c:if>  
   <c:if test="${empty list}">
      정보가 없습니다.
   </c:if>
  <%--  
    List<Person> list = request.getAttribute("list");  
    	 <table>
    for(){
    	 Person p= list.get(i);
    	 String name = p.getName();
    	 int age = p.getAge();
    	 String job = p.getJob();
    	   <tr>
    	     "<td>"+name+"</td>"
    	     "<td>"+age+"</td>"
    	     "<td>"+job+"</td>"
           </tr>    	    
    } 
      </table>
    --%>
</body>
</html>











