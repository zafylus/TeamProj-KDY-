 $(document).ready(function () {
	  $(".datepicker").datepicker({
	      format: 'yyyy.mm.dd',
	      language: 'ko-KR',
	      autoHide: true
	    });
	  });
    // 모달 열기
    var modal = document.getElementById("myModal");
    var modal_btn = $(".side_btn:contains('기간 선택')"); // 모달 열기 버튼 선택자
    var select_btn = document.querySelector(".select_btn");
    

	modal_btn.on("click", showModal);
    // 모달 닫기
    var close = document.getElementsByClassName("close")[0];

    close.onclick = function () {
      modal.style.display = "none";
    };
    
    select_btn.onclick = function () {
	  modal.style.display = "none";
	  var begin_date = $(".begin_date").val();
	  var end_date = $(".end_date").val();
	  // 데이터 값을 합친 문자열 생성
	  var dateValue = begin_date + "," + end_date;
	  // modal_btn의 data-dateValue 속성에 값 설정
	  modal_btn.data("dateValue", dateValue);
	  transData(); 
};

	function showModal() {
  		modal.style.display = "block";
	}
