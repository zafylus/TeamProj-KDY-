<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>erp</title>
<link rel="stylesheet" type="text/css" href="css/erp.css">
</head>
<body>
	<c:import url="importPage/header.jsp" />
	<c:import url="importPage/nav.jsp" />
	<div class="container">
		<div class="side_box">
			<button class="side_btn">당일</button>
			<button class="side_btn">전 일</button>
			<button class="side_btn">전 달</button>
			<button class="side_btn">1개월</button>
			<button class="side_btn">3개월</button>
			<button class="side_btn">기간 선택</button>
		</div>
		<section></section>
	</div>

	<script type="text/javascript">
		let navs = document.querySelectorAll(".nav");
		let sides = document.querySelectorAll(".side_btn");
		
		for (var index = 0; index < navs.length; index++) {
			  navs[index].addEventListener("focus", focus);
			  navs[index].addEventListener("blur", blur);
		};
		
			function focus(e){
				let target = e.target;
				target.style.color = "#1c8dff";
				target.style.borderBottom = "3px solid  #1c8dff";
			}
			function blur(e){
				let target = e.target;
				target.style.color = "#4e4e4e";
				target.style.borderBottom = "none";
			}
			
			
			for (var index = 0; index < sides.length; index++) {
				  sides[index].addEventListener("focus", focus_side);
				  sides[index].addEventListener("blur", blur_side);
			};
			
				function focus_side(e){
					let target = e.target;
					target.style.color = "#1c8dff";
					target.style.background ="#e6e6ff";
				}
				function blur_side(e){
					let target = e.target;
					target.style.color = "#4e4e4e";
					target.style.background ="white";
				}
	</script>
</body>
</html>