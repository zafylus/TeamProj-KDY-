<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aside Page</title>
<link rel="stylesheet" href="css/bootstrap.css">
<script src="js/jquery.js"></script>
<style>
	.aside-li {
		line-height: 100px;
	}
</style>
</head>
<body>
	<aside class="container-fluid border shadow p-3  bg-body rounded">
		<ul id="aside-ul" class="nav justify-content-center m-0 p-0 text-center">
			<li class="aside-li nav-item"><a class="nav-link" href="stock-t">총 재고량</a></li>
			<li class="aside-li nav-item"><a class="nav-link" href="stocks">입/출 리스트</a></li>
			<li class="aside-li nav-item"><a class="nav-link" href="stock">재고 등록</a></li>
			<li class="aside-li nav-item"><a class="nav-link" href="stock-c">생산 계산</a></li>
			<li class="aside-li nav-item"><a class="nav-link" href="stock-o">옵션</a></li>
		</ul>
	</aside>
<script src="js/bootstrap.bundle.js" ></script>
</body>
</html>