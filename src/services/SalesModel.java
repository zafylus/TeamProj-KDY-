package services;

import java.time.LocalDate;
import java.util.ArrayList;

import org.json.JSONArray;

import dao.SalesDAO;
import dto.SalesByDateDTO;

public class SalesModel {
	SalesDAO sd = new SalesDAO();
	
	public JSONArray parseList() {
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
	
	public int monthSalesNow() {
		int sales = -1;
		
		LocalDate date = LocalDate.now();
		int year = date.getYear();
		String month = ""+date.getMonthValue();
		
		if (month.length() == 1) {
			month = "0"+month;
		}		
		
		String nowYearMonth = year+"-"+month;
		
		sales = sd.monthSales(nowYearMonth);
		
		return sales;
	}
}
