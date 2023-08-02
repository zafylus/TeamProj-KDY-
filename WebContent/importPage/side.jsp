<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="side_box">

<!-- 
	query에 사용할 beginDate endDate 를 계산하는데 이용할 속성이다.
	dateUnit : service에서 unit와 일치하는 메서드를 호출한다.(조건).
	dateValue : service에서 계산에 필요한 값 -->
	
	<button class="side_btn" >등록</button>
	<button class="side_btn" data-dateUnit="fix_day" data-dateValue="0">당일</button>
	<button class="side_btn" data-dateUnit="fix_day" data-dateValue="1">전 일</button>
	<button class="side_btn" data-dateUnit="fix_month" data-dateValue="1">전 달</button>
	<button class="side_btn" data-dateUnit="fix_month" data-dateValue="3">3개월</button>
	<button class="side_btn">기간 선택</button>
</div>