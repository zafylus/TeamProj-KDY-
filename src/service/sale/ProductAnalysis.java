package service.sale;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.ProductSaleDAO;
import erp_interface.getPageDbData;
import vo.sale.productAnalysis.AllProductSaleVO;
import vo.sale.productAnalysis.SaleTop3VO;

public class ProductAnalysis implements getPageDbData{ 
	
	public Map<String, Object> returnData(Date startDate, Date endDate) {
		
		// DAO에 날짜값 입력
		ProductSaleDAO psDao = new ProductSaleDAO(startDate, endDate);
		
		// DB에서 데이터 받기
		List<AllProductSaleVO> allProductList = psDao.getAllPruductOrder();
		List<SaleTop3VO> topList = psDao.getTop3();
		int totalProductSale = psDao.getTotalProductSale();
		
		// Map에 저장 
		Map<String, Object> dataDB; // List는 너무 많이썼다. 새로운 자료구조를 써보자.
		dataDB = new HashMap<>();
		dataDB.put("topList", topList);
		dataDB.put("allProductList", allProductList);
		dataDB.put("totalProductSale", totalProductSale);
		// 반환
		return dataDB;
	}
}
