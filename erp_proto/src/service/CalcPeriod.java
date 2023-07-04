package service;

import java.time.LocalDate;
import java.time.Period;

import vo.PeriodVO;

public class CalcPeriod {

	public PeriodVO getPeriod(String unit, int term) {
		PeriodVO betweenPeriod = new PeriodVO();
		Period period = null;

		if (unit.equals("day")) {
			period = Period.ofDays(term);
		} else if (unit.equals("month")) {
			period = Period.ofMonths(term);
		}
		LocalDate now = LocalDate.now();
		LocalDate endDay = now.minus(period);

		betweenPeriod.setBeginPeriod(now);
		betweenPeriod.setEndPeriod(endDay);

		return betweenPeriod;
	}
}
