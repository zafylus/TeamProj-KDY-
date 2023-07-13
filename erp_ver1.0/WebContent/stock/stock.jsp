<%@page import="util.PageCheck"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<!-- CSS only -->
<link href="css/bootstrap.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<style>
	* {
		box-sizing: border-box;
	}
	
	#page {
        width: 1600px; height: 900px;
        margin: 20px auto;
        display: grid;
        grid-gap: 10px;
        grid-template-columns: 266px 1fr;
        grid-template-rows: 10% 50px 1fr;
        grid-template-areas: 
            "header header"
            "nav nav"
            "aside section"
        ;
	}
	
	section {
		grid-area: section;
	}
	
	aside {
		grid-area : aside;
	}

	#aside-ul {
		list-style: none;
		margin : 0px;
		padding : 0px;
	}
	
	.aside-li {
		text-align: center;
		line-height: 100px;
	}

</style>
</head>
<body>
<%
	PageCheck pageCheck = new PageCheck();
	String req = request.getParameter("req");
	String includeP = pageCheck.stockPageCheck(req);
	
	pageContext.setAttribute("page", includeP);
%>
<div id = "page">
	<jsp:include page="../header.jsp" />
	<jsp:include page="../nav.jsp" />
	<aside class="container-fluid border shadow p-3  bg-body rounded">
		<ul id="aside-ul" class="nav justify-content-center">
			<li class="aside-li nav-item"><a class="nav-link" href="totalstock">총 채고량</a></li>
			<li class="aside-li nav-item"><a class="nav-link" href="stockList">입/출 리스트</a></li>
			<li class="aside-li nav-item"><a class="nav-link" href="registStock">재고 등록</a></li>
			<li class="aside-li nav-item"><a class="nav-link" href="#">세부메뉴4</a></li>
			<li class="aside-li nav-item"><a class="nav-link" href="#">세부메뉴5</a></li>
			<li class="aside-li nav-item"><a class="nav-link" href="StockOption">옵션</a></li>
		</ul>
	</aside>
	<section class="container-fluid border shadow p-3  bg-body rounded">
		<jsp:include page="${page }" />
	</section>
</div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>