 function fullcalendar() {
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
	
	
		});
	
		calendar.render();

 	
	// fullcalendar 툴바와 달력 사이에 div를 추가한다.
	// jsp를 실행하고 개발자 모드에서 보는 것을 추천합니다. 
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
        
   	}    
      
