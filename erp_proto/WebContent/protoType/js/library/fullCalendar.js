 function fullcalendar() {
		var calendarEl = document.getElementById('calendar');
		var calendar = new FullCalendar.Calendar(calendarEl, {
			initialView: 'dayGridMonth',
			headerToolbar: {
				start: '',
				center: 'prev title next',
				end: 'today',
			},

			buttonText: {
				today: '오늘'
			},
			locale: 'ko',
 		dayCellDidMount: function (arg) {
  		var cellDate = arg.date.getDate(); // 날짜 셀의 날짜 가져오기

  // 가져온 날짜에 원하는 값을 설정
  		var value = cellDate; // 날짜 값을 원하는 값으로 설정

  // 날짜 셀 내부에 값을 넣을 HTML 요소 생성
  		var valueElement = document.createElement('div');
  		valueElement.classList.add('custom-value');
 	 	valueElement.textContent = value;
  		valueElement.style.position = 'absolute';
  		valueElement.style.right = '10px';
  		valueElement.style.bottom = '5px'; // 날짜 셀 내부의 하단으로

  // 날짜 셀 내부에 값을 추가
	}
	
	
		});
	
		calendar.render();

 	
	
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
      
