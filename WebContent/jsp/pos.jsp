<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Date now = new Date();
SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy.MM.dd [E]");
String formattedDate = sdfDate.format(now);

%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/erp_ver1.2/css/pos.css">
<script src="https://kit.fontawesome.com/f0ec264373.js"
	crossorigin="anonymous"></script>
</head>

<body>

	<div class="container">
		<header>
			<div class="title">Green</div>
			<div class="header_bar">
				<div class="now_day"><%=formattedDate%></div>
				<div class="now_time"></div>
			</div>
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
						<div class="payinfo_result"></div>
						<div class="payinfo_result"></div>
						<div class="payinfo_result"></div>

					</div>
				</div>
				<div class="print_btnbox">
					<button class="cancel_all_button">전체취소</button>
					<button class="cancel_button">선택취소</button>
					<button>할인처리</button>
					<button class="ea_input">수량변경</button>
					<button class="ea_plus sign">
						<i class="fa-solid fa-plus fa-xl" style="color: #595959;"></i>
					</button>
					<button class="ea_minus sign">
						<i class="fa-solid fa-minus fa-xl" style="color: #595959;"></i>
					</button>
					<button class="sign up">
						<i class="fa-solid fa-angle-up fa-xl" style="color: #595959;"></i>
					</button>
					<button class="sign down">
						<i class="fa-solid fa-angle-down fa-xl" style="color: #595959;"></i>
					</button>
				</div>
				<div class="print_bottom_box">
					<div class="print_result">
						<div class="print_result_title">결제 정보</div>
						<div class="print_result_value">
							<div class="print_result_name">총금액</div>
							<div></div>
							<div class="print_result_name">할인금액</div>
							<div></div>
							<div class="print_result_name yello_color">받을금액</div>
							<div></div>
							<div class="print_result_name">받은금액</div>
							<div></div>
							<div class="print_result_name yello_color">거스름돈</div>
							<div></div>
						</div>
					</div>
					<div class="numpad">
						<div class="row row-1">
							<div class=" display"></div>
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
					<div class="menu_print2">ERP</div>
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

 <script>
 		// numpad 실행 js
 		// display key값 추가
        const display = document.querySelector('.display');
        function addToDisplay(text) {
            display.textContent += text;
        }
		// display 비우는 매서드 
        function clearDisplay() {
            display.textContent = '';
        }
		// display의 마지막 text를 뺀 전체 text를 재할당
        function removeLastChar() {
            display.textContent = display.textContent.slice(0, -1);
        }
		
        const keys = document.querySelectorAll('.key');
        keys.forEach(key => {
            key.addEventListener('click', () => {
                const text = key.textContent;
                if (text === 'c') {
                    clearDisplay();
                } else if (text === '<') {
                    removeLastChar();
                // enter시 display 비우기
                // printResult에 '받은 금액', '나머지' 출력하기
                } else if (text === 'enter') {
                	const printResult = document.querySelectorAll('.print_result_value div');
                	if (printResult[5].textContent) {
                        printResult[7].textContent = display.textContent.toLocaleString();
                        const value7 = parseFloat(printResult[7].textContent.replace(/,/g, ''));
                        const value5 = parseFloat(printResult[5].textContent.replace(/,/g, ''));
                        if((value7 - value5) >= 0){
	                        printResult[9].textContent = (value7 - value5).toLocaleString();
                        }
                	}
                	clearDisplay();
                // 앞의 버튼들에 해당되지 않으면 += text 
                } else {
                    addToDisplay(text);
                }
            });
        });
    </script>
<script type="text/javascript">
  const products = ${plist};
  console.log(products);
/*
[
    { code: 'pr001', name: '아메리카노', price: 4000, ctgy: '커피' },
    { code: 'pr002', name: '카페라떼', price: 5000, ctgy: '커피' },
    { code: 'pr003', name: '바닐라라떼', price: 6000, ctgy: '커피' },
    { code: 'pr501', name: '디저트', price: 3000, ctgy: '디저트' },
  ];*/

  window.addEventListener('load', () => {
    const menuPrint = document.querySelectorAll('.menu_print');
    // click된 payinfo_box (숫자/메뉴명/단가/수량/확인/할인/금액)
    let selectedPayinfoBox = null;
    // payinfo_box들을 구분하는 숫자,  1로 초기화
    let payinfoCount = 1;
    
    // 총 개수와 금액을  '결제 정보', '합계'에 표시
    const updateTotals = () => {
        const payinfoBoxes = document.querySelectorAll('.payinfo_selector');
        let totalEa = 0;
        let totalPrice = 0;

        payinfoBoxes.forEach((payinfoBox) => {
          const eaElement = payinfoBox.querySelector('.ea');
          const priceElement = payinfoBox.querySelectorAll('.payinfo')[5];
			
          if (eaElement && priceElement) {
            const ea = parseInt(eaElement.textContent);
            const price = parseInt(priceElement.textContent.replace(/,/g, ''));
            totalEa += ea;
            totalPrice += price;
          }
        });

        // payinfo_result 업데이트
        const payinfoResult = document.querySelectorAll('.payinfo_result');
        payinfoResult[1].textContent = totalEa;
        payinfoResult[3].textContent = totalPrice.toLocaleString();

        // print_result_value 업데이트
        const printResult = document.querySelectorAll('.print_result_value div');
        printResult[1].textContent = totalPrice.toLocaleString();
        printResult[3].textContent = '0';
        printResult[5].textContent = totalPrice.toLocaleString();
        printResult[7].textContent = '0';
        printResult[9].textContent = '0';
      };
    
      // 전체 취소 버튼, payinfoBox 모두 제거
      //'결제 정보', '합계'에 입력된 값을 제거
      // 자주 쓰임
      const removePayinfoBoxes = () => {
    	  const printResult = document.querySelectorAll('.print_result_value div');
          const payinfoResult = document.querySelectorAll('.payinfo_result');
    	  const payinfoBoxes = document.querySelectorAll('.payinfo_selector');
    	  payinfoBoxes.forEach((payinfoBox) => {
    	    payinfoBox.remove();
    	  });
    	  printResult[1].textContent = "";
          printResult[3].textContent = "";
          printResult[5].textContent = "";
          printResult[7].textContent = "";
          printResult[9].textContent = "";
          
          payinfoResult[1].textContent = "";
          payinfoResult[2].textContent = "";
          payinfoResult[3].textContent = "";
    	  payinfoCount = 1; // payinfoCount 초기화
    	};
    	
    	// "전체취소" 버튼에 이벤트 리스너 연결
        const cancelAllButton = document.querySelector('.cancel_all_button');
        cancelAllButton.addEventListener('click', removePayinfoBoxes);

    // 서버에서 받은 메뉴 products
    // menuprint 인덱스와 products 인덱스를 매칭시켜서 값 할당
    for (let i = 0; i < products.length; i++) {
      const product = products[i];
      const menuPrintElement = menuPrint[i];

      const prodNameElement = menuPrintElement.querySelector('.prod_name');
      const prodPriceElement = menuPrintElement.querySelector('.prod_price');

      // 데이터 채워넣기
      prodNameElement.textContent = product.pr_name;
      prodPriceElement.textContent = product.pr_price.toLocaleString();
      prodNameElement.dataset.code = product.pr_code;
      prodNameElement.dataset.ctgy = product.pr_ctgry;

      // 스타일 적용
      menuPrintElement.style.boxShadow = '1px 1px 5px 1px #999';
      menuPrintElement.style.backgroundColor = 'rgb(210, 210, 210)';
      menuPrintElement.style.padding = '10px';
      
     
      // menu 클릭시 payinfo_box 동적으로 생성하여 화면에 출력
      // 생성할 때 payinfo_box에 필요한 이벤트 추가
      menuPrintElement.addEventListener('click', () => {
          const payinfoBox = document.createElement('div');
          payinfoBox.classList.add('payinfo_box', 'payinfo_selector'); // payinfo_box 클래스만 추가
          payinfoBox.dataset.code = prodNameElement.dataset.code;
          payinfoBox.dataset.ctgy = prodNameElement.dataset.ctgy;
          payinfoBox.style.backgroundColor = '#e6e6e6'; // 배경색 설정
          payinfoBox.style.color = 'black'; // 텍스트 색상 검정색으로 설정
          
          
          // payinfoBox 클릭 시 backColor 파랑색
          payinfoBox.addEventListener('click', () => {
              // 기존에 선택된 payinfo_box와 현재 선택된 payinfo_box가 다른 경우에만 처리
              if (selectedPayinfoBox !== payinfoBox) {
                if (selectedPayinfoBox !== null) {
                  // 이전에 선택된 payinfo_box의 스타일을 원래대로 복원
                  selectedPayinfoBox.style.backgroundColor = '#e6e6e6';
                  selectedPayinfoBox.style.color = 'black';
                }

                // 현재 선택된 payinfo_box를 selectedPayinfoBox 변수에 저장
                selectedPayinfoBox = payinfoBox;

                // 선택된 payinfo_box의 스타일 변경
                payinfoBox.style.backgroundColor = 'blue';
                payinfoBox.style.color = 'white';
              }
            });

          const payinfo1 = document.createElement('div');
          payinfo1.classList.add('payinfo');
          payinfo1.textContent = payinfoCount;

          const payinfo2 = document.createElement('div');
          payinfo2.classList.add('payinfo');
          payinfo2.textContent = prodNameElement.textContent;

          const payinfo3 = document.createElement('div');
          payinfo3.classList.add('payinfo');
          payinfo3.textContent = prodPriceElement.textContent;

          const payinfo4 = document.createElement('div');
          payinfo4.classList.add('payinfo', 'ea');
          payinfo4.textContent = '1';

          const payinfo5 = document.createElement('div');
          payinfo5.classList.add('payinfo');
          payinfo5.textContent = '0';

          const payinfo6 = document.createElement('div');
          payinfo6.classList.add('payinfo');
          payinfo6.textContent = (prodPriceElement.textContent);

          // payinfoBox에 생성한 요소들 추가
          payinfoBox.appendChild(payinfo1);
          payinfoBox.appendChild(payinfo2);
          payinfoBox.appendChild(payinfo3);
          payinfoBox.appendChild(payinfo4);
          payinfoBox.appendChild(payinfo5);
          payinfoBox.appendChild(payinfo6);

          // payinfo_box와 patinfo_result_box 사이에 새로운 div를 추가
          const patinfoResultBox = document.querySelector('.patinfo_result_box');
          patinfoResultBox.insertAdjacentElement('beforebegin', payinfoBox);

          // payinfoCount 값 1 증가
          payinfoCount++;
          
          // '결제 정보', '합계'에 값 할당
          updateTotals();
        });
      
      // 선택 취소 event
      const cancelButton = document.querySelector('.cancel_button');
      cancelButton.addEventListener('click', () => {
        if (selectedPayinfoBox !== null) {
        	
          // payinfo_box의 구분 숫자 초기화
          // selectedPayinfoBox = 클릭한 payinfo_box
          // selectedPayinfoBox 삭제 후, selectedPayinfoBox = null로 초기화
	      let payinfoCount = 1;
          selectedPayinfoBox.remove();
          selectedPayinfoBox = null;
          
          // payinfo_selector = payinfo_box의 table_header를 제외한 나머지 
          const payinfoSelectors = document.querySelectorAll('.payinfo_selector');
			
          // 삭제 후 맞지 않는 구분 숫자를 재정비한다. 
          // payinfo_box 숫자 만큼 재할당, 
          payinfoSelectors.forEach((payinfoSelector) => {
            const firstChild = payinfoSelector.firstElementChild;
            if (firstChild) {
              firstChild.textContent = payinfoCount;
              payinfoCount++;
            }
          });
          
          // 삭제 후 총금액에 맞게 입력값 모두 수정
          updateTotals();
          
          if (payinfoSelectors.length === 0){
        	  removePayinfoBoxes();
          }
        	
        	
        }
      });
      
      
    }
    
    // 개수 + 1 코드
    const eaPlusButton = document.querySelector('.ea_plus');
    eaPlusButton.addEventListener('click', () => {
      if (selectedPayinfoBox !== null) {
        const ea = selectedPayinfoBox.querySelector('.ea');
        if (ea) {
          const current = parseInt(ea.textContent);
          ea.textContent = (current + 1).toString();
          const payinfo3 = selectedPayinfoBox.querySelectorAll('.payinfo')[2];
          const payinfo6 = selectedPayinfoBox.querySelectorAll('.payinfo')[5];
          const price = parseInt(payinfo3.textContent.replace(/,/g, ''));
          const result = (current + 1) * price;
          payinfo6.textContent = result.toLocaleString();
          updateTotals();
        }
      }
    });
    
    // 개수 -1 코드
    const eaMinusButton = document.querySelector('.ea_minus');
    eaMinusButton.addEventListener('click', () => {
      if (selectedPayinfoBox !== null) {
        const ea = selectedPayinfoBox.querySelector('.ea');
        if (ea) {
        	 const current = parseInt(ea.textContent);
             const payinfo3 = selectedPayinfoBox.querySelectorAll('.payinfo')[2];
             const payinfo6 = selectedPayinfoBox.querySelectorAll('.payinfo')[5];
             if(ea.textContent!=="1"){
            	 
             ea.textContent = (current - 1).toString();
             const price = parseInt(payinfo3.textContent.replace(/,/g, ''));
             const result = (current - 1) * price;
             payinfo6.textContent = result.toLocaleString();
             updateTotals();
             }
          }
        }
    });
    
    // !! 결제 코드 !! 
    // ajax로 값 전송 
    // 전송 예시 -> jsonData[{"code":"pr001","ea":"1"}]
    const paymentButton = document.querySelector('.payment');
    paymentButton.addEventListener('click', () => {
     
      const printResult = document.querySelectorAll('.print_result_value div');
      const payinfoResult = document.querySelectorAll('.payinfo_result');
      // '결제 정보'의 '받을 금액'
      const totalAmount = printResult[5].textContent;
      const confirmationMessage = "총 금액 " + totalAmount + " 입니다. 결제 하시겠습니까?";

      if (confirm(confirmationMessage)) {
    	  // payinfo_selector = payinfo_box의 table_header를 제외한 나머지 
    	  // payinfo_box(숫자 메뉴명 단가 수량 할인 금액)
    	  const payinfoBoxes = document.querySelectorAll('.payinfo_selector');
    	  
    	  // 전송할 객체 배열
    	  const requestData = [];
    	  
    	  // 모든 payinfo_box의 각 요송에 접근 code와 ea 값을 얻은 후 
    	  // requestData에 push
    	  payinfoBoxes.forEach((payinfoBox) => {
    	    const code = payinfoBox.dataset.code;
    	    const ea = payinfoBox.querySelector('.ea').textContent;
    	    requestData.push({ 
    	    	  code: code, 
    	    	  ea: ea 
    	    	});
    	    
    	  });

    	  // AJAX 요청 보내기
    	  const xhr = new XMLHttpRequest();
    	  // xhr.onload = function() {
    		// // 형식상 응답 구현 
    	  //   let js = this.responseText;
    	  //   const responseObj = JSON.parse(js);

    	  // };
    	  // Ajax 설정 파트
    	  xhr.open('POST', 'pos', true);
    	  xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.onload = function(){
          let res = this.responseText;
          console.log(res);
        };
        xhr.send(JSON.stringify(requestData));
    	  // 전송 후 payinfo_box 모두 삭제 
    	  // '결제 정보', '합계' 값 비우기
          removePayinfoBoxes();
        alert("결제가 완료되었습니다. 감사합니다!");
      }
    });
    
    // 수량 변경, ∧ ,∨ 이벤트 파트
    const buttons = document.querySelectorAll('.print_btnbox button');

    buttons.forEach((button) => {
      button.addEventListener('click', () => {
        const payinfoBoxes = document.querySelectorAll('.payinfo_selector');
        
        // 모든 payinfo_box 중 현재 클릭된 payinfo_box의 인덱스 값을 구한다. 
        const currentIndex = Array.from(payinfoBoxes).indexOf(selectedPayinfoBox);
        
        // ∧ 이벤트 
        if (button.classList.contains('up')) {
          if (currentIndex > 0) {
        	  
        	// 현재 클릭된 payinfo_box의 인덱스에 -1을 해서
        	// 한칸 위의 payinfo_box를 구한다.
            selectedPayinfoBox = payinfoBoxes[currentIndex - 1];
            // 선택된 payinfoBox의 스타일 변경
            selectedPayinfoBox.style.backgroundColor = 'blue';
            selectedPayinfoBox.style.color = 'white';

            if (selectedPayinfoBox !== null && selectedPayinfoBox !== payinfoBoxes[currentIndex]) {
              // 이전에 선택된 payinfoBox의 스타일을 원래대로 복원
              payinfoBoxes[currentIndex].style.backgroundColor = '#e6e6e6';
              payinfoBoxes[currentIndex].style.color = 'black';
            }
          }
          // 현재 클릭된 payinfo_box의 인덱스에 + 1을 해서
      	  // 한칸 아래의 payinfo_box를 구한다.
        } else if (button.classList.contains('down')) {
          // 인덱스의 마지막 payinfo_box가 아니라면 실행
          if (currentIndex < payinfoBoxes.length - 1) {
            selectedPayinfoBox = payinfoBoxes[currentIndex + 1];
            // 선택된 payinfoBox의 스타일 변경
            selectedPayinfoBox.style.backgroundColor = 'blue';
            selectedPayinfoBox.style.color = 'white';

            if (selectedPayinfoBox !== null && selectedPayinfoBox !== payinfoBoxes[currentIndex]) {
              // 이전에 선택된 payinfoBox의 스타일을 원래대로 복원
              payinfoBoxes[currentIndex].style.backgroundColor = '#e6e6e6';
              payinfoBoxes[currentIndex].style.color = 'black';
            }
          }
        }else if (button.classList.contains('ea_input')) {
            // 수량변경 클릭 시
            const userInput = prompt('수량을 입력하세요.'); // 입력값 받기

            if (userInput !== null) {
              const inputEa = parseInt(userInput); // 입력값을 숫자로 변환

              // 입력값이 숫자인지 확인
              if (!isNaN(inputEa)) {
            	// 선택된 payinfoBox의 '.ea' 요소
                const eaElement = selectedPayinfoBox.querySelector('.ea'); 
                eaElement.textContent = inputEa; // 입력값을 '.ea' 요소의 textContent로 설정
                // payinfo3 = 단가
                const payinfo3 = selectedPayinfoBox.querySelectorAll('.payinfo')[2];
                // payinfo6 = 총 금액(단가 * 개수)
                const payinfo6 = selectedPayinfoBox.querySelectorAll('.payinfo')[5];
                const price = parseInt(payinfo3.textContent.replace(/,/g, ''));
                const result = inputEa * price;
                payinfo6.textContent = result.toLocaleString();
                // 변경된 총 금액 반영
                updateTotals();
              }
            }
          }

      });
    });
    
  });
	
  
</script>

</html>