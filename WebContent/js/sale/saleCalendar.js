console.log('salecalendar load');
//let daySales = $('.fc-event-title-container');
//console.log(daySales);
/*
//날짜 초기화
const date = new Date();
let year = date.getFullYear();
let month = date.getMonth()+1;

//각 날짜의 매출 이벤트 등록
daySales.addEventListener('click', showModal);

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
		url: 'sales',
		type: 'post',
		data: {date: yearMonth},//날짜 정보 전송
		dataType: 'text',
		success: function(res){
			sales.innerText = '이번달 매출 : ' + Number(res).toLocaleString();
		}
	});
}

//다음 버튼 누를시 날짜 변경 및 매출 정보 갱신
function nextSales(){
	//날짜 적용
	month = month+1;
	fixDate();
	let yearMonth = year+'-'+(''+month).padStart(2, "0");
	calendar.next();//다음 달력으로 이동
	
	daySales = $('.fc-event-title-container'); //이벤트 먹일 element 설정
	daySales.click(showModal); //이벤트 등록
	console.log(yearMonth);
	console.log(daySales);
	
	$.ajax({
		url: 'sales',
		type: 'post',
		data: {date: yearMonth},
		dataType: 'text',
		success: function(res){
			sales.innerText = '이번달 매출 : ' + Number(res).toLocaleString();
		}
	});
}

//오늘 날짜  이동 함수
function todaySales(){
	calendar.today(); // 현재 날짜로 이동
	year = date.getFullYear();
	month = date.getMonth()+1;
	sale_value.innerText = MONTHSALES;
}
*/
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
	console.log(`showModal : ${date}`);
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
				'<tr><td>'+ (i+1) +'</td><td><span>' + jo[i].pr_name + '</span></td><td>' 
					+ jo[i].amount + '</td>' + '<td>' + jo[i].sales + '</td><tr>' 
			}
			
			console.log(htmlString);
			prodstat.html(htmlString);
		}
	});
}