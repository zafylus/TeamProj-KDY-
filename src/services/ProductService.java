package services;

import java.util.ArrayList;
import java.util.List;


import dao.ProductMDAO;
import dto.Coffee;
import dto.Product;
import dto.ProductInfoDTO;
import dto.RecipeDTO;

//상품 서비스
public class ProductService {

	private ProductMDAO pdao = new ProductMDAO();
	
	//상품 등록
	public boolean regist(Product p, RecipeDTO r) {
		String pr_code = plusProdno(p.getPr_ctgry());
		p.setPr_code(pr_code);
		r.setPr_code(pr_code);
		int prodRegRes = pdao.regist(p);
		int reciRegRes = pdao.registRecipe(r);
		System.out.println("Prod reg time res : " + prodRegRes*reciRegRes);
		if (prodRegRes*reciRegRes == 1) {
			return true;
		}
		
		return false;
	}
	
	//상품 목록
	public ArrayList<Product> productList(){
		ArrayList<Product> plist = null;
		
		plist = pdao.productList();
		
		return plist;
	} 
	
	//상품 불러오기
	public Product productOne(String pr_code){
		return pdao.productOne(pr_code);
	}
	
	//레시피 불러오기
	public RecipeDTO recipe(String pr_code){
		return pdao.recipe(pr_code);
	}
	
	//상품 상세 정보 변환
	public List<ProductInfoDTO> productInfo() {
		List<ProductInfoDTO> plist = pdao.selectAll();
		System.out.println(plist);
		return plist;
	}
	
	//상품 수정
		public boolean modify(Product p, RecipeDTO r) {
			int prodModRes = pdao.updateProduct((Coffee) p);
			int reciModRes = pdao.updateRecipe(r);
			if (prodModRes*reciModRes == 1) {
				return true;
			}
			
			return false;
		}
	
	// 상품번호 +1
	private String plusProdno(String category) {
		String prodno = null;
		String maxNo = pdao.getMaxProdno(category);
		int no = Integer.parseInt(maxNo.substring(2))+1;
		String temp = ""+no;
		
		switch(temp.length()) {
			case 1:
				prodno = maxNo.substring(0, 2)+"00"+no;
				break;
			case 2:
				prodno = maxNo.substring(0, 2)+"0"+no;
				break;
			case 3:
				prodno = maxNo.substring(0, 2)+no;
				break;
			default:
				System.out.println("상품번호가 1000 이상입니다");
				break;
		}
		
		return prodno;
	}
	
	

}
