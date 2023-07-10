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
                    height: 'auto',
                    left: 'title',
                    center: '',
                    end: ''
                },
                locale: 'ko',
                events: ${sales},
            });
            calendar.render();
            
            const sales = document.getElementById('sales');
            const daySales = $('.fc-event-title-container');
            const dialog = document.querySelector('dialog');
            console.log(daySales);
            const date = new Date();
            let year = date.getFullYear();
            let month = date.getMonth()+1;
            
            todaySales();
            document.getElementById('prev').addEventListener('click', prevSales);
            document.getElementById('next').addEventListener('click', nextSales);
            document.getElementById('today').addEventListener('click', todaySales);
            daySales.click(showModal);
           

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
            
            function prevSales(){
                month = month-1;
                fixDate();
                let yearMonth = year+'-'+(''+month).padStart(2, "0");
                console.log(yearMonth);
                calendar.prev();
            
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
            
            function nextSales(){
                month = month+1;
                fixDate();
                let yearMonth = year+'-'+(''+month).padStart(2, "0");
                console.log(yearMonth);
                calendar.next();
            
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

            function todaySales(){
                calendar.today();
                year = date.getFullYear();
                month = date.getMonth()+1;
                const monthTotaltoLocal = (${monthTotal}).toLocaleString();
                console.log(monthTotaltoLocal);
                sales.innerText = '이번달 매출 : ' + monthTotaltoLocal;
            }

            function showModal(e){
                let jq_et = null;
                if(e.target.className == 'fc-event-title fc-sticky'){
                    jq_et = $(e.target).parent();
                }else{
                    jq_et = $(e.target);
                }
                console.log('jq_et');
                console.log(jq_et);
                console.log(jq_et.parent().parent().parent().parent().parent().parent().parent()[0].dataset.date);
                dialog.showModal();
            }
            
            
        })
    </script>
   
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
    <dialog>
        Hello Modal
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
                <a href="sales">매출</a> 
                <a href="">지출</a>
                <a href="">재고</a>
                <a href="">직원</a>
                <a href="index.html">홈으로</a>
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
            <div id="calendar"></div>
        </div>
    </div>
</body>
</html>