<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/login.css" >
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
<script>
	var error = ${error};
	if (error == 1)
		alert("아이디 또는 비밀번호를 확인하세요.");
</script>
<div class="login-container">
 <div class="erp-text">ERP</div>
  <form action="/erp_ver1.1/loginCheck" method="post" class="login-form">
    <div class="input-group radius-top">
      <i class="fas fa-user icon"></i>
      <input type="text" name="id" placeholder="ID">
    </div>
    <div class="input-group radius-bottom">
      <i class="fas fa-lock icon"></i>
      <input type="password" name="pw" placeholder="Password">
    </div>
    <button class="login-button">로그인</button>
  </form>
</div>
</body>
