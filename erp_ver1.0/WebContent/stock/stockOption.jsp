<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<!-- CSS only -->
<link href="css/bootstrap.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="js/jquery-3.7.0.js"></script>
<style>
	#opt {
		margin : 20px auto;
		padding : 50px;
		width: 550px; height: 100%;
	}
	
	.container {
		padding-botton : 0px;
	}
</style>
</head>
<body>
		<form id ="opt" action="StockOption" method="post">
		    <div class="container border h-100 pt-5 text-center shadow-lg p-3 mb-5 bg-body rounded" >
		    	<div class="row">
		    		<h2 style="margin-bottom: 50px">Option</h2>
		    		<hr>
		      		<br>
		    	  </div>
		     	 <div class="row justify-content-center mb-5">
		      		  <div class="col d-flex justify-content-center form-check form-switch" >
		          		<input class="form-check-input h-75" name="alramStock" style="width:50px" type="checkbox" role="switch" id="flexSwitchCheckChecked" value="checked" ${alOpt }>
		        	  	<label class="form-check-label" for="flexSwitchCheckDefault"><p class="fs-5 align-middle m-0">&nbsp;&nbsp;재고 부족 알람 설정</p></label>
		        </div>
		      </div>
		      <div class="row justyfy-content-center">
				<div class="input-group mb-3" style="width : 380px; margin : 0px auto;">
				  <span class="input-group-text bg-primary text-white" id="basic-addon1" >알림 수치</span>
				  <input type="number" class="form-control" name="alramNum" placeholder="알림 받을 수량을 입력하세요." aria-label="Username" aria-describedby="basic-addon1" value="${alNum }">
				</div>
		      </div>
		      <div class="row h-50" style="margin-bottom : 40px">
		      </div>
		      <div class="row  justify-content-center">
		      	<button type="submit" class="btn btn-primary align-middle w-25 " onclick="return saveOpt()">저장</button>
		      </div>
		    </div>
		</form>
	<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script>
	function saveOpt() {
		if($('input[name="alramNum"]').val().length == 0) {
			alert("알림을 받을 수량을 입력해주세요.");
			$('input[name="alramNum"]').focus();
			return false;
		}
		alert("옵션 저장 완료");
		return true;
	}
</script>
</body>
</html>