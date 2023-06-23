package test;
import java.util.ArrayList;

import dto.Coffee;
import dto.Product;

public class Test {
	public static void main(String[] args) {
		dao.ProductDAO p = new dao.ProductDAO();
		Product c = new Coffee("PR004", 6500, "카라멜마키아또", "커피");
//		p.regist(c);
//		p.updateProduct(c);
		p.deleteProduct("PR004");
		ArrayList<Product> plist = p.selectAll();
		
		for (Product product : plist) {
			System.out.println(product.toString());
		}
	}
}
