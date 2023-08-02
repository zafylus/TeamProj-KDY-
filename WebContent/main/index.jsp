<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<!-- CSS only -->
<link href="css/bootstrap.css" rel="stylesheet">
<script src="js/jquery.js"></script>
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
		border : 1px solid black;
		box-shadow: 5px 5px 5px grey;
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
<script src="js/bootstrap.bundle.js"></script>
</body>
</html>