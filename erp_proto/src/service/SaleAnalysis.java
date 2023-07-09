package service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.SaleDAO;
import erp_interface.getPageDbData;

public class SaleAnalysis implements getPageDbData{
	public Map<String, Object> returnData(Date startDate, Date endDate) {
		Map<String, Object> dataMap = null;
		List<Integer> saleList = new ArrayList<>();
		List<Integer> refundList = new ArrayList<>();
		SaleDAO saDao = new SaleDAO(startDate, endDate);
		
		saleList.add(saDao.getTotalSales());
		saleList.add(saDao.getSaleCount());
		saleList.add(saDao.getAveragePayment());
		
		refundList.add(saDao.getTotalRefunds());
		refundList.add(saDao.getRefundCount());
		refundList.add(saDao.getAverageRefund());
		
		
		System.out.println("saleList : " + saleList);
		System.out.println("refundList : " + refundList);
		
		dataMap = new HashMap<>();
		dataMap.put("saleList", saleList);
		dataMap.put("refundList", refundList);
		
		return dataMap;
	}
}
