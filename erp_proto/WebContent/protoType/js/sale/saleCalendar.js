	let sale
	
	for (var index = 0; index < sides.length; index++) {
		console.log(sides[index]);
		sides[index].addEventListener("click", transData);
	};
	window.onload = function() {
		fullcalendar();
		transData();
	}

	function transData(e) {
		//let unit = e.target.getAttribute("data-unit"); // 데이터 속성 값 가져오기
		//let term = e.target.getAttribute("data-term");
		
		let unit;
		let term;
		
		if (!e) {
    	[unit, term] = getDate();  // getDate 함수 실행
  		}else{
			unit = $(e.target).data('unit');
			term = $(e.target).data('term');
		}
	
	
		

		alert(unit);
		const x = new XMLHttpRequest();
		x.onload = function() {
			let js = this.responseText;
			let jo = JSON.parse(js);
			console.log("jo :" + jo);
	
			let dataMap = new Map();
			dataMap.set("totalSale", jo.totalSale);
			dataMap.set("totalRefund", jo.totalRefund);
			dataMap.set("saleDailyList", jo.saleDailyList);
			
			sale = dataMap.get("totalSale");
			let refund = dataMap.get("totalRefund");
			let saleDailyList = dataMap.get("saleDailyList");
			
			console.log(sale);
			console.log(refund);
			console.log(saleDailyList);
			
			$(".sale_value ").text(sale);
			$(".fc-daygrid-day-events:eq(3)").text(sale);
			$(".fc-daygrid-day-events:eq(3)").addClass("dayValue");
			$(".dayValue").css({
  				"position": "absolute",
  				"right": "10px",
 				"bottom": "5px"
			
			
			
			});
			$(".fc-prev-button").click(getDate);
			$(".fc-next-button").click(getDate);
		
		};
	
		x.open("POST", "../sale", true);
		x.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		x.send("unit=" + unit + "&term=" + term);
		
		
}
	function getDate() {
			
    		var date = $(".fc-toolbar-title").text();
    		var splitStr = date.split(" ");
    		var year = splitStr[0].slice(0, -1);
    		var month = splitStr[1].slice(0, -1);
    		var lastDay = new Date(year, month, 0).getDate();

    		console.log("Year2: " + year);
    		console.log("Month2: " + month);
    		console.log("lastDay: " + lastDay);
			
			unit = "calendar";
			term = year+ " " + month + " " + lastDay;
			
			return [unit, term];
  		}
