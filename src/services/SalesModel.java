package services;

import java.time.LocalDate;
import java.util.ArrayList;

import org.json.JSONArray;

import dao.SalesDAO;
import dto.EachProductSalesVO;
import dto.SalesByDateDTO;

public class SalesModel {
	private SalesDAO sd = new SalesDAO();
	
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
	
	public JSONArray parseList(ArrayList<Object> list) {
		return new JSONArray(list);
	}
	
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
	
	public int monthSales(String yearMonth) {
		int sales = 0;
		
		sales = sd.monthSales(yearMonth);
		
		return sales;
	}
}
