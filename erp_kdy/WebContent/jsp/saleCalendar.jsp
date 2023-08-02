<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>erp</title>

<link rel="stylesheet" type="text/css" href="../css/erp.css">
<link rel="stylesheet" type="text/css" href="../css/saleCalendar.css">
 <script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/index.global.min.js"></script>

</head>
<body>
	<c:import url="../importPage/header.jsp"/>
	<c:import url="../importPage/nav.jsp"/>
	<div class="container">
		<c:import url="../importPage/side.jsp"/>
		<section id="calendar"></section>
	</div>
	

	<script src="../js/common/jquery-3.7.0.js"></script>
	<script src="../js/common/importPage.js"></script>
	<script src="../js/library/fullCalendar.js"></script>
	<script src="../js/sale/saleCalendar.js"></script>
</body>
</html>