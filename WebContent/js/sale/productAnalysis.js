// 사이드 바를 클릭하면 DB에서 데이터를 가져온다.	
for (var index = 0; index < sides.length - 1; index++) {
	console.log(sides[index]);
	sides[index].addEventListener("click", transData);
};

document.addEventListener("DOMContentLoaded", transData);
// 서버에 정보를 보내 데이터를 받아온다.
// 받은 데이터를 UI에 출력한다.
function transData(e) {

	let unit;
	let value;
	let free_btn = $(".side_btn:contains('기간 선택')");

	if (e) {
		unit = $(this).attr("data-dateUnit");
		value = $(this).attr("data-dateValue");
	} else {
		unit = free_btn.attr("data-dateUnit");
		value = free_btn.data("dateValue");
	}

	if (unit === undefined) {
		unit = "fix_month";
		value = "1";
	}


	// xhd
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


		let dataMap = new Map();
		// response를 받을 준비를 한다.
		dataMap.set("totalProductSale", jo.totalProductSale);
		dataMap.set("allProductList", jo.allProductList);
		dataMap.set("topList", jo.topList);

		// response를 Map에 추가한다.
		let allProductList = dataMap.get("allProductList");
		let topList = dataMap.get("topList");


		$(".apexcharts-canvas").remove();
		if (allProductList.length === 0) {
			$("#chart").css("display", "none");
			$(".product_showlist").children().each(function() {
				$(this).css("display", "none");
			});

			$(".product_showlist").append("<span class='null_response_msg'>아직 매출이 없어요...</span>");
			let null_msg = $(".null_response_msg");
			null_msg.css({
				position: "absolute",
				top: "45%",
				left: "50%",
				transform: "translate(-50%, -50%)",
				fontSize: "22px",
				fontWeight: "700",
				color: "black"
			});
			return;
		}
		$(".null_response_msg").remove();

		// display: none을 해제한다.
		$(".product_showlist").children().each(function() {
			$(this).css("display", "block");
		});
		$(".top1").css("display", "block");
		$(".topOrder").css("display", "flex");
		$("#chart").css("display", "block");

		// color 값을 주기 위해 span으로 값을 담는다.
		// 원래는 text로 바로 넣을 생각이었음
		// 출력 예시) -  32건 
		let totalCnt = dataMap.get("totalProductSale");
		console.log("totalCnt : " + totalCnt);
		let spanTotalCnt = document.createElement("span");
		spanTotalCnt.textContent = totalCnt + "건";

		// 동일한 이유다.
		let spanPrdCnt = document.createElement("span");
		spanPrdCnt.textContent = topList[0].saleCnt + "건";


		// 이동 및 css를 균일하게 주기 위해 한 문장을 함께 담는다.
		// 위에서 제작한 span 함께 넣어 준다.
		$(".total_cnt").empty().append("총 ", spanTotalCnt, "의 주문수 중 ", spanPrdCnt, " 주문");

		console.log("allProductList :" + allProductList);
		console.log("topList :" + topList);
		// 1등 데이터의 상품명과 판매금액을 할당한다.
		$(".pr_top1").text(topList[0].prName);
		$(".pr_pay").text(topList[0].pay.toLocaleString() + "원");

		// 2, 3 등을 처리하는 구간
		// append를 사용하기 때문에 계속 추가될 수 있다.
		// 존재하는 값을 제거하고 재할당한다.
		$(".top_value").empty();

		// 검색된 div는 2개고, topList는 3개다.
		// div index 0 ,1과 topList index 1, 2를 매칭한다.
		$(".top_value").each(function(index, item) {
			if(!topList[index + 1]){
				$(".top_value").eq(index).css("display", "none");
			}else{
		    $(".top_value").eq(index).css("display", "grid");
			$(item).append($("<div>").text(index + 2));
			$(item).append($("<div>").text(topList[index + 1].prName));
			$(item).append($("<div>").text(topList[index + 1].saleCnt));
			$(item).append($("<div>").text(topList[index + 1].pay.toLocaleString() + "원"));

			// 등수와 상품명 div에 padding을 준다.
			// 1등 데이터와 수직을 맞춘다
			$(item).find("div:nth-child(1), div:nth-child(2)").css("padding-right", "40px");
			$(item).find("div:nth-child(2)").css({
				"text-align": "left",
				"width": "120px"
			});
			$(item).find("div:nth-child(4)").css("padding-left", "10px");
			}
		});

		// 차트 호출하는 구간
		// 차트가 이미 있다면 호출하지 않는다.
		if ($(".apexcharts-canvas").length === 0) {
			callChart(allProductList);
		}

	};

	x.open("POST", "../sale", true);
	x.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	x.send("dateUnit=" + unit + "&dateValue=" + value);


}


function callChart(allProductList) {

	$("#chart").css({
		"width": "500px",
		"height": "500px",
		"min-height": "500px",
		"margin-top": "50px;"

	});

	var options = {
		chart: {
			type: 'donut'
		},
		series: [],
		labels: [],
		plotOptions: {
			pie: {
				// 크기 조절 
				customScale: 1.0,
			}
		}
	};

	// 차트에 쓸 값과 이름을 할당한다.
	allProductList.forEach(function(item) {
		options.labels.push(item.prName);
		options.series.push(item.saleCnt);
	});

	console.log("label : " + options.labels);
	console.log("series : " + options.series);

	var chart = new ApexCharts(document.querySelector("#chart"), options);

	chart.render();

}
