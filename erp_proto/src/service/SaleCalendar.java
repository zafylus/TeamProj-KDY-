package service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.SaleDAO;
import erp_interface.getPageDbData;
import vo.DailySaleVO;

public class SaleCalendar implements getPageDbData{
	public Map<String, Object> returnData(Date startDate, Date endDate) {
		Map<String, Object> dataMap = null;
		SaleDAO saDao = new SaleDAO(startDate, endDate);
		
		int totalSale = saDao.getRealTotalSales();
		int totalRefund = saDao.getTotalRefunds();
		List<DailySaleVO> saleDailyList = saDao.getDailySales();
		
		System.out.println("totalSale : " + totalSale);
		System.out.println("refundSale : " + totalRefund);
		System.out.println("saleDailyList: " + saleDailyList);
		
		dataMap = new HashMap<>();
		dataMap.put("totalSale", totalSale);
		dataMap.put("totalRefund", totalRefund);
		//dataMap.put("saleDailyList", saleDailyList);
		
		return dataMap;
	}
}
