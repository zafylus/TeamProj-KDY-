	
	for (var index = 0; index < sides.length; index++) {
		console.log(sides[index]);
		sides[index].addEventListener("click", transData);
	};


	function transData(e) {
		let unit = e.target.getAttribute("data-unit"); // 데이터 속성 값 가져오기
		let term = e.target.getAttribute("data-term");
	
	
		const x = new XMLHttpRequest();
		x.onload = function() {
			let js = this.responseText;
			let jo = JSON.parse(js);
			console.log("jo :" + jo);
	
			let dataMap = new Map();
			// dataMap에 값을 추가
			dataMap.set("totalProductSale", jo.totalSale);
			dataMap.set("ctgyOrderList", jo.ctgyOrderList);
			dataMap.set("topList", jo.topList);
	
	
	
			let ctgyOrderList = dataMap.get("ctgyOrderList");
			let topList = dataMap.get("topList");
	
			
	
			$(".top1").css("display","block");
			$("top_value").css("display", "grid");
			
			let totalCnt = dataMap.get("totalSale");
			let spanTotalCnt = document.createElement("span");
			spanTotalCnt.textContent = totalCnt + "건";
	
			let spanPrdCnt = document.createElement("span");
			spanPrdCnt.textContent = topList[0].saleCnt + "건";
	
	
			$(".total_cnt").empty().append("총 ", spanTotalCnt, "의 주문수 중 ", spanPrdCnt, " 주문");
	
			console.log("ctgyOrderList :" + ctgyOrderList);
			console.log("topList :" + topList);
			$(".pr_top1").text(topList[0].prName);
			$(".pr_pay").text(topList[0].pay + "원");
	
			$(".top_value").empty();
			$(".top_value").each(function(index, item) {
				$(item).append($("<div>").text(index + 2));
				$(item).append($("<div>").text(topList[index + 1].prName));
				$(item).append($("<div>").text(topList[index + 1].saleCnt));
				$(item).append($("<div>").text(topList[index + 1].pay + "원"));
	
				$(item).find("div:nth-child(1), div:nth-child(2)").css("padding-right", "40px");
			});
		};
	
		x.open("POST", "../sale", true);
		x.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		x.send("unit=" + unit + "&term=" + term);
}
