
	var	userId =  sessionStorage.getItem('userId');
	console.log(userId);
	
	document.getElementById("login-button").addEventListener("click", function() {
		  // 현재 페이지의 URL을 이전 페이지 변수에 저장
		  previousPageUrl = window.location.href;
		  // login.jsp로 이동
		  window.location.href = "/erp_ver2.0/jsp/login.jsp";
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
		if (userId != null) {
		  // 유저 아이디가 존재하는 경우
		  showUserProfile(userId);
		}
