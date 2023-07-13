<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
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
	<aside class="container-fluid border shadow p-3  bg-body rounded">
		<ul id="aside-ul" class="nav justify-content-center">
			<li class="aside-li nav-item"><a class="nav-link" href="#">세부메뉴1</a></li>
			<li class="aside-li nav-item"><a class="nav-link" href="#">세부메뉴2</a></li>
			<li class="aside-li nav-item"><a class="nav-link" href="#">세부메뉴3</a></li>
			<li class="aside-li nav-item"><a class="nav-link" href="#">세부메뉴4</a></li>
			<li class="aside-li nav-item"><a class="nav-link" href="#">세부메뉴5</a></li>
			<li class="aside-li nav-item"><a class="nav-link" href="#">세부메뉴6</a></li>
		</ul>
	</aside>
</body>
</html>