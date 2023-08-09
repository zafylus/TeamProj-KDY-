package util;

import java.time.LocalDate;


public class MakeData {

	public static String setDate2(String date2) {
		if(date2 == null) {
			LocalDate today = LocalDate.now();
			date2 = today.toString();
		}
		return date2;
	}
	
	public static String setDate1(String date1) {
		if(date1 == null) {
			LocalDate today = LocalDate.now();
			LocalDate preDate = today.minusMonths(3);
			date1 = preDate.toString();
		}
		return date1;
	}
	
}
