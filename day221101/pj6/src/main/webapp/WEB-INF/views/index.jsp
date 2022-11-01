<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<%@ include file="/WEB-INF/views/include/head.jsp" %>
</head>

<body id="page-top">
    <!-- Navigation-->
	<%@ include file="/WEB-INF/views/include/nav.jsp" %>
	
    <!-- Masthead-->
    <header class="masthead">
      <div class="container">
        <div class="masthead-heading text-uppercase">My Home</div>
        <div class="row col-md-12 justify-content-center mb-2">
          <div class="form-group col-md-8">
            <a href="${root }/apart/apart.jsp" type="button" id="list-btn" class="btn btn-outline-primary">아파트 매매 내역 조회</a>
          </div>
        </div>
      </div>
    </header>
    
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="/resources/js/main.js"></script>
    <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>
