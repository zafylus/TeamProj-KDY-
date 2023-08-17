<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고정비 목록</title>
<link href="/erp_ver1.2/css/bootstrap.css" rel="stylesheet" >
<script src="/erp_ver1.2/js/jquery.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row text-center justify-content-center">
			<div class="col-sm-4">
				<h2>고정비 목록</h2>
				<hr>
			</div>
		</div>
		
		<div class="row">
			<div class="offset-sm-2 col-sm-8">
				<table class="table table-border">
					<thead>
						<tr class="table-primary text-center">
							<th>번호</th>
							<th onclick="getList()">이름</th>
							<th>가격</th>
							<th>날짜</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
		
		<div class="row text-center">
			<div class="offset-sm-5 col-sm-2">
				<button type="button" class="btn btn-info container-fluid" onclick="addInput()">추가</button>
			</div>
		</div>
	</div>
<script>
	window.onload = getList();

	function getList() {
		$('tbody').html('');
		$.ajax({
			url: "fixedcost?data=1",
			type: "GET",
			dataType: "text",
			success: function(data) {
				let jobj = JSON.parse(data);
				let tbl = "";
				$.each(jobj, function(i){
					tbl += "<tr>"
					tbl += "<td style='width:60px'><input type='text' class='form-control text-center' name='no' value=" + jobj[i].fi_no + " readonly></td>"
					tbl += "<td><input type='text' class='form-control' name='name' value=" + jobj[i].fi_name + "></td>"
					tbl += "<td><div class='input-group mb-3'><input type='text' class='form-control text-end' name='cost' value=" + jobj[i].fi_cost + "><span class='input-group-text'>원</span></div><div></div></td>"
					tbl += "<td style='width:120px;'><div class='input-group mb-3'><input type='text' class='form-control text-end' name='date' value=" + jobj[i].fi_date + "><span class='input-group-text'>일</span></div><div></div></td>"
					tbl += "<td><div class='d-grid gap-2 d-md-block'><button type='button' class='btn btn-outline-primary modi-btn me-2'>수정</button>"
					tbl += 		"<button type='button' class='btn btn-outline-primary del-btn'>삭제</button></div></td>"
					tbl += "</tr>"
				});
				$('tbody').append(tbl);
			},
			error: function(error) {
				alert(error);
			}
		})
	}
	
	function addInput() {
		let preNum = $('tr:last').children('td:eq(0)').children('input:eq(0)').val();
		let num = 1;
		if(preNum != undefined )
			num = parseInt(preNum) + 1;
		let tr = "<tr>";
			tr += "<td style='width:60px'><input type='text' class='form-control text-center' name='no' value=" + num + " readonly></td>";
			tr += "<td><input type='text' class='form-control' name='name'></td>";
			tr += "<td><div class='input-group mb-3'><input type='text' class='form-control text-end' name='cost'><span class='input-group-text'>원</span></div><div></div></td>";
			tr += "<td style='width:120px;'><div class='input-group mb-3'><input type='text' class='form-control text-end' name='date'><span class='input-group-text'>일</span></div><div></div></td>";
			tr += "<td><div class='d-grid gap-2 d-md-block'><button type='button' class='btn btn-outline-primary me-2 reg-btn'>등록</button>";
			tr += 		"<button type='button' class='btn btn-outline-primary remove-btn'>제거</button></div></td>";
			tr += "</tr>";
		$('tbody').append(tr);
	}
	
	$(document).on('click','.remove-btn', function(){
		$('.remove-btn').parent().parent().parent('tr:last').remove();
	});
	
	$(document).on('click', '.reg-btn', function(e) {
		let input = $(e.target).parent().parent().parent();
		let fi_no = $(input).children('td:eq(0)').children().val();
		let fi_name = $(input).children('td:eq(1)').children().val();
		let fi_cost = parseInt($(input).children('td:eq(2)').children().children().val());
		let fi_date = $(input).children('td:eq(3)').children().children().val();
		
		console.log
		if(fi_name == "" || fi_cost == "" || fi_date == "") {
			alert("입력 값을 입력해주세요.");
			
			return;
		}
		
		if(!regNumCheck(fi_cost)) {
			alert("가격은 숫자만 입력하세요.");
			return;
		}
		
		if(!regNumCheck(fi_date)) {
			alert("날짜는 숫자만 입력하세요.");
			return;
		}
		
		$.ajax({
			url: 'fixedcost',
			type: 'POST',
			data: {
				no : fi_no,
				name : fi_name,
				cost : fi_cost,
				date : fi_date
			},
			success: function(data) {
				alert("등록 완료");
				getList();
			},
			error : function(error) {
				alert(error);
			}
		});
	});
	
	$(document).on('click', '.modi-btn', function(e) {
		let input = $(e.target).parent().parent().parent();
		let fi_no = $(input).children('td:eq(0)').children().val();
		let fi_name = $(input).children('td:eq(1)').children().val();
		let fi_cost = $(input).children('td:eq(2)').children().children().val();
		let fi_date = $(input).children('td:eq(3)').children().children().val();
		
		if(fi_name == "" || fi_cost == "" || fi_date == "") {
			alert("입력 값을 입력해주세요.");
			
			return;
		}
		
		if(!regNumCheck(fi_cost)) {
			console.log(fi_cost);
			alert("가격은 숫자만 입력하세요.");
			return;
		}
		
		if(!regNumCheck(fi_date)) {
			alert("날짜는 숫자만 입력하세요.");
			return;
		}
		
		let fixedcost = {
				no : fi_no,
				name : fi_name,
				cost : fi_cost,
				date : fi_date 
		};
		 let jobj = JSON.stringify(fixedcost);
		$.ajax({
			url: 'fixedcost',
			type: 'PUT',
			contentType: "application/json",
			data: jobj ,
			success: function(data) {
				alert("수정 완료");
				getList();
			},
			error : function(error) {
				alert(error);
			}
		});
	})
	
	$(document).on('click', '.del-btn', function(e) {
		let input = $(e.target).parent().parent().parent();
		let fi_no = $(input).children('td:eq(0)').children().val();
		
		if(confirm("정말 삭제하시겠습니까?")) {
			$.ajax({
				url: 'fixedcost',
				type: 'DELETE',
				data: fi_no ,
				success: function(data) {
					alert("삭제 완료");
					getList();
				},
				error : function(error) {
					alert(error);
				}
			});
			
		}
	})
	
	function regNumCheck(cost) {
		var regExpCost = /^[0-9]*$/;
		return regExpCost.test(cost);
	}
</script>
<script src="/erp_ver1.2/js/bootstrap.bundle.js" ></script>
</body>
</html>