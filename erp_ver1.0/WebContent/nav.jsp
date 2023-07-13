 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link href="css/bootstrap.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<style>
	#main-nav {
		grid-area : nav;
	}
	
	.nav-item {
		width:150px;
		text-align: center;
	}
	
</style>
</head>
<body>
	<nav id="main-nav">
		<ul class="nav nav-tabs justify-content-center">
		  <li class="nav-item">
		    <a class="nav-link active" aria-current="page" href="main.jsp">Home</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="#">매출</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="expense.jsp">매입</a>
		  </li>
		  <li class="nav-item dropdown">
		    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="totalstock" role="button" aria-expanded="false">재고</a>
		    <ul class="dropdown-menu">
		      <li><a class="dropdown-item" href="totalstock">총 재고량</a></li>
		      <li><a class="dropdown-item" href="stockList">재고 입/출 리스트</a></li>
		      <li><a class="dropdown-item" href="registStock">재고 등록</a></li>
		      <li><a class="dropdown-item" href="StockOption">옵션</a></li>
		    </ul>
		  </li>
		</ul>
	</nav>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>