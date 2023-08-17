<%@page import="services.Service_st"%>
<%@page import="util.OptionCheck"%>
<%@page import="vos.TotalStockVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Header Page</title>
<link rel="stylesheet" href="css/bootstrap.css">
<script src="js/jquery.js"></script>
<style>
	header {
		position: relative;
	}
</style>
</head>
<body>
<%
	Service_st st_serv = new Service_st();

	ArrayList<TotalStockVO> alist = st_serv.getTotalList();
	boolean opt = OptionCheck.getAlramOpt();
	int alNum = OptionCheck.alramStockNum();
	
%>
	<header class="container-fluid border shadow p-3  bg-body rounded text-center">
		<div class="row">
			<div id="liveAlertPlaceholder" class="col-sm-2"></div>
			<div class="col-sm-8">
				<h1>ERP System  [ver 1.2]</h1>
			</div>
				<div class="col-sm-2">
				 	<div id="user-profile" tabindex="0">
				        <div class="user-icon"></div>
				        <div class="user-id"></div>
				        <div id="logout">로그아웃</div>
		    		</div>  
		    		<button id="login-button">로그인</button>		
				</div>
		</div>
<%
	if (opt) {
		for(TotalStockVO vo : alist ) {
			if(vo.getTotalEa() <= alNum) {
		%>
			<script>
				$("#liveAlertPlaceholder").append(
						'<div class="col-sm-12 text-center alert alert-danger alert-dismissible fade show" role="alert">'
	 					+ '<strong><%= vo.getMa_name()%></strong>  재고량 확인요망.'
	 					+ '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>'
						+ '</div>')
			</script>
		<%
			}
		}
	}
%>
	</header>
<script type="text/javascript">
	var msg = "${sessionScope.msg}";
	var	userId = "${sessionScope.userId}";
	
	console.log(userId);
	document.getElementById("login-button").addEventListener("click", function() {
	  // 현재 페이지의 URL을 이전 페이지 변수에 저장
	  previousPageUrl = window.location.href;
	  // login.jsp로 이동
	  window.location.href = "/erp_ver1.2/loginMove";
	});

	// 로그인 성공 시 화면 변경
	function showUserProfile(userId) {
	  var userIdElement = document.querySelector(".user-id");
	  var logout = document.querySelector("#logout");

	  // 로그인 버튼 숨김 처리
	  document.getElementById("login-button").style.display = "none";
	  // 부모 div, 유저 아이콘, 유저 아이디 표시
	  document.getElementById("user-profile").style.display = "flex";
	  logout.style.display = "none"; // 초기에 로그아웃은 숨김 처리

	  userIdElement.textContent = userId;


	  // 로그아웃 클릭 시 로그아웃 처리
	 logout.addEventListener("click", function() {
		  fetch("/erp_ver1.2/loginCheck?logout=true", { method: "POST" })
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
<script src="js/bootstrap.bundle.js"></script>
</body>
</html>