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
                locale: 'ko',
                events: ${sales}
        });
        calendar.render();
       
        const sales = document.getElementById('sales');
        const date = new Date();
        let year = date.getFullYear();
        let month = date.getMonth()+1;
        
        sales.innerText = `이번달 매출 : ${monthTotal}`;
        document.getElementById('prev').addEventListener('click', prevSales);
        document.getElementById('next').addEventListener('click', nextSales);

        function prevTest(){
            calendar.prev();
            console.log('test');
        }

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
                    sales.innerText = '이번달 매출 :' + res;
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
                    sales.innerText = '이번달 매출 :' + res;
                }
            });
        }
    })
    </script>
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
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
            <div id="sales">이번달 매출 : </div>
            <div id="button">
               <button id="prev"><</button> 
               <button id="next">></button> 
            </div>
            <div id="calendar"></div>
        </div>
    </div>
    <script>
        
    </script>
    <!--<script src="js/calSales.js"></script>-->
</body>
</html>