	
	for (var index = 0; index < sides.length; index++) {
		console.log(sides[index]);
		sides[index].addEventListener("click", transData);
	};


	function transData(e) {
		let unit = $(e.target).attr("data-dateUnit");
		let value = $(e.target).attr("data-dateValue");
		
		
	
	
		const x = new XMLHttpRequest();
		x.onload = function() {
			let js = this.responseText;
			console.log("js :" + js);
			let jo = JSON.parse(js);
			console.log("jo :" + jo);
	
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
	  			$(item).text(sale[index]);
			});
			refundSpan.each(function(index, item) {
	  			$(item).text(refund[index]);
			});
	
			
	
		};
	
		x.open("POST", "../sale", true);
		x.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		x.send("dateUnit=" + unit + "&dateValue=" + value);
}
