<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재고 계산</title>
<link href="css/bootstrap.css" rel="stylesheet" >
<script src="js/jquery.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row text-center mb-5 mt-5">
			<h2>제품 생산 계산</h2>
		</div>
		<div class="row">
			<div class="offset-sm-4 col-sm-4 border rounded pt-3 me-3">
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
			
	
		</div>
		<div class="row justify-content-center mt-3 mb-5">
			<div class="col-sm-1">
				<button type="button" class="btn btn-primary" onclick="calc()">계산</button>
			</div>
		</div>
		<div class="row">
			<div class="offset-sm-2 col-sm-4 text-center">
				<table class="table tbl" style="display:none">
					<thead>
						<tr class="table-secondary">
							<th colspan="2">생산 가능한 수량</th>
						</tr>
					</thead>
					<tbody id="txt1">
						
					</tbody>
				</table>
			</div>
			
			<div class="col-sm-4 text-center">
				<table class="table tbl" style="display:none">
					<thead>
						<tr class="table-secondary">
							<th colspan="2">남은 재고량</th>
						</tr>
					</thead>
					<tbody id="txt2">
						
					</tbody>
				</table>
			</div>
		</div>
	</div>
<script>
	var s_ma = $('select[name="material"]');
	
	

	function calc() {
		
			let arr = [];
			let pro = $('input[name="product"]:checked');
			$(pro).each(function() {
				arr.push($(this).val());
			});
			if(arr.length == 0) {
				alert("계산할 항목을 선택해주세요.");
				return;
			}
			
			$.ajax({
				url : "stock-c",
				type : "POST",
				traditional : true,
				data: {
					products : arr, 
					priority : $(s_ma).val()
				},
				
				success : function(data) {
					$('.tbl').css({display:""});
					$('#txt1').html("");
					$('#txt2').html("");
									
					let list = JSON.parse(data);
					let clist = list.clist;
					let slist = list.slist;
					
					for (var i = 0; i < clist.length; i++) {
						$('#txt1').append(
								"<tr>"
							+	"<td>"+clist[i].pr_name+"</td>"
							+	"<td>"+clist[i].pr_ea+" 잔 </td> </tr>");
					}
					
					for (var i = 0; i < slist.length; i++) {
						$('#txt2').append(
								"<tr>"
							+	"<td>"+slist[i].ma_name+"</td>"
							+	"<td>"+slist[i].totalEa+"</td> </tr>");
					}
					
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