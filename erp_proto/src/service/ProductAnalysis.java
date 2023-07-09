package service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.ProductSaleDAO;
import erp_interface.getPageDbData;
import vo.SaleCategoryVO;
import vo.SaleTop3VO;

public class ProductAnalysis implements getPageDbData{
	
	public Map<String, Object> returnData(Date startDate, Date endDate) {
		Map<String, Object> dataMap;
		
		ProductSaleDAO psDao = new ProductSaleDAO(startDate, endDate);
		List<SaleCategoryVO> ctgyOrderList = psDao.getCategoryOrder();
		List<SaleTop3VO> topList = psDao.getTop3();
		int totalProductSale = psDao.getTotalProductSale();
		
		System.out.println(ctgyOrderList);
		System.out.println(topList);
		
		dataMap = new HashMap<>();
		dataMap.put("topList", topList);
		dataMap.put("ctgyOrderList", ctgyOrderList);
		dataMap.put("totalProductSale", totalProductSale);
		
		return dataMap;
	}
}
