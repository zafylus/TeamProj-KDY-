<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<!-- CSS only -->
<link href="css/bootstrap.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
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
	
	section {
		grid-area : section;
		border : 1px solid black;
		box-shadow: 5px 5px 5px grey;
	}
</style>
</head>
<body>
<div id = "page">
	<jsp:include page="header.jsp" />
	<jsp:include page="nav.jsp" />
	<jsp:include page="aside.jsp" />
	<jsp:include page="home.jsp" />
</div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>