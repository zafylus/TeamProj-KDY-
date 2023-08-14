<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/erp_ver2.0/css/bootstrap.css">
<script src="/erp_ver2.0/js/jquery.js"></script>
<title>Insert title here</title>
<style>
	.aside-li {
		line-height: 100px;
	}
</style>
</head>
<body>
	<aside class="container-fluid border shadow p-3  bg-body rounded">
		<ul id="aside-ul" class="nav justify-content-center m-0 p-0 text-center">
			<li class="aside-li nav-item"><a class="side_btn nav-link" data-dateUnit="fix_day" data-dateValue="0" href="#">당일</a></li>
			<li class="aside-li nav-item"><a class="side_btn nav-link" data-dateUnit="fix_day" data-dateValue="1" href="#">전 일</a></li>
			<li class="aside-li nav-item"><a class="side_btn nav-link" data-dateUnit="fix_month" data-dateValue="1" href="#">전 달</a></li>
			<li class="aside-li nav-item"><a class="side_btn nav-link" data-dateUnit="fix_month" data-dateValue="3" href="#">3개월</a></li>
			<li class="aside-li nav-item"><a class="side_btn nav-link" data-dateUnit="free" data-dateValue="입력 대기 중" href="#">기간 선택</a></li>
		</ul>
	</aside>
<script src="/erp_ver2.0/js/bootstrap.bundle.js"></script>
</body>
</html>