package util;

import java.util.List;

import service.Service_st;
import vo.TotalStockVO;

public class StockCalculator {
	
	public static void getCalc(String[] products) {
		Service_st st_serv = new Service_st();
		List<TotalStockVO> slist = st_serv.getTotalList();
		
	}
}
