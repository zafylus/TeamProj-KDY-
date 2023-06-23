<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title> 
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/index.global.min.js'></script>

<link rel="stylesheet" type="text/css" href="ui2.css">
</head>
<body>
	<div class="container">
		<header>
			<div class="title">매출</div>
			<div class="big_btn">
				<button>매출</button>
				<button>지출</button>
				<button>재고</button>
			</div>
		</header>
		<div class="date_select_box">
			<div>
				기 간 <input type="date" class="date"> 부터 <input type="date"
					class="date"> 까지
				<button class="btn1 btn_size1">영업일</button>
				<button class="btn1 btn_size1">전일</button>
				<button class="btn1 btn_size1">당월</button>
				<button class="btn1 btn_size1">전월</button>
			</div>

		</div>
		<div class="select_box">
			<button class="btn1 btn_size2" name="month">월 별</button>
			<button class="btn1 btn_size2" name="day">일 별</button>
			<button class="btn1 btn_size2" name="menu">메뉴별</button>
		</div>
		</div>
		<c:set var="mlist" value="sessionScope.mlist"/>
		<c:if test="${!mlist==null || !empty mlist }">
			<table>
				<tr>
					<th>
						날짜					
					</th>
					<th>
							판매금액				
					</th>
					<th>
								마진			
					</th>
					<th>
								지출			
					</th>
					<th>
								순이익			
					</th>
				
				</tr>
			
			
			</table>
		</c:if>
		<div class="section_box">
			<div class ="section"></div>
			
		</div>
	<script>
	 let month = document.querySelector('button[name="month"]');
	  let day = document.querySelector('button[name="day"]');
	  let menu = document.querySelector('button[name="menu"]');
	  let result = document.querySelector('.section');

	  month.addEventListener("click", loadDoc);
	  day.addEventListener("click", showCalendar);
	  menu.addEventListener("click", loadDoc);

	  function getMonth() {
			response.sendRedirect("/erp00/month");
			
	  }

	
	  
	
	</script>
</body>
</html>