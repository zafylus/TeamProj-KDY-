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
    <%
	    LocalDate now = LocalDate.now();
		String yearMon = now.toString().substring(0,7);
    
        SalesDAO sd = new SalesDAO();
    	int monthSales = sd.monthSales(yearMon);
		request.setAttribute("monthSales", monthSales);    	
    	
        ArrayList<SalesByDateDTO> slist = sd.selectAll();
        JSONArray jarray = new JSONArray(slist);
    	System.out.print(jarray);
    	pageContext.setAttribute("jarray", jarray);
    %>
    <script src="js/index.global.js"></script>
    <script>
      document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
          locale: 'ko',
          events: ${jarray}
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
                <a href="sales.jsp">매출</a> 
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
    	sales.innerText = '이번달 매출 : '+${monthSales};
    </script>
    <script src="js/calSales.js"></script>
</body>
</html>