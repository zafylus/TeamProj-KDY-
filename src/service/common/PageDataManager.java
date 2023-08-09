package service.common;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import erp_interface.getPageDbData;
import service.sale.ProductAnalysis;
import service.sale.SaleAnalysis;
import service.sale.SaleCalendar;
import vo.getDate.BeginEndDate;
import vo.transData.TransInfoDTO;

public class PageDataManager {
	// Service 매개변수, 시작날짜/마지막날짜
	private Date BeginDate;
	private Date endDate;
	// 매서드 -> 인터페이스 
	getPageDbData getDataInterface = null;
	

	// url과 일치하는 데이터를 가져오는 메서드 
	public Map<String, Object> dataDevision(TransInfoDTO info) { 	
		
		// url 정보
		String url = info.getUrl();

		
		// 페이지 별로 다른 클래스 할당
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
		
		// 시작,마지막 날짜 구함 -> 매개변수 대입
		getBeginEndDate(info);
		
		// 날짜 입력, DB값 Map으로 반환
		Map<String, Object> dataDB = new HashMap<>();
		dataDB = getDataInterface.returnData(BeginDate, endDate);
		return dataDB;
		// 인터페이스 매서드 단 하나, 인터페이스 사용해 보고 싶었음
	}
	
	
	
	private void getBeginEndDate(TransInfoDTO info) {
		
		// 시작, 마지막 날짜 구하는 method
		CalcPeriod calp = new CalcPeriod();
		BeginEndDate date =calp.getDate(info);
		
		// sql.Date로 변환
		LocalDate BeginLocalDate = date.getBeginDate();
		LocalDate endLocalDate = date.getEndDate();
		
		BeginDate = Date.valueOf(BeginLocalDate);
		endDate = Date.valueOf(endLocalDate);
	}
}