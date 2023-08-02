package erp_ver1;

import util.DateCheck;

public class Test {

	public static void main(String[] args) {
		
		String date = DateCheck.setDate2(null);
		System.out.println(date);
		
		String date2 = DateCheck.setDate1(null);
		System.out.println(date2);
	}

}
