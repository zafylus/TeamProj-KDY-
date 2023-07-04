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
    <script src="js/index.global.js"></script>
    <script>
        var jarray;
      	document.addEventListener('DOMContentLoaded', function() {

        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
          locale: 'ko',
          events: ${sales}
        });
        calendar.render();
      });
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
            <div id="calendar"></div>
        </div>
    </div>
    <script>
    	const sales = document.getElementById('sales');
        
    	sales.innerText = `이번달 매출 : ${monthTotal}`;

        const date = new Date();
        const year = date.getFullYear();
        const month = date.getMonth()+1;
        let nowMonth = document.getElementById('fc-dom-1');
        alert(nowMonth);
        if (month > 12 ) {
            month = 1;
            year+=1;
        }
        if (month < 1 ) {
            month = 12;
            year-=1;
        }

        document.querySelector('.fc-prev-button').addEventListener('click', prevSales);

        function prevSales(){
            month -= 1;
            let yearMonth = year+'-'+month;
            console.log(yearMonth);
            const xhttp = new XMLHttpRequest();
            xhttp.onload = function(){
            let monthSale = this.responseText;
            }
            xhttp.open('GET', 'sales?month='+yearMonth, true);
            xhttp.send();
        }
    </script>
    <script src="js/calSales.js"></script>
</body>
</html>