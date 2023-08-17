<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>erp</title>
 <%
 
 LocalDate now = LocalDate.now();
 String nowDate = now.format(java.time.format.DateTimeFormatter.ofPattern("yyyy.MM.dd"));
 
 
 LocalDateTime nowDateTime = LocalDateTime.now();

 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd [HH:mm] '기준'");
 String formattedDateTime = nowDateTime.format(formatter);

 System.out.println(formattedDateTime);
%>
<link rel="stylesheet" type="text/css" href="/erp_ver1.2/css/erp.css">
<link rel="stylesheet" type="text/css" href="/erp_ver1.2/css/saleAnalysis.css">
<link rel="stylesheet" href="/erp_ver1.2/css/modal.css">
<link rel="stylesheet" href="/erp_ver1.2/css/datepicker.css">
</head>
<body>
			<div class="an_header">
				<div class="an_title">매출</div>
				<div class="an_date"><%=formattedDateTime %></div>
			</div>
			<div class="an_container">
				<div class="an_box sale">
					<div>
						<p>매출</p>
						<div>
							<span class="an_value ">0</span>원
						</div>

					</div>
					<div>
						<p>결제 건수</p>
						<div>
							<span class="an_value ">0</span>건
						</div>
					</div>
					<div>
						<p>평균 결제 금액</p>
						<div>
							<span class="an_value avg_sale">0</span>원
						</div>
					</div>
				</div>




				<div class="an_box refund">
					<div>
						<p>환불 금액</p>
						<div>
							<span class="an_value red total_refund">0</span>원
						</div>
					</div>
					<div>
						<p>환불 건수</p>
						<div>
							<span class="an_value red refund_cnt">0</span>건
						</div>
					</div>
					<div>
						<p>평균 환불 금액</p>
						<div>
							<span class="an_value red avg_refund">0</span>원
						</div>
					</div>
				</div>
			</div>
			<div id="myModal" class="modal">
			    <div class="modal-content">
				    <span class="close">&times;</span>
				        시작 날짜<br>
					<input class="datepicker begin_date"  value="<%= nowDate %>"><br>
					 종료 날짜<br>
					<input class="datepicker end_date" value="<%= nowDate %>">
					<button class="select_btn">조회</button>
    			</div>
 		 	</div>
	<script type="text/javascript">
	var	userId = "${sessionScope.userId}";
	
	document.getElementById("login-button").addEventListener("click", function() {
	  // 현재 페이지의 URL을 이전 페이지 변수에 저장
	  previousPageUrl = window.location.href;
	  // login.jsp로 이동
	  window.location.href = "/erp_ver1.2/loginMove";
	});

	// 로그인 성공 시 화면 변경
	function showUserProfile(userId) {
	 
	  var userIdElement = document.querySelector(".user-id");
	  var logout = document.querySelector(".logout");

	  // 로그인 버튼 숨김 처리
	  document.getElementById("login-button").style.display = "none";
	  // 부모 div, 유저 아이콘, 유저 아이디 표시
	  document.getElementById("user-profile").style.display = "flex";
	  logout.style.display = "none"; // 초기에 로그아웃은 숨김 처리

	  userIdElement.textContent = userId;


	  // 로그아웃 클릭 시 로그아웃 처리
	 logout.addEventListener("click", function() {
		  fetch("../loginCheck?logout=true", { method: "POST" })
		    .then(function(response) {
		      // 로그아웃 처리 완료 후 페이지 새로고침
		      window.location.reload();
		    })
		});

	  // 클릭 이벤트 리스너 추가하여 로그아웃 사라지도록 처리
	  userIdElement.addEventListener("click", function(event) {
		  if (logout.style.display !== "inline-block") {
		    logout.style.display = "inline-block";
		    event.stopPropagation();
		  }
		});

		document.addEventListener("click", function(event) {
		  if (logout.style.display === "inline-block" && !logout.contains(event.target)) {
		    logout.style.display = "none";
		  }
		});
	}

	// 세션에서 유저 아이디를 받아온 후 프로필을 표시
	if (userId) {
	  // 유저 아이디가 존재하는 경우
	  showUserProfile(userId);
	}
	
	</script>
<script src="/erp_ver1.2/js/common/jquery-3.7.0.js"></script>
<script src="/erp_ver1.2/js/library/datepickerModal.js"></script>
<script src="/erp_ver1.2/js/library/datepicker.js"></script>
<script src="/erp_ver1.2/js/library/datepicker.ko-KR.js"></script>
 <script src="/erp_ver1.2/js/sale/saleAnalysis.js"></script>
 <script src="/erp_ver1.2/js/bootstrap.bundle.js"></script>
</body>
</html>