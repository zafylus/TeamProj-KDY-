<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link href="css/bootstrap.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<style>
	section > div {
		width: 300px; height: 300px;
		top : 50%; left : 50%;
		transform: translate(-50%, -50%);
		background-color : silver;
		position: relative;
	}
	
	section > div > h1 {
		text-align: center;
		line-height: 300px;
	}
</style>
</head>
<body>
	<section class="container-fluid border shadow p-3  bg-body rounded">
		<div>
			<h1>초기화면</h1>
		</div>
	</section>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>