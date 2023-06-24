<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>erp</title>
<link rel="stylesheet" type="text/css" href="css/erp.css?a">
<link rel="stylesheet" type="text/css" href="css/saleCalendar.css">
  <script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/index.global.min.js'></script>
    <script>
    
    
    
    

      document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
          initialView: 'dayGridMonth',
          headerToolbar: {
              start: '',
              center: 'prev title next',
              end: 'today',
            },
            buttonText: {
            	today:    '오늘'
            },
            locale: 'ko'
            
        });
        calendar.render();
        
        calendar.setOption('dayCellContent', function(arg) {
            return arg.date.getDate();
          });
        
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
        sale_value.innerText = "0"
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
        
        
      //var toolbar = document.querySelector('.fc-header-toolbar');
      //var title = document.querySelector('.fc-toolbar-title');
     // var today = document.querySelector('.fc-today-button');
      //var prev = document.querySelector('.fc-prev-button');
      //var next = document.querySelector('.fc-next-button');
      
      //var title_box = document.createElement('div');
     // title_box.classList.add('title_box');
      
      //title.parentNode.insertBefore(prev, title);
      //toolbar.parentNode.insertBefore(next, title.nextSibling);
     // prev.parentNode.insertBefore(title_box, prev.nextSibling);
      //title_box.appendChild(title);
      
      
      });
      
      
      
    </script>

</head>
<body>
	<c:import url="importPage/header.jsp" />
	<c:import url="importPage/nav.jsp" />
	<div class="container">
		<c:import url="importPage/side.jsp" />
		<section id="calendar">
		</section>
	</div>

	<script type="text/javascript">
	

	
	
	
	
		let navs = document.querySelectorAll(".nav");
		let sides = document.querySelectorAll(".side_btn");
		let sub = document.querySelector(".sub_box");

		// nav css
		for (var index = 0; index < navs.length; index++) {
			navs[index].addEventListener("focus", focus_nav);
			navs[index].addEventListener("blur", blur_nav);

		};

		//nav -> sub 메뉴 css
		navs[0].addEventListener("focus", sub_on);
		navs[0].addEventListener("blur", function() {
			  setTimeout(sub_off, 90);
			});

		//side css 
		for (var index = 0; index < sides.length; index++) {
			sides[index].addEventListener("focus", focus_side);
			sides[index].addEventListener("blur", blur_side);
		};

		// nav
		function focus_nav(e) {
			let target = e.target;
			target.style.color = "#1c8dff";
			target.style.borderBottom = "3px solid  #1c8dff";
			target.removeEventListener("mouseout", blur);
		}

		function blur_nav(e) {
			let target = e.target;
			target.style.color = "#4e4e4e";
			target.style.borderBottom = "none";
		}

		// sub
		function sub_on() {
			sub.style.display = "flex";
		}
		function sub_off() {
			sub.style.display = "none";
		}

		// side
		function focus_side(e) {
			let target = e.target;
			target.style.color = "#1c8dff";
			target.style.background = "#e6e6ff";
		}
		function blur_side(e) {
			let target = e.target;
			target.style.color = "#4e4e4e";
			target.style.background = "white";
		}
		
		
		
	</script>
</body>
</html>