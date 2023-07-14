package services;

import java.time.LocalDate;
import java.util.ArrayList;

import org.json.JSONArray;

import dao.SalesDAO;
import dto.EachProductSalesVO;
import dto.SalesByDateDTO;

public class SalesModel {
	//SalesDAO 선언
	private SalesDAO sd = new SalesDAO();
	
	//일자별 상품 정보 변환
	public JSONArray dayStatToJSON(String date) {
		JSONArray jarray = null;
		ArrayList<EachProductSalesVO> epslist = sd.daySalesStat(date);
		if (epslist != null) {
			jarray = new JSONArray(epslist);
			System.out.println("dayStats : " + jarray);
		}else {
			System.out.println("ArrayList Null");
		}
		
		return jarray;
	}
	
	//일자별 매출 변환
	public JSONArray salesToJSON() {
		JSONArray jarray = null;
		ArrayList<SalesByDateDTO> slist = sd.selectAll();
		if (slist != null) {
			jarray = new JSONArray(slist);
			System.out.println("SalesModel : " + slist);
		}else {
			System.out.println("ArrayList Null");
		}
		return jarray;
	}
	
	//전체 변환
	public JSONArray parseList(ArrayList<Object> list) {
		return new JSONArray(list);
	}
	
	//현재 월별 매출 변환
	public int monthSalesNow() {
		int sales = 0;
		
		LocalDate date = LocalDate.now();
		int year = date.getYear();
		String month = ""+date.getMonthValue();
		
		if (month.length() == 1) {
			month = "0"+month;
		}		
		
		String nowYearMonth = year+"-"+month;
		sales = monthSales(nowYearMonth);
		
		return sales;
	}
	
	//월별 매출 변환
	public int monthSales(String yearMonth) {
		return sd.monthSales(yearMonth);
	}
}
