<%@page import="util.PageDivide"%>
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
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="js/jquery-3.7.0.js"></script>
<style>

<!--	

-->
</style>
</head>
<body>
<%
	PageDivide pageDiv = new PageDivide();
	int totalCnt = (Integer)request.getAttribute("totalCnt");
	int currPage = (Integer)request.getAttribute("currPage");
	
	int startPage = pageDiv.pageStartNum(currPage);
	int lastPage = pageDiv.pageMaxNum(totalCnt);
	int endPage = pageDiv.pageEndNum(startPage);
	endPage = pageDiv.checkEndLastPage(endPage, lastPage);
%>
	<div class="container text-center">
		<div class="row">
			<table class="table">
				<thead>
				<tr class="table-secondary">
					<th>입출 번호</th><th>제품 이름</th><th>수량</th><th>입출 날짜</th><th>비고</th>
				</tr>
				<thead>
				<tbody>
					<c:forEach var="stock" items="${slist }">
						<tr>
							<td class="st_no">${stock.st_no }</td>				
							<td class="ma_name">${stock.ma_code }</td>				
							<td class="st_ea">${stock.st_ea }</td>
							<td class="st_date">
								<fmt:parseDate value="${stock.st_recDate }" var="date" pattern="yyyy-MM-dd'T'HH:mm"/>
								<fmt:formatDate value="${date }" pattern="yyyy-MM-dd : HH시mm분" />
							</td>				
							<td>${stock.st_note }</td>				
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
		</div>
		<div onclick="pageNation(event)">
		
			<!-- 페이지 그룹의 시작이 1이면 이전 페이지 그룹 버튼 생략 -->
			<c:if test="<%= startPage != 1 %>">
				<button type="button" class="btn btn-primary" id="<%= startPage-5 %>">&lt</button>
			</c:if>
			<c:forEach var="i"  begin="<%= startPage %>" end="<%= endPage %>">
				<button id="${i }" type="button" class="btn btn-primary">${i }</button>
			</c:forEach>
			
			<!-- 페이지 그룹의 마지막과 마지막 페이지가 같으면 뒤의 페이지 그룹이 없으므로 생략 -->
			<c:if test="<%= endPage !=  lastPage %>">
				<button type="button" class="btn btn-primary" id="<%=startPage + 5 %> ">&gt</button>
			</c:if>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>