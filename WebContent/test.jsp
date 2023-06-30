<%@page import="java.sql.Connection"%>
<%@page import="dbCon.DBcon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Connection con = (new DBcon()).getConnection();
	 %>
</body>
</html>