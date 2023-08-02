<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stock Calculator</title>
<link href="css/bootstrap.css" rel="stylesheet" >
<script src="js/jquery.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row text-center mb-5">
			<h2>제품 생산 계산</h2>
		</div>
		<div class="row">
			<div class="offset-sm-2 col-sm-4 border rounded pt-3 me-3">
				<table class="table">
					<thead>
						<tr class="table-info">
							<th><input class="form-check-input" type="checkbox" id="allChk"></th>
							<th>상품명</th>
						</tr>
					</thead>
					<tbody>
							<tr>
								<td><input class="form-check-input chkbox" type="checkbox" id="PR1" name="product" value="PR001"></td>
								<td><label class="form-check-label" for="flexCheckDefault">아메리카노</label></td>
							</tr>
							<tr>
								<td><input class="form-check-input chkbox" type="checkbox" id="PR2" name="product" value="PR002"></td>
								<td><label class="form-check-label" for="flexCheckDefault">카페라떼</label></td>
							</tr>
							<tr>
								<td><input class="form-check-input chkbox" type="checkbox" id="PR3" name="product" value="PR003"></td>
								<td><label class="form-check-label" for="flexCheckDefault">바닐라라떼</label></td>
							</tr>
					</tbody>
				</table>
			</div>
			
			<div class="col-sm-4">
				<div class="row">
					<div class="col-sm-4">
						<p>우선 순위 설정</p>
					</div>
					<div class="col-sm-3 input-group mb-3">
						<span class="input-group-text" id="addon-wrapping">1순위</span>
						<select class="form-select" id="inputGroup-sizing-default" name="material"aria-label="Default select example">
							  <option selected value="MA">재료 선택</option>
							  <option value="MA001">원두</option>
							  <option value="MA002">우유</option>
							  <option value="MA003">시럽</option>
						</select>
					</div>
					
					<div class="col-sm-3 input-group mb-3">
						<span class="input-group-text" id="addon-wrapping">준비중</span>
						<select class="form-select" id="inputGroup-sizing-default" name="products" aria-label="Default select example">
							  <option selected>계산식</option>
							  <option value="PR001">func1</option>
							  <option value="PR002">func2</option>
							  <option value="PR003">func3</option>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class="row justify-content-center mt-5">
			<div class="col-sm-1">
				<button type="button" class="btn btn-primary" onclick="f()">계산</button>
			</div>
		</div>
		<div class="row">
			<div class="col" id="txt">
			</div>
		</div>
	</div>
<script>
	var s_ma = $('select[name="material"]');
	$(s_ma).change(function() {
		
		switch($(s_ma).val()) {
		case "MA002" :
			$('#PR1').attr("disabled", true);
			$('#PR2').attr("disabled", false);
			$('#PR3').attr("disabled", false);
			$('.form-check-label:eq(0)').css('textDecorationLine',  'line-through');
			$('.form-check-label:eq(1)').css('textDecorationLine',  'none');
			$('.form-check-label:eq(2)').css('textDecorationLine',  'none');
			break;
		case "MA003" :
			$('#PR1').attr("disabled", true);
			$('#PR2').attr("disabled", true);
			$('#PR3').attr("disabled", false);
			$('.form-check-label:eq(0)').css('textDecorationLine',  'line-through');
			$('.form-check-label:eq(1)').css('textDecorationLine',  'line-through');
			$('.form-check-label:eq(2)').css('textDecorationLine',  'none');
			break;
		default :
			$('#PR1').attr("disabled", false);
			$('#PR2').attr("disabled", false);
			$('#PR3').attr("disabled", false);
			$('.form-check-label:eq(0)').css('textDecorationLine',  'none');
			$('.form-check-label:eq(1)').css('textDecorationLine',  'none');
			$('.form-check-label:eq(2)').css('textDecorationLine',  'none');
			break;
		}
	})

	function f() {
			let arr = [];
			let pro = $('input[name="product"]:checked');
			$(pro).each(function() {
				arr.push($(this).val());
			});
			console.log(arr);
			
			$.ajax({
				url : "stockCalc",
				type : "POST",
				traditional : true,
				data: {
					products : arr, 
					priority : $(s_ma).val()
				},
				success : function(data) {
						$('#txt').append("<div>"+data+"</div>");
				}
			})
	}
	
	$('#allChk').click(function() {
		if($('#allChk').prop("checked")) {
			var chk = $('.chkbox');
			for (var i = 0; i < chk.length; i++) {
				if(!$(chk[i]).prop('disabled')) {
					$(chk[i]).prop('checked', true);
				}
			}
		} else {
				$('.form-check-input').prop('checked', false);
		}
	})
	
</script>
<script src="js/bootstrap.bundle.js" ></script>
</body>
</html>