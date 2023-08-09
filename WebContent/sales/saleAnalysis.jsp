<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>erp</title>
 <%
  LocalDate now = LocalDate.now();
  String nowDate = now.format(java.time.format.DateTimeFormatter.ofPattern("yyyy.MM.dd"));
%>
<link href="/erp_ver2.0/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/erp_ver1.1/css/saleAnalysis.css">
<link rel="stylesheet" href="/erp_ver1.1/css/modal.css" >
<link rel="stylesheet" href="/erp_ver1.1/css/datepicker.css" >
<script src="/erp_ver1.1/js/jquery.js"></script>
</head>
<body>
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
			<div id="myModal" class="modal">
			    <div class="modal-content">
				    <span class="close">&times;</span>
				        시작 날짜<br>
					<input class="datepicker begin_date"  value="<%= nowDate %>"><br>
					 종료 날짜<br>
					<input class="datepicker end_date" value="<%= nowDate %>">
					<button class="select_btn">조회</button>
    			</div>
 		 	</div>

<script src="/erp_ver1.1/js/library/datepickerModal.js"></script>
<script src="/erp_ver1.1/js/library/datepicker.js"></script>
<script src="/erp_ver1.1/js/library/datepicker.ko-KR.js"></script>
 <script src="/erp_ver1.1/js/sale/saleAnalysis.js"></script>
<script src="/erp_ver1.1/js/bootstrap.bundle.js"></script>
</body>
</html>