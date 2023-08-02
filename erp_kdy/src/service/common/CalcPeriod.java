package service.common;

import java.time.LocalDate;
import java.time.Period;

import vo.getDate.DateBeginEnd;
import vo.transData.TransInfoVO;

public class CalcPeriod {

	// DB query에 입력할 beginDate, endDate 얻기 
	private DateBeginEnd dateForDB = new DateBeginEnd();
	
	public DateBeginEnd getDate(TransInfoVO info) {
		
		String unit = info.getDateUnit();

		if (unit.startsWith("fix")) 
			getFixedRangeDates(info);
		else if (unit.equals("calendar")) 
			getCalendarDates(info);
		else if (unit.equals("free")) 
			System.out.println("작업 예정");
		
		return dateForDB;
	}
	
	
	
	// beginDate : now() 
	// endDate : now() 기준 당일, 전일, 1개월, 3개월 전 날짜 
	private void getFixedRangeDates(TransInfoVO info) {
		String fixUnit = info.getDateUnit();
		String unit = fixUnit.substring(4);
		Period periodValue = null;

		String dateValueString = info.getDateValue();
		
		int dateValue = Integer.parseInt(dateValueString);
		if(unit.equals("month")) {
			periodValue = Period.ofMonths(dateValue);
		}else if(unit.equals("day")) {
			periodValue = Period.ofDays(dateValue);
		}
		
		LocalDate now = LocalDate.now();
		LocalDate endDay = now.minus(periodValue);

		dateForDB.setBeginDate(endDay);
		dateForDB.setEndDate(now);
	}
	
	// beginDate : 달력의 해당 월의 1일 
	// endDate : 달렬의 해당 월의 마지막 일
	private void getCalendarDates(TransInfoVO info) {
		
		String[] dateArr = info.getDateValue().split(" ");

		int year = Integer.parseInt(dateArr[0]);
		int month = Integer.parseInt(dateArr[1]);
		int day = Integer.parseInt(dateArr[2]);
		
		LocalDate beginDate = LocalDate.of(year, month, 1);
		LocalDate endDate = LocalDate.of(year, month, day);
		System.out.println("beginDate : " + beginDate);
		System.out.println("endDate : " + endDate);
		
		dateForDB.setBeginDate(beginDate);
		dateForDB.setEndDate(endDate);
		
	}
	
}