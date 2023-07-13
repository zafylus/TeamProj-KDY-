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
<link href="css/bootstrap.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<script src="js/jquery-3.7.0.js"></script>
<style>
	.table {
		text-align: center;
		font-size: 20px;
	}
</style>
</head>
<body>
		
	<div class="container-fluid text-center">
		<h1>재고 총량</h1>
		<hr>
		<div id="liveAlertPlaceholder" class="container-fluid"></div>
<%
	ArrayList<TotalStockVO> alist = (ArrayList<TotalStockVO>)(Object)request.getAttribute("alist");
	boolean opt = (boolean)request.getAttribute("alOpt");
	int alNum = (Integer)request.getAttribute("alNum");
	
	if (opt) {
		for(TotalStockVO vo : alist ) {
			if(vo.getTotalEa() < alNum) {
		%>
			<script>
				$("#liveAlertPlaceholder").append(
						'<div class="col-sm-6 offset-sm-3 text-center alert alert-danger alert-dismissible fade show w-50" role="alert">'
	 					+ '<strong><%= vo.getMa_name()%></strong> 의 재고량을 확인하세요.'
	 					+ '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>'
						+ '</div>')
			</script>
		<%
			}
		}
	}
%>	
		
		<table class="table w-75" style="margin: 0px auto;">
			<thead>
				<tr class="table-info">
					<th scope="col">이름</th>
					<th scope="col">수량</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="total_s" items="<%= alist %>">
					<tr>
						<c:choose>
							<c:when test="${total_s.totalEa < alNum }">
								<td class="table-warning">${total_s.ma_name }</td>
								<td class="table-warning">${total_s.totalEa }</td>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script>
	
</script>
</body>
</html>