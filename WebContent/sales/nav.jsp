 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link href="/erp_ver1.2/css/bootstrap.css" rel="stylesheet">
<script src="/erp_ver1.2/js/jquery.js"></script>
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
		  <li class="nav-item dropdown">
		    <a class="nav-link dropdown-toggle active" data-bs-toggle="dropdown" href="totalstock" role="button" aria-expanded="false">매출</a>
		    <ul class="dropdown-menu">
		    	<li><a class="dropdown-item" href="sales">매출 달력</a></li>
		    	<li><a class="dropdown-item" href="saleAnalysis">매출 분석</a></li>
		   		<li><a class="dropdown-item" href="productAnalysis" >상품 분석</a></li>
		    </ul>
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
		  	<li class="nav-item dropdown">
		    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="totalstock" role="button" aria-expanded="false">상품</a>
		    <ul class="dropdown-menu">
		    	<li><a class="dropdown-item" href="#">준비중</a></li>
		    </ul>
		  </li>
		</ul>
	</nav>
<script src="/erp_ver1.2/js/bootstrap.bundle.js"></script>
</body>
</html>