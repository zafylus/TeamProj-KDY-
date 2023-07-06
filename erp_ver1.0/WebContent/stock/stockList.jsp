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
<title>Insert title here</title>
<script src="js/jquery-3.7.0.js"></script>
<style>
	
	#tbl {
		border : 1px solid grey;
		box-shadow: 5px 5px 5px grey;
	}
	
	#pages {
		grid-area: pages;
		text-align: center;
		line-height: 60px;
	}
	
	th, td {
		width:200px; height: 30px;
		border:1px solid black;
	}
	
	.st_no {
		width: 20%;
	}
	
	.ma_name {
		width: 20%;
	}
	
	.st_ea {
		width: 10%;
	}
	
	.st_date {
		width: 20%;
	}
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
	<div id="tbl">
		<table>
			<thead>
			<tr>
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
		<div id="pages" onclick="pageNation(event)">
		
			<!-- 페이지 그룹의 시작이 1이면 이전 페이지 그룹 버튼 생략 -->
			<c:if test="<% startPage != 1 %>">
				<button>&lt</button>
			</c:if>
			<c:forEach var="i"  begin="<%= startPage %>" end="<%= endPage %>">
				<button id="${i }">${i }</button>
			</c:forEach>
			
			<!-- 페이지 그룹의 마지막과 마지막 페이지가 같으면 뒤의 페이지 그룹이 없으므로 생략 -->
			<c:if test="<%= endPage !=  lastPage %>">
				<button>&gt</button>
			</c:if>
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
</body>
</html>