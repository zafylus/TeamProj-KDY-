package service;

import java.time.LocalDate;
import java.time.Period;

import vo.DateBeginEnd;
import vo.PeriodVO;

public class CalcPeriod {

	public DateBeginEnd getPeriod(PeriodVO period) {
		DateBeginEnd betweenPeriod = new DateBeginEnd();
		Period transTerm = null;
		
		String unit = period.getUnit();
		String termString = period.getTerm();
		int term = Integer.parseInt(termString);

		if (unit.equals("day")) {
			transTerm = Period.ofDays(term);
		} else if (unit.equals("month")) {
			transTerm = Period.ofMonths(term);
		}
		
		LocalDate now = LocalDate.now();
		LocalDate endDay = now.minus(transTerm);

		betweenPeriod.setBeginPeriod(endDay);
		betweenPeriod.setEndPeriod(now);

		return betweenPeriod;
	}
	
}