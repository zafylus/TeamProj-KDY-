<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<style>
	#regStock {
		display:flex;
		flex-direction : column;
		align-items: center;
	}

	#regStock  h2 {
		text-align: center;
		font-size: 50px;
		width: 800px;
		margin-top : 30px;
		margin-bottom : 80px;
		padding: 30px;
		border-bottom: 1px solid grey;
	}
	
	form {
		display:flex;
		width: 400px; height: 300px;
		flex-direction : column;
		align-content : center;
	}
	
	.inputs {
		height:50px;
	}
	
	form > select, input {
		font-size: 30px;
	}
	
	
</style>
</head>
<body>
	<div id="regStock">
		<h2>재고 등록</h2>
		<br>
		<form action="" method="post">
			<select name="ma_code" class="inputs">
				<option>재고명 선택</option>
				<option value="MA001">원두</option>
				<option value="MA002">우유</option>
				<option value="MA003">시럽</option>
			</select><br>
			<input type="text" name="st_ea" class="inputs" placeholder="수량을 입력하세요."><br>
			<input type="submit" value="등록">
		</form>
	</div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>