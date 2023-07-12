<%@page import="vo.TotalStockVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<style>
	#container {
		text-align: center;
	}
	
	#container li {
		display:inline-block;
		width: 200px;
		font-size: 30px;
		font-style: bold;
		border : 1px solid black;
	}
</style>
</head>
<body>
<%
	ArrayList<TotalStockVO> alist = (ArrayList<TotalStockVO>)(Object)request.getAttribute("alist");
%>
	<div id="container">
		<h1>재고 총량</h1>
		<hr>
		<ul>
		<c:forEach var="total_s" items="<%= alist %>">
			<li>${total_s.ma_name }</li>
			<li>${total_s.totalEa }</li><br>
		</c:forEach>
		</ul>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>