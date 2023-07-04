<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a class="test"></a>
	<a class="test"></a>
	<a class="test"></a>
	<a class="test"></a>
	<a class="test"></a>
</body>
<script type="text/javascript">
		let tests = document.querySelectorAll(".test");
		
		tests.forEach(function(test) {
			console.log(test);
			alert(test);
			
			test.addEventListener("focus", focus_nav);
			
		});
		
		console.log("for");
		for (var i = 0; i < tests.length; i++) {
			alert(tests[i]);
			console.log(tests[i]);
		}
		
		function focus_nav(e) {
			alert("test");
			
		}
</script>
</html>