package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.ProductSaleDAO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vo.DateBeginEnd;
import vo.PeriodVO;
import vo.ProductSaleVO;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DivisionService {

	
	private Object obj;

	public Map<String, Object> dataDevision() {
		Map<String, List<ProductSaleVO>> dataMap;
		
		if (obj instanceof PeriodVO) {
			PeriodVO period = (PeriodVO) obj;
			CalcPeriod calp = new CalcPeriod();
			DateBeginEnd date =calp.getPeriod(period);
			
			ProductSaleDAO psDao = new ProductSaleDAO();
			List<ProductSaleVO> CtgyOrderList = psDao.getCategoryOrder(date);
			List<ProductSaleVO> topList = psDao.getTop3(date);
			
			dataMap = new HashMap<>();
			dataMap.put("CtgyOrderList", CtgyOrderList);
			dataMap.put("topList", topList);
			
			return dataMap;
		}
		
		return Map;
	}
}