<%@page import="util.PageCheck"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지출 파트</title>
<!-- CSS only -->
<link href="/erp_ver1.2/css/bootstrap.css" rel="stylesheet" >
<link rel="stylesheet" type="text/css" href="/erp_ver1.2/css/erp.css">
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
        grid-template-rows: 10% 50px 1fr;
        grid-template-areas: 
            "header header"
            "nav nav"
            "aside section"
        ;
	}
	
	header {
		grid-area: header;
	}
	
	nav {
		grid-area: nav;
	}
	
	section {
		grid-area: section;
	}
	
	aside {
		grid-area : aside;
	}
</style>
</head>
<body>
<div id = "page">
	<jsp:include page="../header.jsp" />
	<jsp:include page="nav.jsp" />
	<jsp:include page="aside.jsp" />

	<section class="container-fluid border shadow p-3  bg-body rounded">
		<jsp:include page="${page }" />
	</section>
</div>
<script src="js/bootstrap.bundle.js" ></script>
</body>
</html>