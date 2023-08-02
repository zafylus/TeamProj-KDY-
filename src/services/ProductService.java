package services;

import java.util.List;


import dao.ProductMDAO;
import dto.Product;
import dto.ProductInfoDTO;
import dto.RecipeDTO;

//상품 서비스
public class ProductService {

	private ProductMDAO pdao = new ProductMDAO();
	
	//상품 상세 정보 변환
	public List<ProductInfoDTO> productInfo() {
		List<ProductInfoDTO> plist = pdao.selectAll();
		System.out.println(plist);
		return plist;
	}
	
	public boolean regist(Product p, RecipeDTO r) {
		int prodRegRes = pdao.regist(p);
		int reciRegRes = pdao.registRecipe(r);
		
		if (prodRegRes*reciRegRes == 1) {
			return true;
		}
		
		return false;
	}
}
