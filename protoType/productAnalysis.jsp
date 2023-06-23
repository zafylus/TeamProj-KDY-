<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>erp</title>
<link rel="stylesheet" type="text/css" href="css/all.css">
<link rel="stylesheet" type="text/css" href="css/erp.css">
<link rel="stylesheet" type="text/css" href="css/saleAnalysis.css">
<link rel="stylesheet" type="text/css" href="css/productAnalysis.css">
</head>
<body>
	<c:import url="importPage/header.jsp" />
	<c:import url="importPage/nav.jsp" />
	<div class="container">
		<c:import url="importPage/side.jsp" />
		<section>
			<div class="an_header">
				<div class="an_title">top 3 상품</div>
				<div class="an_date">2023.06.23 18:36 기준</div>
			</div>
			<div class="product_showlist">해당 기간에 매출이 없습니다.</div>
			
			
			
			<div class="an_header">
				<div class="an_title">카테고리 별 주문</div>
				<div class="an_date"><button>모두 보기</button></div>
			</div>
			<div class="product_showlist">해당 기간에 매출이 없습니다.</div>
			
			
			
			





		</section>
	</div>

	<script type="text/javascript">
		let navs = document.querySelectorAll(".nav");
		let sides = document.querySelectorAll(".side_btn");
		let sub = document.querySelector(".sub_box");

		// nav css
		for (var index = 0; index < navs.length; index++) {
			navs[index].addEventListener("focus", focus_nav);
			navs[index].addEventListener("blur", blur_nav);

		};

		//nav -> sub 메뉴 css
		navs[0].addEventListener("focus", sub_on);
		navs[0].addEventListener("blur", function() {
			  setTimeout(sub_off, 90);
			});
		

		//side css 
		for (var index = 0; index < sides.length; index++) {
			sides[index].addEventListener("focus", focus_side);
			sides[index].addEventListener("blur", blur_side);
		};

		// nav
		function focus_nav(e) {
			let target = e.target;
			target.style.color = "#1c8dff";
			target.style.borderBottom = "3px solid  #1c8dff";
			target.removeEventListener("mouseout", blur);
		}

		function blur_nav(e) {
			let target = e.target;
			target.style.color = "#4e4e4e";
			target.style.borderBottom = "none";
		}

		// sub
		function sub_on() {
			sub.style.display = "flex";
		}
		function sub_off() {
			sub.style.display = "none";
		}

		// side
		function focus_side(e) {
			let target = e.target;
			target.style.color = "#1c8dff";
			target.style.background = "#e6e6ff";
		}
		function blur_side(e) {
			let target = e.target;
			target.style.color = "#4e4e4e";
			target.style.background = "white";
		}
	</script>
</body>
</html>