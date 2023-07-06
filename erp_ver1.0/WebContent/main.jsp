<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	* {
		box-sizing: border-box;
	}
	
	#page {
        width: 1400px; height: 900px;
        margin: 0px auto;
        display: grid;
        grid-gap: 10px;
        grid-template-columns: 15% 1fr;
        grid-template-rows: 10% 100px 1fr;
        grid-template-areas: 
            "header header"
            "nav nav"
            "aside section"
        ;
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
</body>
</html>