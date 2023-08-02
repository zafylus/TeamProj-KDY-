<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>erp</title>
 

<link rel="stylesheet" type="text/css" href="../css/erp.css">
<link rel="stylesheet" type="text/css" href="../css/saleAnalysis.css">
</head>
<body>
 	
		
	<c:import url="../importPage/header.jsp" />
	<c:import url="../importPage/nav.jsp" />
	<div class="container">
		<c:import url="../importPage/side.jsp" />
		<section>
			<div class="an_header">
				<div class="an_title">매출</div>
				<div class="an_date">2023.06.23 18:36 기준</div>
			</div>
			<div class="an_container">
				<div class="an_box sale">
					<div>
						<p>실 매출</p>
						<div>
							<span class="an_value ">0</span>원
						</div>

					</div>
					<div>
						<p>결제 건수</p>
						<div>
							<span class="an_value ">0</span>건
						</div>
					</div>
					<div>
						<p>평균 결제 금액</p>
						<div>
							<span class="an_value avg_sale">0</span>원
						</div>
					</div>
				</div>




				<div class="an_box refund">
					<div>
						<p>환불 금액</p>
						<div>
							<span class="an_value red total_refund">0</span>원
						</div>
					</div>
					<div>
						<p>환불 건수</p>
						<div>
							<span class="an_value red refund_cnt">0</span>건
						</div>
					</div>
					<div>
						<p>평균 환불 금액</p>
						<div>
							<span class="an_value red avg_refund">0</span>원
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>


	
	<script src="../js/common/jquery-3.7.0.js"></script>
	<script src="../js/common/importPage.js"></script>
	<script src="../js/sale/saleAnalysis.js"></script>
</body>
</html>