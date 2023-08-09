package service.common;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import vo.getDate.BeginEndDate;
import vo.transData.TransInfoDTO;

public class CalcPeriod {
	 
	private BeginEndDate date = new BeginEndDate();
	
	public BeginEndDate getDate(TransInfoDTO info) {
		
		// 타입 별 다른 처리, 시작날짜/마지막날짜 반환
		String unit = info.getDateUnit();

		if (unit.startsWith("fix")) {
			getFixedRangeDates(info);
		}
		else if (unit.equals("calendar")) {
			getCalendarDates(info);
		}else if (unit.equals("free")) {
			getFreeDates(info);
		}
		return date;
	}
	
	
	
	// beginDate : now() 
	// endDate : now() 기준 당일, 전일, 1개월, 3개월 전 날짜 
	private void getFixedRangeDates(TransInfoDTO info) {
		String fixUnit = info.getDateUnit();
		String unit = fixUnit.substring(4);
		Period periodValue = null;

		String dateValueString = info.getDateValue();
		
		// fix 메서드 
		int dateValue = Integer.parseInt(dateValueString);
		if(unit.equals("month")) {
			periodValue = Period.ofMonths(dateValue);
		}else if(unit.equals("day")) {
			periodValue = Period.ofDays(dateValue);
		}
		
		// 마지막 날자
		LocalDate endDate = LocalDate.now();
		// 시작 날짜
		LocalDate beginDate = endDate.minus(periodValue);

		date.setBeginDate(beginDate);
		date.setEndDate(endDate);
		
	}
	
	// beginDate : 달력의 해당 월의 1일 
	// endDate : 달렬의 해당 월의 마지막 일
	private void getCalendarDates(TransInfoDTO info) {
		
		String[] dateArr = info.getDateValue().split(" ");

		int year = Integer.parseInt(dateArr[0]);
		int month = Integer.parseInt(dateArr[1]);
		int day = Integer.parseInt(dateArr[2]);
		
		LocalDate beginDate = LocalDate.of(year, month, 1);
		LocalDate endDate = LocalDate.of(year, month, day);
		System.out.println("beginDate : " + beginDate);
		System.out.println("endDate : " + endDate);
		
		date.setBeginDate(beginDate);
		date.setEndDate(endDate);
		
	}
	private void getFreeDates(TransInfoDTO info) {
		String dateString = info.getDateValue();

		// 문자열을 쉼표(,)를 기준으로 분리
		String[] dateArray = dateString.split(",");

		// 앞의 값을 beginDate 변수에 저장
		LocalDate beginDate = LocalDate.parse(dateArray[0], DateTimeFormatter.ofPattern("yyyy.MM.dd"));

		// 뒤의 값을 endDate 변수에 저장
		LocalDate endDate = LocalDate.parse(dateArray[1], DateTimeFormatter.ofPattern("yyyy.MM.dd"));

		System.out.println("beginDate : " + beginDate);
		System.out.println("endDate : " + endDate);
		
		date.setBeginDate(beginDate);
		date.setEndDate(endDate);
	}
	
}