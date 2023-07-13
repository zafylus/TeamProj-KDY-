<%@page import="dto.ExpenseDTO"%>
<%@page import="java.util.List"%>
<%@page import="stock.Service_st"%>
<%@page import="dto.StockDTO"%>
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
<!-- CSS only -->
<link href="css/bootstrap.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<%
	List<ExpenseDTO> exList = (List<ExpenseDTO>)(Object)request.getAttribute("elist");
	
	int startPage = 1;
	int endPage = 5;
	int lastPage = 6;
%>
<div class="container text-center">
		<div class="row">
			<table class="table table-striped">
				<tr class="table-secondary">
					<th>지출 번호</th><th>제품 이름</th><th>가격</th><th>수량</th><th>지출 날짜</th><th>비고</th>
				</tr>
				<c:forEach var="expense" items="<%= exList %>">
					<tr>
						<td class="ex_no">${expense.ex_no }</td>				
						<td class="ma_name">${expense.ma_code }</td>				
						<td class="ex_cost">${expense.ex_cost }</td>
						<td class="ex_ea">${expense.ex_ea }</td>
						<td class="ex_date">
							<fmt:parseDate value="${expense.ex_date }" var="date" pattern="yyyy-MM-dd'T'HH:mm"/>
							<fmt:formatDate value="${date }" pattern="yyyy-MM-dd : HH시mm분" />
						</td>				
						<td>${expense.ex_note }</td>				
					</tr>
				</c:forEach>
			</table>
		</div>
				<div class="btn-toolbar justify-content-center" role="toolbar" aria-label="Toolbar with button groups" onclick="pageNation(event)">
			<div class="btn-group me-2" role="group" aria-label="First group">
				<!-- 페이지 그룹의 시작이 1이면 이전 페이지 그룹 버튼 생략 -->
				<c:if test="<%= startPage != 1 %>">
					<button type="button" class="btn btn-primary" id="<%= startPage-5 %>">&lt</button>
				</c:if>
			</div>
			<div class="btn-group me-2" role="group" aria-label="Second group">
				<c:forEach var="i"  begin="<%= startPage %>" end="<%= endPage %>">
					<button id="${i }" type="button" class="btn btn-primary">${i }</button>
				</c:forEach>
			</div>
			<div class="btn-group" role="group" aria-label="Third group">
				<!-- 페이지 그룹의 마지막과 마지막 페이지가 같으면 뒤의 페이지 그룹이 없으므로 생략 -->
				<c:if test="<%= endPage !=  lastPage %>">
					<button type="button" class="btn btn-primary" id="<%=startPage + 5 %> ">&gt</button>
				</c:if>
			</div>
		</div>
</div>
<script>
	function pageNation(e) {
		if(e.target.tagName == "BUTTON") {
			$.ajax({
				url: "stockList",
				type: "get",
				dataType: "text",
				success: function(data) {
					location.href="stockList?pageNum="+e.target.id;
				}
			})
		}
	}
</script>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>