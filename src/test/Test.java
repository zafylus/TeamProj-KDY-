package test;

import java.time.LocalDate;

import org.json.JSONArray;

import services.SalesModel;

public class Test {
	public static void main(String[] args) {
//		LocalDate date = LocalDate.now();
//		int yaer = date.getYear();
//		System.out.println(yaer);
//		int month = date.getMonthValue();
//		System.out.println(month);
		SalesModel sm = new SalesModel();
		System.out.println(sm.monthSalesNow());
//		JSONArray jarry = sm.parseList();
//		System.out.println("Main : " + jarry);
//		LocalDate now = LocalDate.now();
//		System.out.println(now.toString().substring(0,7));
		/*ProductDAO pDao = new ProductDAO();
		ArrayList<Product> plist = pDao.selectAll();
		
		for (Product product : plist) {
			System.out.println(product);
		}*/
//		SalesDAO s = new SalesDAO();
//		System.out.println(s.monthSales("2023-05"));
//		ArrayList<SalesByDateDTO> slist = s.selectAll();
//		
//		for (SalesByDateDTO salesByDate : slist) {
//			System.out.println(salesByDate);
//		}
	}
}
