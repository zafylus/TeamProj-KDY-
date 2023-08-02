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
<link href="css/bootstrap.css" rel="stylesheet">
<script src="js/jquery.js"></script>
</head>
<body>
	<div class="container-fluid text-center">
		<h1>재고 총량</h1>
		<hr>
		
		<table class="table w-75 text-center" style="margin: 0px auto;">
			<thead>
				<tr class="table-info">
					<th scope="col">이름</th>
					<th scope="col">수량</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="total_s" items="${alist }">
					<tr>
						<c:choose>
							<c:when test="${total_s.totalEa < alNum }">
								<td class="table-danger">${total_s.ma_name }</td>
								<td class="table-danger">${total_s.totalEa }</td>
							</c:when>
							<c:otherwise>
								<td class="table-success">${total_s.ma_name }</td>
								<td class="table-success">${total_s.totalEa }</td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
			
		</table>
	</div>
<script src="js/bootstrap.bundle.js" ></script>
</body>
</html>