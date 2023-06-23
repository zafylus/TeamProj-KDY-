<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/index.global.min.js'></script>

<link rel="stylesheet" type="text/css" href="ui2.css">
</head>
<body>
	<div class="container">
		<header>
			<div class="title">지출</div>
			<div class="big_btn">
				<button>매출</button>
				<button>지출</button>
				<button>재고</button>
			</div>
		</header>
		<div class="date_select_box">
			<div>
				기 간 <input type="date" class="date"> 부터 <input type="date"
					class="date"> 까지
				<button class="btn1 btn_size1">당월</button>
				<button class="btn1 btn_size1">전월</button>
			</div>

		</div>
		<div class="select_box">
			<button class="btn1 btn_size2" name="month" value="m">지출</button>
			<button class="btn1 btn_size2" name="day" value="d">고정비</button>
			<button class="btn1 btn_size2" name="menu">매입</button>
		</div>
	</div>
	

		<div class="section"></div>

	
	<script>
		let month = document.querySelector('button[name="month"]');
		let day = document.querySelector('button[name="day"]');
		let menu = document.querySelector('button[name="menu"]');
		let result = document.querySelector('.section');

		month.addEventListener("click", loadDoc);
		day.addEventListener("click", loadDoc);
		menu.addEventListener("click", loadDoc);

		function loadDoc(e) {
	        let value = e.target.value;
	        const xhttp = new XMLHttpRequest();
	        var table = result.querySelector("table");
	        
	        
	        // 이미 테이블이 있는지 확인합니다.
	        
	        // 이미 테이블이 있는 경우, 함수를 종료합니다.
	        if (table) {
	          table.remove();
	        }

	        xhttp.onload = function() {
	            let js = this.responseText;
	            let ro = JSON.parse(js);
	            var jarr = ro.data;

	            let table = document.createElement("table");
	            table.classList.add("table");
	            table.style.border = "1px solid black";
	            table.style.width = "80%";
	            table.style.textAlign="center";
	            table.style.marginTop = "50px";
	            // 테이블 헤더 행 생성
	            let headerRow = document.createElement("tr");
	            headerRow.style.backgroundColor = "orange";
	            let keys = Object.keys(jarr[0]);
	            for (let i = 0; i < keys.length; i++) {
	                let th = document.createElement("th");
	                th.textContent = keys[i];
	                headerRow.appendChild(th);
	            }
	            table.appendChild(headerRow);

	            // 데이터와 함께 테이블 행 생성
	            for (let i = 0; i < jarr.length; i++) {
	                let tto = jarr[i];
	                let values = Object.values(tto);

	                let row = document.createElement("tr");
	                for (let j = 0; j < values.length; j++) {
	                    let td = document.createElement("td");
	                    td.textContent = values[j];
	                    row.appendChild(td);
	                }
	                table.appendChild(row);
	            }
	                

	            // 테이블을 결과 요소에 추가
	            result.appendChild(table);
	        }
		xhttp.open("POST", "/ex00/erp2", true);
		xhttp.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		xhttp.send("value=" + value);}
	</script>
</body>
</html>