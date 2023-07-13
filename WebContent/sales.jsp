<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="org.json.JSONArray"%>
<%@page import="dto.SalesByDateDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.SalesDAO"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ERP Project</title>
    <script src="js/jquery-3.7.0.js"></script>
    <script src="js/index.global.js"></script>
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            var calendarEl = document.getElementById('calendar');
            var calendar = new FullCalendar.Calendar(calendarEl, {
                headerToolbar: {
                    left: '',
                    center: 'title',
                    end: ''
                },
                height: '100%',
                width: '70%',
                aspectRatio: 0.1,
                contentHeight: '100%',
                locale: 'ko',
                events: ${sales},//session에서 매출 배열 적용
            });
            calendar.render();
            //FullCalendar 적용 부분
            
            
            //새로 추가된 부분
            const sales = document.getElementById('sales');
            let daySales = $('.fc-event-title-container');
            const dialog = document.querySelector('dialog');
            //console.log(daySales);
            
            //날짜 초기화
            const date = new Date();
            let year = date.getFullYear();
            let month = date.getMonth()+1;
            
            //오늘 매출 초기화
            todaySales();
            
            document.getElementById('prev').addEventListener('click', prevSales);
            document.getElementById('next').addEventListener('click', nextSales);
            document.getElementById('today').addEventListener('click', todaySales);
            
            //각 날짜의 매출 이벤트 등록
            daySales.click(showModal);
           
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
                calendar.prev(); //다음 달력으로 이동

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
                const monthTotaltoLocal = (${monthTotal}).toLocaleString();
                sales.innerText = '이번달 매출 : ' + monthTotaltoLocal;
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
        });
    </script>
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
    <dialog>
        <h2>매출순위</h2>
        <table>
            <thead>
                <tr>
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
            <button>Close</button>
        </form>
    </dialog>
    <div id = "wrapper">
        <div id="header">
            <h1>ERP</h1> 
        </div>
        <div id="nav">
            <h2>
                 <a class="menu" href="sales">매출</a> 
                <a class="menu">지출</a>
                <a class="menu">재고</a>
                <a class="menu">직원</a>
                <a class="menu" href="index.html">홈으로</a>
            </h2>
        </div>
        <div id="sidebar">
            <div class = "dtlmenu">조 회</div>
        </div>
        <div id="section">
            
            <div>
                <span id="sales">이번달 매출 : </span>
                <span id="button">
                   <button id="prev"><</button> 
                   <button id="today">today</button>
                   <button id="next">></button> 
                </span>
            </div>
            
       	     <div class="calendar_box" style="width:1150px; height:850px;">
            <div id="calendar"></div>
            </div>
            
        </div>
    </div>
</body>
</html>