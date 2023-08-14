<%@page import="java.time.LocalDate"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	LocalDate now2 = LocalDate.now();
String nowDate = now2.format(java.time.format.DateTimeFormatter.ofPattern("yyyy.MM.dd"));
%>
<%
	Date now = new Date();
SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy.MM.dd [E]");
String formattedDate = sdfDate.format(now);
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/erp_ver1.2/css/datepicker.css">
<link rel="stylesheet" href="/erp_ver1.2/css/receipt.css">
<script src="https://kit.fontawesome.com/f0ec264373.js"
	crossorigin="anonymous"></script>
</head>

<body>
	<div class="container">
		<header>
			<div class="header_bar">
				<div class="title">영수증 관리</div>
				<div class="now_day"><%=formattedDate%></div>
				<div class="now_time"></div>
			</div>
		</header>
		<div class="section">
			<div class="print_section_box">
				<div class="print_section_header">영수증</div>
				<div class="print_section_content">
					<div class="print_section">

						<div class="flex_box">
							<div class="flex_box2">
								<div class="type">[판매]</div>
								<div class="date_time">${receiptSales.odrDate}</div>
							</div>
							<div class="flex_box2">
								<div class="order_num_title">주문 번호:</div>
								<div class="order_num_value"></div>
							</div>
						</div>
						<div class="line">-------------------------------------------------------------------------------------</div>
						<div class="print_list_container">
							<div class="print_list_box">
								<div class="print_list">상품코드</div>
								<div class="print_list">단가</div>
								<div class="print_list">수량</div>
								<div class="print_list">금액</div>
							</div>

						</div>
						<div class="line">-------------------------------------------------------------------------------------</div>
						<div class="print_price_container">
							<div class="print_price_box">
								<div>부가세 과세 물품가액</div>
								<div class="print_cost"></div>
							</div>
							<div class="print_price_box">
								<div>상품가격에 이미 포함된 부가세</div>
								<div class="print_vat"></div>
							</div>
							<div class="print_price_box2">
								<div>합</div>
								<div>계</div>
								<div class="print_total_price"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="list_section_box">
				<div class="list_print_setting">
					<div>시작일</div>
					<div>
						<input class="datepicker date_input date_start"
							value="<%=nowDate%>">
					</div>
					<div>마지막일</div>
					<div>
						<input class="datepicker date_input date_last"
							value="<%=nowDate%>">
					</div>
					<div>매출 구분</div>
					<div class="radio-container">
						<input type="radio" id="all" name="content-type" checked>
						<label for="radio-all" class="radio-label">전체</label> <input
							type="radio" id="sale" name="content-type"> <label
							for="radio-sale" class="radio-label">판매</label> <input
							type="radio" id="return" name="content-type"> <label
							for="radio-return" class="radio-label">반품</label>
					</div>
					<div>판매금액</div>
					<div>
						<div class="input_price_box">
							<input type="text" class="input_price low_price"> ~ <input
								type="text" class="input_price high_price">
						</div>
					</div>
					<div>영수증 번호</div>
					<div>
						<input type="text" class="input_receipt_num">
					</div>
				</div>
				<div class="receipt_list_container">
					<div class="receipt_list_box blue">
						<div class="receipt_list">일자</div>
						<div class="receipt_list">영수증</div>
						<div class="receipt_list">시간</div>
						<div class="receipt_list">금액</div>
						<div class="receipt_list">거래구분</div>
					</div>
					<c:forEach var="receiptSales" items="${rslist}">
						<c:set var="odrCode" value="${receiptSales.odrCode}" />
						<c:set var="odrDate" value="${receiptSales.odrDate}" />
						<c:set var="dateTimeParts" value="${fn:split(odrDate, ' ')}" />
						<c:set var="datePart" value="${dateTimeParts[0].substring(5)}" />
						<c:set var="timePart" value="${dateTimeParts[1]}" />
						<c:set var="timeParts" value="${fn:split(timePart, ':')}" />
						<c:set var="hour" value="${timeParts[0]}" />
						<c:set var="minute" value="${timeParts[1]}" />
						<c:set var="time" value="${hour}:${minute}" />
						<c:set var="type"
							value="${receiptSales.totalSales >= 0 ? '판매' : '환불'}" />

						<div class="receipt_list_box" data-no="${odrCode}"
							data-date="${receiptSales.odrDate}">
							<div class="receipt_list datePart">${datePart}</div>
							<div class="receipt_list">${receiptSales.odrCode}</div>
							<div class="receipt_list time">${time}</div>
							<div class="receipt_list">
								<fmt:formatNumber value="${receiptSales.totalSales}"
									pattern="###,###" />
							</div>
							<div class="receipt_list">${type}</div>
						</div>
					</c:forEach>
				</div>
				<div class="btn_box">
					<div class="check">조회</div>
					<div class="refund">환불</div>
				</div>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">
	//시간을 업데이트하는 함수
	function updateClock() {
		const currentTimeElement = document.querySelector(".now_time");
		const now = new Date();
		const hours = String(now.getHours()).padStart(2, '0'); // 두 자리로 표시하고 한 자리 수일 경우 앞에 0 추가
		const minutes = String(now.getMinutes()).padStart(2, '0');
		const timeString = hours + ':' + minutes;
		currentTimeElement.textContent = timeString;
	}

	// 1초마다 시간 업데이트
	setInterval(updateClock, 1000);
</script>

<script src="/erp/js/common/jquery-3.7.0.js"></script>
<script src="/erp/js/library/datepicker.js"></script>
<script src="/erp/js/library/datepicker.ko-KR.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".datepicker").datepicker({
			format : 'yyyy.mm.dd',
			language : 'ko-KR',
			autoHide : true
		});
	});
</script>

<script type="text/javascript">
	var receiptList = document.querySelectorAll(".receipt_list_box");
	var dateTimeBox = document.querySelector(".date_time");
	var orderNum = document.querySelector(".order_num_value");
	var totalPrice = document.querySelector(".print_total_price");
	var vat = document.querySelector(".print_vat");
	var cost = document.querySelector(".print_cost");
	var printContent = document.querySelector(".print_section");

	//각 요소에 클릭 이벤트를 추가합니다.
	receiptList.forEach(function(item) {
		item.addEventListener("click", function() {
			var printListContainer = document
					.querySelector(".print_list_container");
			printContent.style.display = 'block';

			while (printListContainer.firstChild) {
				printListContainer.removeChild(printListContainer.firstChild);
			}

			var date = item.getAttribute("data-date").slice(0, -3);
			dateTimeBox.textContent = date;
			var dataNoValue = item.getAttribute("data-no");
			orderNum.textContent = dataNoValue;
			var total_price = 0;

			setTimeout(function() {
				var xhr = new XMLHttpRequest();
				xhr.open("GET", "receiptData?dataNo=" + dataNoValue, true);
				xhr.onreadystatechange = function() {
					if (xhr.readyState === 4 && xhr.status === 200) {
						var rilist = JSON.parse(xhr.response);
						for (var i = 0; i < rilist.length; i++) {
							var receiptItem = rilist[i];
							var prName = receiptItem.prName;
							var prNo = receiptItem.prNo;
							var prPrice = receiptItem.prPrice;
							var amount = receiptItem.amount;

							var printListBox2 = document.createElement("div");
							printListBox2.className = "print_list_box";
							printListContainer.appendChild(printListBox2);

							var prNameDiv = document.createElement("div");
							prNameDiv.className = "print_list";
							if ((i + 1) > 9) {
								prNameDiv.textContent = "0" + (i + 1) + " "
										+ prName;
							} else if ((i + 1) < 10) {
								prNameDiv.textContent = "00" + (i + 1) + " "
										+ prName;
							}
							printListBox2.appendChild(prNameDiv);

							var printListBox = document.createElement("div");
							printListBox.className = "print_list_box";
							printListContainer.appendChild(printListBox);

							var prNoDiv = document.createElement("div");
							prNoDiv.className = "print_list";
							prNoDiv.textContent = prNo;
							printListBox.appendChild(prNoDiv);

							var prPriceDiv = document.createElement("div");
							prPriceDiv.className = "print_list";
							prPriceDiv.textContent = prPrice;
							printListBox.appendChild(prPriceDiv);

							var amountDiv = document.createElement("div");
							amountDiv.className = "print_list";
							amountDiv.textContent = amount;
							printListBox.appendChild(amountDiv);

							var amountDiv = document.createElement("div");
							amountDiv.className = "print_list";
							amountDiv.textContent = (prPrice * amount)
									.toLocaleString();
							printListBox.appendChild(amountDiv);
							total_price += (prPrice * amount);
						}
						totalPrice.textContent = total_price.toLocaleString();
						vat.textContent = "("
								+ (total_price * 0.15).toLocaleString() + ")";
						cost.textContent = (total_price * 0.85)
								.toLocaleString();
						total_price = 0;
					}

				};
				xhr.send();
			}, 150);
		});
	});
</script>
<script type="text/javascript">
	var refund = document.querySelector(".refund");
	refund.addEventListener("click", function() {
		var orderNum = document.querySelector(".order_num_value");
		var orderNumValue = orderNum.textContent;

		var xhr = new XMLHttpRequest();
		xhr.open("POST", "receiptData", true);
		xhr.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");

		xhr.onreadystatechange = function() {
			if (xhr.readyState === 4 && xhr.status === 200) {
				// AJAX 요청이 완료된 경우의 처리
				var response = xhr.responseText;
				console.log(response); // 서버 응답 출력
				location.reload();
			}
		};

		var requestData = "orderNum=" + orderNumValue;
		xhr.send(requestData); // 데이터 전송
	});
</script>
<script type="text/javascript">
var check = document.querySelector(".check");
check.addEventListener("click", function() {
    var date_start = document.querySelector(".date_start").value;
    var date_last = document.querySelector(".date_last").value;
    var selectedRadioButton = document.querySelector('input[name="content-type"]:checked').id;
    var low_price = document.querySelector(".low_price").value;
    var high_price = document.querySelector(".high_price").value;
    var receipt_num = document.querySelector(".input_receipt_num").value;
    alert(date_start);

    // 데이터를 객체로 만들기
	var requestData = {
	    date_start: date_start,
	    date_last: date_last,
	    content_type: selectedRadioButton
	};
	
	if (low_price !== "") {
	    requestData.low_price = low_price;
	}
	
	if (high_price !== "") {
	    requestData.high_price = high_price;
	}
	
	if (receipt_num !== "") {
	    requestData.receipt_num = receipt_num;
	}

    // 데이터 객체를 쿼리 스트링으로 변환
    var queryParams = Object.keys(requestData).map(key => {
        return encodeURIComponent(key) + '=' + encodeURIComponent(requestData[key]);
    }).join('&');

    // GET 요청을 보낼 URL
    var requestURL = "receiptData?" + queryParams;
	alert(requestURL);
    // Ajax GET 요청 보내기
    var xhr = new XMLHttpRequest();
    xhr.open("GET", requestURL, true);

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var response = xhr.responseText;
            console.log(response); // 서버 응답 출력
            // 여기서 받은 데이터를 처리하는 로직을 추가하세요.
        }
    };

    xhr.send();
});
</script>
</html>