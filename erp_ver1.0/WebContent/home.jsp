<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	section {
		grid-area : section;
		border : 1px solid black;
		box-shadow: 5px 5px 5px grey;
	}
	
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
	<section>
		<div>
			<h1>초기화면</h1>
		</div>
	</section>
</body>
</html>