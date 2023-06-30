package test;

import java.time.LocalDate;

public class Test {
	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		System.out.println(now.toString().substring(0,7));
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
