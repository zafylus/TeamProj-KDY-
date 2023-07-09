<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>erp</title>
<link rel="stylesheet" type="text/css" href="css/erp.css">
<link rel="stylesheet" type="text/css" href="css/saleAnalysis.css">
<link rel="stylesheet" type="text/css" href="css/productAnalysis.css">



</head>

<body>
	<c:import url="importPage/header.jsp" />
	<c:import url="importPage/nav.jsp" />
	<div class="container">
		<c:import url="importPage/side.jsp" />
		<section>
			<div class="header">
				<div class="title">top 3 인기 상품</div>
			</div>
			<div class="product_showlist" data-table="top3">
				<div class="topOrder">
				<div class="top1">top 1</div>
				<div class="pr_top1"></div>
					<div class="total_cnt"></div>
					<div class="pr_pay"></div>
					</div>
				<div class ="top_value"></div>
				<div class ="top_value"></div>
			
			</div>

			<div class="header">
				<div class="title">카테고리 별 주문</div>
			</div>
			<div class="product_showlist" data-table="ctgy">해당 기간에 매출이
				없습니다.</div>

		</section>
	</div>
		
</body>
	<script src="js/common/jquery-3.7.0.js"></script>
	<script src="js/common/importPage.js"></script>
	<script src="js/sale/productAnalysis.js"></script>
</html>