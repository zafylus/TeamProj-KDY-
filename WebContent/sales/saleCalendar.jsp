<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>erp</title>

<link rel="stylesheet" type="text/css" href="/erp_ver1.2/css/saleCalendar.css">
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/index.global.min.js"></script>
	
<script>
	console.log('jsp Script load');
	let MONTHSALES = (${monthTotal}).toLocaleString();
	console.log(MONTHSALES);
	
	//FullCanlendar API
	document.addEventListener('DOMContentLoaded', function() {
	var calendarEl = document.getElementById('calendar');
	var calendar = new FullCalendar.Calendar(calendarEl, {
		initialView: 'dayGridMonth',
		headerToolbar: {
			start: '',
			center: 'prev title next',
			end: 'today',
		},

		// today button text '오늘'로 설정
		buttonText: {
			today: '오늘'
		},
		locale: 'ko',
		events: ${sales}
	});

	calendar.render();


	// fullcalendar 툴바와 달력 사이에 div를 추가한다.
	var toolbar = document.querySelector('.fc-toolbar');
	var newDiv = document.createElement('div');
	newDiv.classList.add('show_sale_box');
	toolbar.parentNode.insertBefore(newDiv, toolbar.nextSibling);

	var childDiv1 = document.createElement('div');
	var childDiv2 = document.createElement('div');
	childDiv1.classList.add('first_box');
	childDiv2.classList.add('second_box');
	newDiv.appendChild(childDiv1);
	newDiv.appendChild(childDiv2);


	var sale_title_box = document.createElement('div');
	var sale_value_box = document.createElement('div');
	var sale_value = document.createElement('div');
	var won1 = document.createElement('span');

	sale_title_box.classList.add('sale_title_box');
	sale_value_box.classList.add('sale_value_box');
	sale_value.classList.add('sale_value');

	childDiv1.appendChild(sale_title_box);
	childDiv1.appendChild(sale_value_box);
	sale_value_box.appendChild(sale_value);
	sale_value_box.appendChild(won1);

	sale_title_box.innerText = "이번 달 실매출";
	sale_value.innerText = MONTHSALES;
	won1.innerText = "원"

	var refund_title_box = document.createElement('div');
	var refund_value_box = document.createElement('div');
	var refund_value = document.createElement('div');
	var won2 = document.createElement('span');

	refund_title_box.classList.add('refund_title_box');
	refund_value_box.classList.add('refund_value_box');
	refund_value.classList.add('refund_value');

	childDiv2.appendChild(refund_title_box);
	childDiv2.appendChild(refund_value_box);
	refund_value_box.appendChild(refund_value);
	refund_value_box.appendChild(won2);

	refund_title_box.innerText = "이번 달 총환불";
	refund_value.innerText = "0"
	won2.innerText = "원"
	
	//버튼 CSS 색상 지정
	//document.querySelectorAll('.fc-icon')[0].style.color = 'black';
	//document.querySelectorAll('.fc-icon')[1].style.color = 'black';
	
	
	//Custom
	
	//Variable
	//요소 변수 지정
    let daySales = $('.fc-event-title-container');
    const dialog = document.querySelector('dialog');
	const daydate = document.getElementById('daydate');
	const prevBtn = $('.fc-prev-button');
	const nextBtn = $('.fc-next-button');
	const todayBtn = $('.fc-today-button');
    //console.log(daySales);
    
    //현재 날짜 변수 지정
    const date = new Date();
    let year = date.getFullYear();
    let month = date.getMonth()+1;
    
    //오늘 매출 초기화
    //todaySales();
    
    //이벤트 등록
    daySales.click(showModal);
	prevBtn.click(prevSales);
	nextBtn.click(nextSales);
	todayBtn.click(todaySales);
	
	
	//Function
	
	//이전 버튼 누를시 날짜 변경 및 매출 정보 갱신
	function prevSales(){
		//날짜 적용
		month = month-1;
		fixDate();
		let yearMonth = year+'-'+(''+month).padStart(2, "0");

		daySales = $('.fc-event-title-container'); //이벤트 먹일 element 설정
		daySales.click(showModal); //이벤트 등록
		console.log(yearMonth);
		console.log(daySales);

		$.ajax({
			url: '../sales',
			type: 'post',
			data: {date: yearMonth},//날짜 정보 전송
			dataType: 'text',
			success: function(res){
				console.log(res);
				sale_value.innerText = Number(res).toLocaleString();
				
			}
		});
	}
	
	//다음 버튼 누를시 날짜 변경 및 매출 정보 갱신
	function nextSales(){
		//날짜 적용
		month = month+1;
		fixDate();
		let yearMonth = year+'-'+(''+month).padStart(2, "0");
		
		daySales = $('.fc-event-title-container'); //이벤트 먹일 element 설정
		daySales.click(showModal); //이벤트 등록
		console.log(yearMonth);
		console.log(daySales);
		
		$.ajax({
			url: '../sales',
			type: 'post',
			data: {date: yearMonth},
			dataType: 'text',
			success: function(res){
				console.log(res);
				sale_value.innerText = Number(res).toLocaleString();
			}
		});
	}

	//오늘 날짜  이동 함수
	function todaySales(){
		year = date.getFullYear();
		month = date.getMonth()+1;
		sale_value.innerText = MONTHSALES;
		
		daySales = $('.fc-event-title-container'); //이벤트 먹일 element 설정
		daySales.click(showModal); //이벤트 등록
		console.log(yearMonth);
		console.log(daySales);
	}
	
	//일자별 매출 정보 함수
	function showModal(e){
		let jq_et = null;
		
		if(e.target.className == 'fc-event-title fc-sticky'){
			jq_et = $(e.target).parent();
		}else{
			jq_et = $(e.target);
		}
		console.log(jq_et);
		
		//부모에게서 이벤트가 일어난 날짜 획득
		let date = jq_et.parent().parent().parent().parent().parent().parent().parent()[0].dataset.date;
		console.log(date);
		dialog.showModal();

		$.ajax({
			url: 'eachProdSales?date='+date,
			type: 'get',
			dataType: 'text',
			success: function(res){
				const jo = JSON.parse(res);
				console.log(jo);
				const prodstat = $('#prodstat');//dialog(Modal) tbody id : prodstat
				let htmlString = '';
				
				for (let i = 0; i < jo.length; i++) {
					htmlString += 
					'<tr><th scope="row">'+ (i+1) +
						'</td><td><span>' + 
							jo[i].pr_name + '</span></td><td>' 
						+ jo[i].amount + '</td>' + 
						'<td>' + jo[i].sales + '</td><tr>' 
				}
				
				console.log(htmlString);
				daydate.innerHTML = '<h3>'+ date + '</h3>';
				prodstat.html(htmlString);
			}
		});
	}
	
	//날짜 수정
	function fixDate(){
		if (month > 12 ) {
			month = 1;
			year+=1;
		}
		if (month < 1 ) {
			month = 12;
			year-=1;
		}
	}
});
</script>
<!--<script src="../js/library/fullCalendar.js"></script>-->
</head>

<body>
	<dialog>
		<div id="daydate"></div>
        <h2>매출순위</h2>
        <table class="table table-striped">
            <thead>
                <tr class="table-secondary">
                    <th>순위</th>
                    <th>제품</th>
                    <th>판매량</th>
                    <th>총매출</th>
                </tr>
            </thead>
            <tbody id="prodstat">
            </tbody>
        </table>
        <form method="dialog">
            <button class="floatRight">Close</button>
        </form>
    </dialog>
	<div class="container">
		<section id="calendar"></section>
	</div>
<script src="js/bootstrap.bundle.js" ></script>
</body>
</html>