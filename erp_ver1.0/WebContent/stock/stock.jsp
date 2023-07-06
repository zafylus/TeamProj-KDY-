<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	* {
		box-sizing: border-box;
	}
	
	#page {
        width: 1400px; height: 900px;
        margin: 0px auto;
        display: grid;
        grid-gap: 10px;
        grid-template-columns: 15% 1fr;
        grid-template-rows: 10% 100px 1fr;
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

	ul {
		list-style: none;
		margin : 0px;
		padding : 0px;
	}
	
	li {
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
		<ul>
			<li><a href="totalstock">총 채고량</a></li>
			<li><a href="stockList">재고 입/출 리스트</a></li>
			<li><a href="registStock">재고 등록</a></li>
			<li>세부메뉴4</li>
			<li>세부메뉴5</li>
			<li>세부메뉴6</li>
		</ul>
	</aside>
	<section>
		<jsp:include page="${page }" />
	</section>
</div>
</body>
</html>