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
			<jsp:useBean id="total_s" class="vo.TotalStockVO"/>
			<jsp:setProperty property="*" name="total_s"/>
			<li>${total_s.ma_name }</li>
			<li>${total_s.totalEa }</li><br>
		</c:forEach>
		</ul>
	</div>
</body>
</html>