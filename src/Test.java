import java.util.ArrayList;

import dto.Product;

public class Test {
	public static void main(String[] args) {
		dao.ProductDAO p = new dao.ProductDAO();
//		Product c = new Coffee("01010003", "카라멜라떼", 5000,"커피"); 
////		p.regist(c);
////		p.updateProduct(c);
//		p.deleteProduct("?");
		ArrayList<Product> plist = p.selectAll();
		
		for (Product product : plist) {
			System.out.println(product.toString());
		}
	}
}
