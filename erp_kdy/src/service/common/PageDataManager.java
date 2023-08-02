package service.common;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import erp_interface.getPageDbData;
import service.sale.ProductAnalysis;
import service.sale.SaleAnalysis;
import service.sale.SaleCalendar;
import vo.getDate.DateBeginEnd;
import vo.transData.TransInfoVO;

public class PageDataManager {
	private Date BeginDate;
	private Date endDate;
	getPageDbData getDataInterface = null;

	// url과 일치하는 데이터를 가져오는 메서드 
	public Map<String, Object> dataDevision(TransInfoVO period) {
		
		String url = period.getUrl();
		Map<String, Object> dataDB = new HashMap<>();

		
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
		
		// DateBeginEnd 클래스에서 beginDate, endDate 추출하기
		getBeginEndDate(period);
		// 날짜를 입력하고 DB에서 값을 가져온다.
		dataDB = getDataInterface.returnData(BeginDate, endDate);
		System.out.println("dataDB : " + dataDB);
		return dataDB;
	}
	
	
	
	private void getBeginEndDate(TransInfoVO period) {
		
		// period를 beginDate, endDate로 변환한다.
		// beginDate, endDate는 DateBeginEnd 객체에 담아서 반환한다.
		CalcPeriod calp = new CalcPeriod();
		DateBeginEnd date =calp.getDate(period);
		
		// 반환 받은 DateBeginEnd에서  beginDate, endDate 얻는다.
		LocalDate BeginLocalDate = date.getBeginDate();
		LocalDate endLocalDate = date.getEndDate();
		
		// sql에 넣기 위해 Date 타입으로 변환한다.
		BeginDate = Date.valueOf(BeginLocalDate);
		endDate = Date.valueOf(endLocalDate);
		
		System.out.println("BeginDate : " + BeginDate);
		System.out.println("EndDate : " + endDate);
	}
}