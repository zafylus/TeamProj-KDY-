package service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import erp_interface.getPageDbData;
import vo.DateBeginEnd;
import vo.PeriodVO;

public class DivisionService {
	Date startDate;
	Date endDate;
	getPageDbData getDataInterface = null;

	public Map<String, Object> dataDevision(PeriodVO period) {
		
		String url = period.getUrlName();
		Map<String, Object> dataMap = new HashMap<>();

		
		switch (url) {
		case "productAnalysis":
			getDataInterface = new ProductAnalysis(); 
			break;

		case "saleAnalysis":
			getDataInterface = new SaleAnalysis();
			break;
			
		case "saleCalendar":
			getDataInterface = new SaleCalendar();
			break;
			
		default:
			break;
		}
		
		getStartEndDate(period);
		dataMap = getDataInterface.returnData(startDate, endDate);
		System.out.println("dataMap : " + dataMap);
		return dataMap;
	}
	
	
	
	private void getStartEndDate(PeriodVO period) {
		CalcPeriod calp = new CalcPeriod();
		DateBeginEnd date =calp.getPeriod(period);
		
		LocalDate startLocalDate = date.getBeginPeriod();
		LocalDate endLocalDate = date.getEndPeriod();
		
		startDate = Date.valueOf(startLocalDate);
		endDate = Date.valueOf(endLocalDate);
		
		System.out.println("StartDate" + startDate);
		System.out.println("EndDate" + endDate);
	}
}