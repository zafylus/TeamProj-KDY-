<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지출 등록</title>
<link href="css/bootstrap.css" rel="stylesheet" >
<script src="js/jquery.js"></script>
<style>
	.Insert {
		transform: translateY(50%);
	}
</style>
</head>
<body>
<%
	String confirm = request.getParameter("confirm");
	if(confirm != null) {
%>
		<script>
			if(confirm("재고 등록도 하시겠습니까?")) {
				location.href="insertStock?name=${code}&ea=${ea}";
			} else {
				location.href="expenseList";
			}
		</script>
<%		
	}
%>
	<div class="container-fluid">
		<div class="row mt-5 Insert">
			<div class="col text-center">
				<h1>지출 등록</h1>
			</div>
		</div>
		<div class="row Insert">
			<div class="offset-sm-4 col-sm-4">
				<form action="InsertExpnese" method="post">
					<div class="input-group mb-4">
						<span class="input-group-text" id="basic-addon1">제품명</span>
						<input type="text" class="form-control" placeholder="제품명" name="ma_name" aria-describedby="basic-addon1">
					</div>
					<div class="input-group mb-4">
						<span class="input-group-text">&#8361;</span>
						<input type="text" class="form-control" name="ex_cost" aria-label="Amount (to the nearest dollar)">
						<span class="input-group-text">원</span>
					</div>
					<div class="input-group mb-5">
						<span class="input-group-text" id="basic-addon1">수량</span>
						<input type="number" class="form-control" name="ex_ea" placeholder="수량" aria-describedby="basic-addon1">
					</div>
					<div class="text-center">
						<input class="btn btn-primary" type="submit" value="등록" onclick="return inputCheck()">
					</div>
				</form>
			</div>
		</div>
	</div>
<script>
	let name = $('input[name="ma_name"]');
	let cost = document.querySelector('input[name="ex_cost"]');
	let ea = $('input[name="ex_ea"]');

	function inputCheck() {
		if(name.value.length == 0) {
			alert("제품명을 입력하세요.");
			return false;
		}
		
		if(cost.value.length == 0) {
			alert("가격을 입력하세요.");
			return false;
		}
		
		if(ea.value.length == 0) {
			alert("수량을 입력하세요.");
			return false;
		}
		return true;
	}
</script>
<script src="js/bootstrap.bundle.js" ></script>
</body>
</html>