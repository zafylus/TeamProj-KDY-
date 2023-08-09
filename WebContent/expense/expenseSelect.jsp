<%@page import="util.PageDivide"%>
<%@page import="dto.ExpenseDTO"%>
<%@page import="java.util.List"%>
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
<title>지출 리스트</title>
<!-- CSS only -->
<link href="css/bootstrap.css" rel="stylesheet" >
<script src="js/jquery.js"></script>
</head>
<body>
<%
	int totalCnt = (Integer)request.getAttribute("totalCnt");
	int currPage = (Integer)request.getAttribute("currPage");
	
	String date1 = (String)request.getAttribute("date1");
	String date2 = (String)request.getAttribute("date2");
	int startPage = PageDivide.pageStartNum(currPage);
	int lastPage = PageDivide.pageMaxNum(totalCnt);
	int endPage = PageDivide.pageEndNum(startPage);
	endPage = PageDivide.checkEndLastPage(endPage, lastPage);
%>
<div class="container-fluid text-center">
		<div class="row">
			<div class="col mb-3">
				<input type="date" name="date1" value="<%= date1 %>"> ~
				<input type="date" name="date2" value="<%= date2 %>">
			</div>
		</div>
		<div class="row">
			<table class="table table-striped">
				<thead>
					<tr class="table-secondary">
						<th>지출 번호</th><th>제품 이름</th><th>가격</th><th>수량</th><th>지출 날짜</th><th>비고</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="expense" items="${elist }">
						<tr>
							<td>${expense.ex_no }</td>				
							<td>${expense.ma_code }</td>				
							<td>${expense.ex_cost }</td>
							<td>${expense.ex_ea }</td>
							<td>
								<fmt:parseDate value="${expense.ex_date }" var="date" pattern="yyyy-MM-dd'T'HH:mm"/>
								<fmt:formatDate value="${date }" pattern="yyyy-MM-dd : HH시mm분" />
							</td>				
							<td>${expense.ex_note }</td>				
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
				<div class="btn-toolbar justify-content-center" role="toolbar" aria-label="Toolbar with button groups" onclick="pageNation(event)">
			<div class="btn-group me-2" role="group" aria-label="First group">
				<!-- 페이지 그룹의 시작이 1이면 이전 페이지 그룹 버튼 생략 -->
				<c:if test="<%= startPage != 1 %>">
					<button type="button" class="btn btn-primary" data-page="<%= startPage-5 %>">&lt</button>
				</c:if>
			</div>
			<div class="btn-group me-2" role="group" aria-label="Second group">
				<c:forEach var="i"  begin="<%= startPage %>" end="<%= endPage %>">
					<button data-page="${i }" type="button" class="btn btn-primary">${i }</button>
				</c:forEach>
			</div>
			<div class="btn-group" role="group" aria-label="Third group">
				<!-- 페이지 그룹의 마지막과 마지막 페이지가 같으면 뒤의 페이지 그룹이 없으므로 생략 -->
				<c:if test="<%= endPage !=  lastPage %>">
					<button type="button" class="btn btn-primary" data-page="<%=startPage + 5 %> ">&gt</button>
				</c:if>
			</div>
		</div>
</div>
<script>
	function pageNation(e) {
		if(e.target.tagName == "BUTTON") {
			$.ajax({
				url: "expenses",
				type: "get",
				dataType: "text",
				success: function(data) {
					location.href="expenses?pageNum="+e.target.dataset.page+"&date1="+ $('input[name="date1"]').val() + "&date2=" + $('input[name="date2"]').val();
				}
			})
		}
	}
	
	$('input[name="date1"]').change(function() {
		if(dateCheck()) {
			alert("날짜 범위를 확인하세요.");
			$('input[name="date1"]').val($('input[name="date2"]').val());
		}
			
		$.ajax({
			url: "expenses",
			type: "get",
			dataType: "text",
			success: function(data) {
				location.href="expenses?pageNum="+1+"&date1="+ $('input[name="date1"]').val() + "&date2=" + $('input[name="date2"]').val();
			}
		})
	});
	
	$('input[name="date2"]').change(function() {
		if(dateCheck()) {
			alert("날짜 범위를 확인하세요.");
			$('input[name="date1"]').val($('input[name="date2"]').val());
		}
		
		if (todayCheck()) {
			alert("오늘 날짜를 넘을 수 없습니다.");
			$('input[name="date2"]').val(new Date().toISOString().substring(0, 10));
		}
		
		$.ajax({
			url: "expenses",
			type: "get",
			dataType: "text",
			success: function(data) {
				location.href="expenses?pageNum="+1+"&date1="+ $('input[name="date1"]').val() + "&date2=" + $('input[name="date2"]').val();
			}
		})
	});
	
	function dateCheck() {
		var date1 = $('input[name="date1"]').val();
		var date2 = $('input[name="date2"]').val();
		
		if (date1 > date2)
			return true;
	}
	
	function todayCheck() {
		var date2 = new Date($('input[name="date2"]').val());
		var today = new Date();
		
		if (date2 > today)
			return true;
	}
</script>
<script src="js/bootstrap.bundle.js" ></script>
</body>
</html>