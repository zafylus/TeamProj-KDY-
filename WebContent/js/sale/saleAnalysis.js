let sides = document.querySelectorAll(".side_btn");

for (var index = 0; index < sides.length - 1; index++) {
	sides[index].addEventListener("click", transData);
};

document.addEventListener("DOMContentLoaded", transData);

// 매출 part 요청과 응답을 담당하는 함수
function transData(e) {
	
	let unit;
	let value;
	let free_btn = $(".side_btn:contains('기간 선택')");

	// 정상 실행 -> fix 버튼 값 획득
	// null -> free 버튼 값 획득
	if (e) {
		unit = $(this).attr("data-dateUnit");
		value = $(this).attr("data-dateValue");
	} else {
		// 기간 선택 시 transDate() 매개변수 없이 실행
		unit = free_btn.attr("data-dateUnit");
		value = free_btn.data("dateValue");
	}


	if (unit === undefined) {
		unit = "fix_month";
		value = "1";
	}


	fetch("/erp_ver1.2/saleTransData", {
		method: "POST",
		headers: {
			"Content-type": "application/x-www-form-urlencoded"
		},
		body: "dateUnit=" + unit + "&dateValue=" + value + "&page=saleAnalysis"
	})
		.then(response => response.json())
		.then(jo => {
			console.log("jo :", jo);
			var pageRedirect = jo.pageRedirect;
			if (pageRedirect) {
				window.location.href = pageRedirect;
			}

			let dataMap = new Map();
			dataMap.set("saleList", jo.saleList);
			dataMap.set("refundList", jo.refundList);

			let sale = dataMap.get("saleList");
			let refund = dataMap.get("refundList");

			console.log(sale);
			console.log(refund);

			let saleSpan = $(".sale").find("span");
			let refundSpan = $(".refund").find("span");

			saleSpan.each(function(index, item) {
				if (index == 1) {
					$(item).text(sale[index]);
				} else {

					$(item).text(sale[index].toLocaleString());
				}
			});
			refundSpan.each(function(index, item) {
				if (index == 1) {
					$(item).text(refund[index]);
				} else {
					$(item).text(refund[index].toLocaleString());
				}
			});
		})
		.catch(error => {
			console.log(error);
		});
}
