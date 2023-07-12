<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<style>
	* {
		box-sizing: border-box;
	}
	
	#page {
        width: 1600px; height: 900px;
        margin: 0px auto;
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
		padding : 20px;
		border : 1px solid black;
		box-shadow: 5px 5px 5px grey;
	}
	
	aside {
		grid-area : aside;
		border : 1px solid black;
		box-shadow: 5px 5px 5px grey;
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
	String req = request.getParameter("req");
	String includeP = "";
	if (req != null && req.equals("list")) {
		includeP = "stockList.jsp";
	} else if(req.equals("reg")) {
		includeP = "insertStock.jsp";
	} else {
		includeP = "totalStock.jsp";
	}
	
	pageContext.setAttribute("page", includeP);
%>
<div id = "page">
	<jsp:include page="../header.jsp" />
	<jsp:include page="../nav.jsp" />
	<aside>
		<ul id="aside-ul">
			<li class="aside-li"><a href="totalstock">총 채고량</a></li>
			<li class="aside-li"><a href="stockList">재고 입/출 리스트</a></li>
			<li class="aside-li"><a href="registStock">재고 등록</a></li>
			<li class="aside-li">세부메뉴4</li>
			<li class="aside-li">세부메뉴5</li>
			<li class="aside-li">세부메뉴6</li>
		</ul>
	</aside>
	<section>
		<jsp:include page="${page }" />
	</section>
</div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>