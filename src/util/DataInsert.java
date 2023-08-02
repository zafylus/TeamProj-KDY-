package util;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataInsert {
	
	public static void main(String[] args) {
		
		//List<SalesVO> sa = dataList(30);
	//	System.out.println(sa.size());
	}
	
	// 랜덤 메뉴 정하기(이름)
	// 확률 : 50% 아메리카노 30% 카페라떼 20% 바닐라라떼
	public static String randomMenuStr() {
		double x = (Math.random());
		String menu = "";
		if(x < 0.5) {
			menu = "Americano";
		} else if (x < 0.8) {
			menu = "Cafe latte";
		} else {
			menu = "Vanilla latte";
		}
		return menu;
	}
	
	// 메뉴 입력 시 가격 반환(String)
	public static int priceMenuStr(String menu) {
		int price = 0;
		if(menu.equalsIgnoreCase("Americano")) {
			price = 1500;
		} else if(menu.equalsIgnoreCase("Cafe latte")) {
			price = 2900;
		} else if(menu.equalsIgnoreCase("Vanilla latte")) {
			price = 3300;
		}
		return price;
	}
	
	// 랜덤 메뉴 정하기(제품번호)
	// 1:아메리카노  2:카페라떼  3:바닐라라떼
	// 확률 : 50% 아메리카노 30% 카페라떼 20% 바닐라라떼
	public static int randomMenuInt() {
		double x = (Math.random());
		int menu = 0;
		if(x < 0.5) {
			menu = 1;
		} else if (x < 0.8) {
			menu = 2;
		} else {
			menu = 3;
		}
		return menu;
	}
	
	// 메뉴 입력 시 가격 반환(int)
	public static int priceMenuInt(int menu) {
		int price = 0;
		if(menu == 1) {
			price = 1500;
		} else if(menu == 2) {
			price = 2900;
		} else if(menu == 3) {
			price = 3300;
		}
		return price;
	}
	
	// 랜덤 갯수 정하기
	// 1~10사이의 수 랜덤
	public static int randomEa() {
		int ea = (int)(Math.random()*10)+1;
		return ea;
	}
	
	// 상품번호 반환
	public static int returnPno(String name) {
		int result = 0;
		if(name.equalsIgnoreCase("Americano")) {
			return result = 1;
		} else if(name.equalsIgnoreCase("Cafe latte")) {
			return result = 2;
		} else if(name.equalsIgnoreCase("Vanilla latte")) {
			return result = 3;
		}
		return result;
	}
	
	// 랜덤 매출 객체 만들기
	// 날짜, 회원 제외
//	public static SalesVO randomSalesVO() {
//		String menu = randomMenuStr();
//		int ea = randomEa();
//		int price = ea * priceMenuStr(menu);
//		int pno = returnPno(menu);
//		SalesVO s = new SalesVO();
//		s.setPno(pno);
//		s.setP_name(menu);
//		s.setEa(ea);
//		s.setPrice(price);
//		return s;
//	}
	
	// 랜덤 날짜 만들기
	public static LocalDate randomDate(int month) {
		int d = (int)(Math.random()*28)+1;
		String date = "2023-" + zeroMonth(month) + "-" + zeroMonth(d);
		LocalDate randomDate = LocalDate.parse(date);

		return randomDate;
	}
	
	// 달을 매개변수로 받아
	// 10보다 작으면 앞에 0을 붙이고 아니면 그대로 반환(String)
	public static String zeroMonth(int month) {
		String mon = "";
		if(month < 10) {
			mon = "0" + month;
		} else {
			mon += month; 
		}
		return mon;
	}
	
	// 정수값을 매개변수로 받아
	// 정수값만큼의 하루 판매량으로 계산 1년치 판매 리스트 반환
//	public static ArrayList<SalesVO> dataList(int dailySales) {
//		ArrayList<SalesVO> sList = new ArrayList<>();
//		for (int i = 1; i < 13; i++) {
//			for (int j = 0; j < dailySales; j++) {
//				SalesVO s = randomSalesVO();
//				s.setDate(Date.valueOf(randomDate(i)));
//				sList.add(s);
//			}
//		}
//		return sList;
//	}
}
