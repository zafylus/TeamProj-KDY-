<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Date now = new Date();
SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy MM dd [E]");
String formattedDate = sdfDate.format(now);

SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
String formattedTime = sdfTime.format(now);
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/pos.css">
<script src="https://kit.fontawesome.com/f0ec264373.js" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
	<header>
		<div class="title">Green</div>
		<div class="header_bar">  <div class="now_day"><%= formattedDate %></div>
  <div class="now_time"><%= formattedTime %></div></div>
	</header>
	<div class="section">
		<div class="print_section">
			<div class="print_payinfo">
				<div class="payinfo_box">
					<div class="payinfo">*</div>
					<div class="payinfo">메뉴명</div>
					<div class="payinfo">단가</div>
					<div class="payinfo">수량</div>
					<div class="payinfo">할인</div>
					<div class="payinfo">금액</div>
				</div>
				
				<div class="patinfo_result_box">
					<div class="payinfo_result">합 계</div>
					<div class="payinfo_result">1</div>
					<div class="payinfo_result">0</div>
					<div class="payinfo_result">3800</div>
				
				</div>
			</div>
			<div class="print_btnbox">
				<button>전체취소</button>
				<button>선택취소</button>
				<button>할인처리</button>
				<button>수량변경</button>
				<button class="sign"><i class="fa-solid fa-minus fa-xl" style="color: #595959;"></i></button>
				<button class="sign"><i class="fa-solid fa-plus fa-xl" style="color: #595959;"></i></button>
				<button class="sign"><i class="fa-solid fa-angle-up fa-xl" style="color: #595959;"></i></button>
				<button class="sign"><i class="fa-solid fa-angle-down fa-xl" style="color: #595959;"></i></button>
			</div>
			<div class="print_bottom_box">
				<div class="print_result">
					<div class="print_result_title">결제 정보</div>
					<div class="print_result_value">
						<div class="print_result_name">총금액</div><div></div>
						<div class="print_result_name">할인금액</div><div></div>
						<div class="print_result_name yello_color">받을금액</div><div></div>
						<div class="print_result_name">받은금액</div><div></div>
						<div class="print_result_name yello_color">거스름돈</div><div></div>
					</div>
				</div>
				<div class="numpad">
					<div class="row row-1">
						<div class="key display"></div>
					</div>
					<div class="row row-2">
						<div class="key">7</div>
						<div class="key">8</div>
						<div class="key">9</div>
					</div>
					<div class="row row-3">
						<div class="key">4</div>
						<div class="key">5</div>
						<div class="key">6</div>
					</div>
					<div class="row row-4">
						<div class="key">1</div>
						<div class="key">2</div>
						<div class="key">3</div>
					</div>
					<div class="row row-5">
						<div class="key">0</div>
						<div class="key">00</div>
						<div class="key">c</div>
					</div>
					<div class="row row-6">
						<div class="key">&lt;</div>
						<div class="key enter">enter</div>
					</div>
				</div>
			</div>
		</div>

		<div class="menu_section">
			<div class="menu_print_box">
				<div class="menu_print">
					<div class="prod_name" data-code="" data-ctgy=""></div>
					<div class="prod_price"></div>
				</div>
				<div class="menu_print">
					<div class="prod_name" data-code="" data-ctgy=""></div>
					<div class="prod_price"></div>
				</div>
				<div class="menu_print">
					<div class="prod_name" data-code="" data-ctgy=""></div>
					<div class="prod_price"></div>
				</div>
				<div class="menu_print">
					<div class="prod_name" data-code="" data-ctgy=""></div>
					<div class="prod_price"></div>
				</div>
				<div class="menu_print">
					<div class="prod_name" data-code="" data-ctgy=""></div>
					<div class="prod_price"></div>
				</div>
				<div class="menu_print">
					<div class="prod_name" data-code="" data-ctgy=""></div>
					<div class="prod_price"></div>
				</div>
				<div class="menu_print">
					<div class="prod_name" data-code="" data-ctgy=""></div>
					<div class="prod_price"></div>
				</div>
				<div class="menu_print">
					<div class="prod_name" data-code="" data-ctgy=""></div>
					<div class="prod_price"></div>
				</div>
				<div class="menu_print">
					<div class="prod_name" data-code="" data-ctgy=""></div>
					<div class="prod_price"></div>
				</div>
				<div class="menu_print">
					<div class="prod_name" data-code="" data-ctgy=""></div>
					<div class="prod_price"></div>
				</div>
				<div class="menu_print">
					<div class="prod_name" data-code="" data-ctgy=""></div>
					<div class="prod_price"></div>
				</div>
				<div class="menu_print">
					<div class="prod_name" data-code="" data-ctgy=""></div>
					<div class="prod_price"></div>
				</div>
				<div class="menu_print">
					<div class="prod_name" data-code="" data-ctgy=""></div>
					<div class="prod_price"></div>
				</div>
				<div class="menu_print">
					<div class="prod_name" data-code="" data-ctgy=""></div>
					<div class="prod_price"></div>
				</div>
				<div class="menu_print">
					<div class="prod_name" data-code="" data-ctgy=""></div>
					<div class="prod_price"></div>
				</div>
				<div class="menu_print">
					<div class="prod_name" data-code="" data-ctgy=""></div>
					<div class="prod_price"></div>
				</div>
				<div class="menu_print">
					<div class="prod_name" data-code="" data-ctgy=""></div>
					<div class="prod_price"></div>
				</div>
				<div class="menu_print">
					<div class="prod_name" data-code="" data-ctgy=""></div>
					<div class="prod_price"></div>
				</div>
				<div class="menu_print">
					<div class="prod_name" data-code="" data-ctgy=""></div>
					<div class="prod_price"></div>
				</div>
				<div class="menu_print">
					<div class="prod_name" data-code="" data-ctgy=""></div>
					<div class="prod_price"></div>
				</div>
				<div class="menu_print">
					<div class="prod_name" data-code="" data-ctgy=""></div>
					<div class="prod_price"></div>
				</div>
				<div class="menu_print">
					<div class="prod_name" data-code="" data-ctgy=""></div>
					<div class="prod_price"></div>
				</div>
				<div class="menu_print">
					<div class="prod_name" data-code="" data-ctgy=""></div>
					<div class="prod_price"></div>
				</div>
				<div class="menu_print">
					<div class="prod_name" data-code="" data-ctgy=""></div>
					<div class="prod_price"></div>
				</div>
				<div class="menu_print">
					<div class="prod_name" data-code="" data-ctgy=""></div>
					<div class="prod_price"></div>
				</div>
				
			</div>
			<div class="menu_print_box2">
				<div class="payment menu_print2">결제</div>
				<div class="receipt menu_print2">영수증 관리</div>
			</div>
		</div>
		</div>
		</div>
</body>
<script type="text/javascript">
const products = [
    { code: 'pr001', name: '아메리카노', price: 4000, ctgy: '커피' },
    { code: 'pr002', name: '카페라떼', price: 5000, ctgy: '커피' },
    { code: 'pr003', name: '바닐라라떼', price: 6000, ctgy: '커피' },
    { code: 'pr501', name: '디저트', price: 3000, ctgy: '디저트' },
  ];

  window.addEventListener('load', () => {
    const menuPrintElements = document.querySelectorAll('.menu_print');

    for (let i = 0; i < products.length; i++) {
      const product = products[i];
      const menuPrintElement = menuPrintElements[i];

      const prodNameElement = menuPrintElement.querySelector('.prod_name');
      const prodPriceElement = menuPrintElement.querySelector('.prod_price');

      // 데이터 채워넣기
      prodNameElement.textContent = product.name;
      prodPriceElement.textContent = product.price.toLocaleString();
      prodNameElement.dataset.code = product.code;
      prodNameElement.dataset.ctgy = product.ctgy;

      // 스타일 적용
      menuPrintElement.style.boxShadow = '1px 1px 5px 1px #999';
      menuPrintElement.style.backgroundColor = 'rgb(210, 210, 210)';
      menuPrintElement.style.padding = '10px';
    }
  });
	
</script>

</html>