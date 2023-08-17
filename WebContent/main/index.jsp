<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<!-- CSS only -->
<link href="/erp_ver1.2/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/erp_ver1.2/css/erp.css">
	<script src="/erp_ver1.2/js/jquery.js"></script>
<style>
	* {
		box-sizing: border-box;
	}
	
	#page {
        width: 1600px; height: 900px;
        margin: 20px auto;
        display: grid;
        grid-gap: 10px;
        grid-template-columns: 266px 1fr;
        grid-template-rows: 100px 50px 1fr;
        grid-template-areas: 
            "header header"
            "nav nav"
            "aside section"
        ;
	}
	
	header {
		grid-area : header;
	}
	
	aside {
		grid-area : aside;
	}
	
	nav {
		grid-area : nav;
	}
	
	section {
		grid-area : section;
	}
</style>
</head>
<body>
<div id = "page">
	<jsp:include page="../header.jsp" />
	<jsp:include page="nav.jsp" />
	<jsp:include page="aside.jsp" />
	<jsp:include page="home.jsp" />
</div>
<!-- JavaScript Bundle with Popper -->
<script type="text/javascript">
	var msg = "${sessionScope.msg}";
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
<script src="/erp_ver1.2/js/bootstrap.bundle.js"></script>
</body>
</html>