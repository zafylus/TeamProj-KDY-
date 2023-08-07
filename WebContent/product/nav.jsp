 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link href="css/bootstrap.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<style>
	.nav-item {
		width:150px;
	}
	
</style>
</head>
<body>
	<nav id="main-nav">
		<ul class="nav nav-tabs justify-content-center text-center">
		  <li class="nav-item">
		    <a class="nav-link" aria-current="page" href="main">Home</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="#">매출</a>
		  </li>
		  <li class="nav-item dropdown">
		    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="totalstock" role="button" aria-expanded="false">지출</a>
		    <ul class="dropdown-menu">
		    	<li><a class="dropdown-item" href="InsertExpnese">지출 등록</a></li>
		    	<li><a class="dropdown-item" href="expenseList"> 지출 리스트</a></li>
		   		<li><a class="dropdown-item" href="#">??</a></li>
		    </ul>
		  </li>
		  <li class="nav-item dropdown">
		    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="totalstock" role="button" aria-expanded="false">재고</a>
		    <ul class="dropdown-menu">
		      <li><a class="dropdown-item" href="totalstock">총 재고량</a></li>
		      <li><a class="dropdown-item" href="stockList">재고 입/출 리스트</a></li>
		      <li><a class="dropdown-item" href="insertStock">재고 등록</a></li>
		      <li><a class="dropdown-item" href="stockCalc">생산 계산</a></li>
		      <li><a class="dropdown-item" href="StockOption">옵션</a></li>
		    </ul>
		  </li>
		  <li class="nav-item dropdown active">
		    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="totalstock" role="button" aria-expanded="false">상품</a>
		    <ul class="dropdown-menu">
				<li><a class="dropdown-item" href="product">상품 조회</a></li>
				<li><a class="dropdown-item" href="product-regist">상품 등록</a></li>
				<li><a class="dropdown-item" href="product-recipe">레시피 조회</a></li>
		    </ul>
		  </li>
		</ul>
	</nav>
<script src="js/bootstrap.bundle.js"></script>
</body>
</html>