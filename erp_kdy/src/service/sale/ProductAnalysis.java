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
		
		ProductSaleDAO psDao = new ProductSaleDAO(startDate, endDate);
		List<AllProductSaleVO> allProductList = psDao.getAllPruductOrder();
		List<SaleTop3VO> topList = psDao.getTop3();
		Map<String, Object> dataDB;
		int totalProductSale = psDao.getTotalProductSale();
		
		System.out.println("allProductList" + allProductList);
		System.out.println("topList" + topList);
		System.out.println("totalProductSale" + totalProductSale);
		
		dataDB = new HashMap<>();
		dataDB.put("topList", topList);
		dataDB.put("allProductList", allProductList);
		dataDB.put("totalProductSale", totalProductSale);
		
		return dataDB;
	}
}
