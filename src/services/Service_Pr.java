package services;

import java.util.List;

import dao.ProductsDAO;
import dto.ProductDTO;

public class Service_Pr {
	
	public List<ProductDTO> getList() {
		ProductsDAO dao = new ProductsDAO();
		
		@SuppressWarnings("unchecked")
		List<ProductDTO> plist = (List<ProductDTO>)(Object)dao.getData();
		return plist;
	}
}
