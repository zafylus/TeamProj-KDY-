package service.sale;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.SaleDAO;
import erp_interface.getPageDbData;
import vo.sale.saleCalendar.DailySaleVO;

public class SaleCalendar implements getPageDbData{
	public Map<String, Object> returnData(Date startDate, Date endDate) {
		
		SaleDAO saDao = new SaleDAO(startDate, endDate);
		List<DailySaleVO> saleDailyList = saDao.getDailySales();
		Map<String, Object> dataDB = null;
		int totalSale = saDao.getRealTotalSales();
		int totalRefund = saDao.getTotalRefunds();
		
		System.out.println("totalSale : " + totalSale);
		System.out.println("refundSale : " + totalRefund);
		System.out.println("saleDailyList: " + saleDailyList);
		
		dataDB = new HashMap<>();
		dataDB.put("totalSale", totalSale);
		dataDB.put("totalRefund", totalRefund);
		dataDB.put("saleDailyList", saleDailyList);
		
		return dataDB;
	}
}
