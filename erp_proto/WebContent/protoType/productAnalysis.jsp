<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>erp</title>
<link rel="stylesheet" type="text/css" href="css/erp.css">
<link rel="stylesheet" type="text/css" href="css/saleAnalysis.css">
<link rel="stylesheet" type="text/css" href="css/productAnalysis.css">

<script src="jquery/jquery-3.7.0.js"></script>
</head>
<body>
	<c:import url="importPage/header.jsp" />
	<c:import url="importPage/nav.jsp" />
	<div class="container">
		<c:import url="importPage/side.jsp" />
		<section>
			<div class="an_header">
				<div class="an_title">top 3 인기 상품</div>
			</div>
			<div class="product_showlist" data-table="top3">
				<div class="topOrder">
				<div class="top1">top 1</div>
				<div class="pr_top1"></div>
					<div class="total_cnt"></div>
					<div class="pr_pay"></div>
					</div>
				<div class ="top_value"></div>
				<div class ="top_value"></div>
			
			</div>

			<div class="an_header">
				<div class="an_title">카테고리 별 주문</div>
			</div>
			<div class="product_showlist" data-table="ctgy">해당 기간에 매출이
				없습니다.</div>

		</section>
	</div>

	<script type="text/javascript">
		let navs = document.querySelectorAll(".nav");
		let sides = document.querySelectorAll(".side_btn");
		let sub = document.querySelectorAll(".sub_box");

		// nav css

		//side css 
		for (var index = 0; index < sides.length; index++) {
			sides[index].addEventListener("focus", focus_side);
			sides[index].addEventListener("click", transData);
			sides[index].addEventListener("blur", blur_side);
		};

		// nav
		function focus_nav(e) {
			let target = $(e.target);
			target.css("color", "#1c8dff");
			target.css("borderBottom", "3px solid #1c8dff");
			target.off("mouseout", blur);
		}

		function blur_nav(e) {
			let target = $("e.target");
			target.css("color","#4e4e4e");
			target.css("borderBottom","none");
		}

		// sub
		navs.forEach(function(nav) {
			nav.addEventListener("focus", focus_nav);
			nav.addEventListener("blur", blur_nav);
			nav.addEventListener("blur", function() {
				setTimeout(sub_off, 120);
			});
			nav.addEventListener("focus", function(e) {
				setTimeout(function() {
					sub_on(e.target);
				}, 130);
			});
		});

		// sub
		function sub_on(target) {
			let index = Array.from(navs).indexOf(target);
			sub[index].style.display = "flex";
		}

		function sub_off() {
			sub.forEach(function(subBox) {
				subBox.style.display = "none";
			});
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
		
		function transData(e){
			let unit = e.target.getAttribute("data-unit"); // 데이터 속성 값 가져오기
			let term = e.target.getAttribute("data-term");
			let top = $("div[data-table=top3]");
			let ctgy = $("div[data-table=ctgy]");
			
			
			const x = new XMLHttpRequest();
			x.onload = function() {
				  let js = this.responseText;
				  let jo = JSON.parse(js);
				  console.log("jo :" +jo);
				  

				  let dataMap = new Map();
				  // dataMap에 값을 추가
				  dataMap.set("totalSale", jo.totalSale);
				  dataMap.set("CtgyOrderList", jo.CtgyOrderList);
				  dataMap.set("topList", jo.topList);

				 
				  
				  let ctgyOrderList = dataMap.get("CtgyOrderList");
				  let topList = dataMap.get("topList");
				  
				  
				  let totalCnt = dataMap.get("totalSale");
				  let spanTotalCnt = document.createElement("span");
				  spanTotalCnt.textContent = totalCnt +"건";
				  
				  let spanPrdCnt = document.createElement("span");
				  spanPrdCnt.textContent = topList[0].saleCnt +"건";
				  
				  
				  $(".total_cnt").empty().append("총 ", spanTotalCnt, "의 주문수 중 ", spanPrdCnt, " 주문");
				 
				  console.log("ctgyOrderList :" + ctgyOrderList);
				  console.log("topList :" + topList);
				  $(".pr_top1").text(topList[0].prName);
				  $(".pr_pay").text(topList[0].pay + "원");
		    	  
		    			$(".top_value").empty();
		    			$(".top_value").each(function(index, item) {
		    				  $(item).append($("<div>").text(index + 2));
		    				  $(item).append($("<div>").text(topList[index + 1].prName));
		    				  $(item).append($("<div>").text(topList[index + 1].saleCnt));
		    				  $(item).append($("<div>").text(topList[index + 1].pay + "원") );

		    				  $(item).find("div:nth-child(1), div:nth-child(2)").css("padding-right", "40px");
		    				});
				};

			x.open("POST","../sale",true);
			x.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			x.send("unit=" + unit +  "&term=" + term);
		}
		
		
		    // 테이블 바디 생성

		    /* 	<div class="product_showlist" data-table="top3">
				<div><div>top 1</div></div>
				<div><div class="pr_top1"></div></div>
				<div><div>총 <div class="total_cnt"></div>건의 주문 수 중 </div><div class="pr_cnt"></div>주문</div>
				<div class ="top_value"></div>
				<div class ="top_value"></div>
			
			</div> */
		    // topList의 각 요소를 테이블에 추가
	

		    // 테이블에 바디 추가

		    // top div에 테이블 추가
		
	</script>
</body>
</html>