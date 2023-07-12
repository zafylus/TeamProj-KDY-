package test;

import java.util.ArrayList;

import dao.SalesDAO;
import dto.SalesByDateDTO;

public class Test {
	public static void main(String[] args) {
//		NumberFormat nf = NumberFormat.getInstance();
//		System.out.println(nf.format(1000000000));
//		LocalDate date = LocalDate.now();
//		int yaer = date.getYear();
//		System.out.println(yaer);
//		int month = date.getMonthValue();
//		System.out.println(month);
//		SalesModel sm = new SalesModel();
//		System.out.println(sm.dayStatToJSON("2023-07-15"));
//		System.out.println(sm.monthSalesNow());
//		JSONArray jarry = sm.parseList();
//		System.out.println("Main : " + jarry);
//		LocalDate now = LocalDate.now();
//		System.out.println(now.toString().substring(0,7));
		/*ProductDAO pDao = new ProductDAO();
		ArrayList<Product> plist = pDao.selectAll();
		
		for (Product product : plist) {
			System.out.println(product);
		}*/
		SalesDAO s = new SalesDAO();
		ArrayList<SalesByDateDTO> alist = s.selectAll();
		for (SalesByDateDTO salesByDateDTO : alist) {
			System.out.println(salesByDateDTO);
		}
//		ArrayList<EachProductSalesVO> elist = s.daySalesStat("2023-07-15");
//		for (EachProductSalesVO eachProductSalesVO : elist) {
//			System.out.println(eachProductSalesVO);
//		}
//		System.out.println(s.monthSales("2023-05"));
//		ArrayList<SalesByDateDTO> slist = s.selectAll();
//		
//		for (SalesByDateDTO salesByDate : slist) {
//			System.out.println(salesByDate);
//		}
	}
}