package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.ProductSaleDAO;
import vo.DateBeginEnd;
import vo.PeriodVO;
import vo.SaleCategoryVO;
import vo.SaleTop3VO;

public class ProductAnalysis {
	public Map<String, Object> returnDAta(PeriodVO period) {
		Map<String, Object> dataMap = null;
		
		CalcPeriod calp = new CalcPeriod();
		DateBeginEnd date =calp.getPeriod(period);
		
		ProductSaleDAO psDao = new ProductSaleDAO();
		List<SaleCategoryVO> CtgyOrderList = psDao.getCategoryOrder(date);
		List<SaleTop3VO> topList = psDao.getTop3(date);
		int totalProductSale = psDao.getTotalProductSale(date);
		
		System.out.println(CtgyOrderList);
		System.out.println(topList);
		
		dataMap = new HashMap<>();
		dataMap.put("totalSale", totalProductSale);
		dataMap.put("CtgyOrderList", CtgyOrderList);
		dataMap.put("topList", topList);
		
		return dataMap;
	}
}
