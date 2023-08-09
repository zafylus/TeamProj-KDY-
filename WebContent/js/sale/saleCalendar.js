let sale

for (var index = 0; index < sides.length; index++) {
	console.log(sides[index]);
	sides[index].addEventListener("click", transData);
};


window.onload = function() {
	fullcalendar();
	transData();

	// 달력의 페이지를 넘기면 서버에 데이터를 보낸다.
	// 변경된 달과 일치하는 데이터를 가져온다. 
	$(".fc-prev-button").click(transData);
	$(".fc-next-button").click(transData);
}




function transData() {

	// unit : calendar
	// value : 해당 월의 마지막 일 
	let [unit, value] = getDate();


	const x = new XMLHttpRequest();
	x.onload = function() {
		let js = this.responseText;
		console.log("js :" + js);
		let jo = JSON.parse(js);
		console.log("jo :" + jo);

		var pageRedirect = jo.pageRedirect;
		if (pageRedirect) {
			window.location.href = pageRedirect;
		}


		// response Map을 받을 준비를 한다.
		let dataMap = new Map();
		dataMap.set("totalSale", jo.totalSale);
		dataMap.set("totalRefund", jo.totalRefund);
		dataMap.set("saleDailyList", jo.saleDailyList);

		// response를 Map에 할당한다. 

		// 월 총 판매금액
		sale = dataMap.get("totalSale");
		// 월 총 환불 금액
		let refund = dataMap.get("totalRefund");

		// 일별 매출
		let saleDailyList = dataMap.get("saleDailyList");

		// 일별 매출을 달력의 날짜 셀에 입력한다.
		for (let i = 0; i < saleDailyList.length; i++) {

			// 일별 매출의 날짜
			let date = saleDailyList[i].date;
			// 해당 일의 매출 
			let dailySale = saleDailyList[i].dailySale;

			// 달력의 div 속성 data-date인 요소를 불러온다.
			// 일별 매출의 날짜와 매칭이 된다면 변수에 할당한다.
			let targetElement = $(`[data-date="${date}"]`);
			console.log(targetElement);

			//매출이 양수면 +, 음수면 - 를  매출 앞에 추가한다. 
			if (targetElement.length > 0) {
				if (dailySale > 0) {
					dailySale = "+" + dailySale.toLocaleString();
				} else if (dailySale < 0) {
					dailySale = "-" + dailySale.toLocaleString();
				}

				// 날짜 셀에 추가할 자식 div(매출)는 absolute다.
				// 부모 셀에 relative를 설정해준다.
				targetElement.css("position", "relative");

				// 매출을 담은 div를 날짜셀의 자식으로 추가한다.
				// div가 존재하면 더 이상 추가하지 않는다.
				if (targetElement.find(".dayValue").length === 0) {
					targetElement.append("<div class='dayValue'>" + dailySale + "</div>");
				}

				// 매출이 담긴 div의 위치와 색을 정한다.
				targetElement.find(".dayValue").css({
					"position": "absolute",
					"right": "5px",
					"bottom": "5px",
					//transform: 'translate(65%, 65%)',
					"color": "black"
				});
			}
		}

		console.log("sale : " + sale);
		console.log("refund :" + refund);
		console.log("saleDailyList : " + saleDailyList);

		//총 매출과 환불 UI에 출력한다.
		$(".sale_value ").text(sale.toLocaleString());
		$(".refund_value ").text(refund.toLocaleString());

	};

	x.open("POST", "../sale", true);
	x.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	x.send("dateUnit=" + unit + "&dateValue=" + value);

}
function getDate() {

	// tool-bar의 문자열
	var date = $(".fc-toolbar-title").text();

	// 문자열에서 년, 월을 추출한다.
	var splitStr = date.split(" ");
	var year = splitStr[0].slice(0, -1);
	var month = splitStr[1].slice(0, -1);

	// 해당 월의 마지막 일을 추출한다.
	var lastDay = new Date(year, month, 0).getDate();

	// servlet으로 보낼 데이터
	unit = "calendar";
	value = year + " " + month + " " + lastDay;

	return [unit, value];
}
