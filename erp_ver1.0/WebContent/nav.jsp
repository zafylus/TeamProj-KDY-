<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	nav {
		grid-area : nav;
		border: 1px solid black;
		box-shadow: 5px 5px 5px grey;
	}
	
	nav > ul {
		margin : 0px;
		padding : 0px;
		text-align: center;
	}
	
	nav li {
		display : inline-block;
		width : 200px;
		font-size: 40px;
	}
	
	
	
</style>
</head>
<body>
	<nav>
		<ul>
			<li><a href="main.jsp">메인</a></li>
			<li>매출</li>
			<li><a href="expense.jsp">매입</a></li>
			<li><a href="totalstock">재고</a></li>
			<li>상품</li>
			<li>직원</li>
		</ul>
	</nav>
</body>
</html>