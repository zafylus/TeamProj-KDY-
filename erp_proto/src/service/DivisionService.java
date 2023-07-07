package service;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vo.PeriodVO;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DivisionService {

	
	private Object obj;

	public Map<String, Object> dataDevision() {
		Map<String, Object> dataMap = new HashMap<>();
		
		if (obj instanceof PeriodVO) {
			PeriodVO period = (PeriodVO) obj;
			System.out.println("devision period : " + period);
			
			ProductAnalysis pa = new ProductAnalysis();
			
			 dataMap = pa.returnDAta(period);
			 System.out.println("dataMap : " + dataMap);
			return dataMap;
		}
		return dataMap;
	}
}