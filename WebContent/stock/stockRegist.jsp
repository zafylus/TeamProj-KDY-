<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재고 등록</title>
<!-- CSS only -->
<link href="css/bootstrap.css" rel="stylesheet" >
<script src="js/jquery.js"></script>
<style>
	#regStock {
		display:flex;
		flex-direction : column;
		align-items: center;
	}

	#regStock >  h2 {
		text-align: center;
		font-size: 40px;
		width: 800px;
		margin-top : 30px;
		margin-bottom : 60px;
		padding: 30px;
		border-bottom: 1px solid grey;
	}
	
	form {
		display:flex;
		width: 400px; height: 300px;
		flex-direction : column;
		align-content : center;
	}
	
	form > select, input, textarea, span {
		font-size: 30px;
	}
	
</style>
</head>
<body>
<%
	String ex_ea = request.getParameter("ea");
		
	pageContext.setAttribute("ea", ex_ea);
%>
	<div id="regStock">
		<h2 class="fw-bold">재고 등록</h2>
		<br>
		<form name="insertForm" action="insertStock" method="post">
			<select name="ma_code" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
				<option selected>재고명 선택</option>
				<option value="MA001">원두</option>
				<option value="MA002">우유</option>
				<option value="MA003">시럽</option>
			</select><br>
			<div class="input-group input-group-lg">
				<span class="input-group-text" id="inputGroup-sizing-lg">수량</span>
				<input type="number" class="form-control" name="st_ea" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" placeholder="수량을 입력하세요." value="${ea }"><br>
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-text" id="inputGroup-sizing-lg">메모</span>
				<textarea class="form-control" aria-label="메모" cols="30" rows="3" name="note"></textarea><br>
			</div>
			<br>
			<input class="btn btn-primary" type="submit" value="등록" onclick="return inputCheck()">
		</form>
	</div>
<script>

	window.onload = function() {
		const ma_code = new URLSearchParams(location.search).get('name');
		if(ma_code != null)
			$('select[name="ma_code"]').val(ma_code);
	}

	function inputCheck() {
		let form = document.insertForm;
		
		if (isNaN(form.st_ea.value)) {
			alert("수량은 숫자만 입력 가능합니다.");
			form.st_ea.select();
			return false;;
		}
		
		alert("재고 등록 완료");
		return true;
	}
</script>
<script src="js/bootstrap.bundle.js" ></script>
</body>
</html>