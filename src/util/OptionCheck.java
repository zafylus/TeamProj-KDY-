package util;

import service.Service_st;
import vo.StockOptionVO;

public class OptionCheck {

		// 이전 알람 설정 확인 후 반환
		public String alramStockCheck() {
			Service_st serv_st = new Service_st();
			StockOptionVO stOpt = serv_st.getStockOption();
			boolean opt = stOpt.isAlramOpt();
			String check = "";
			
			if (opt) 
				check = "checked";
			
			return check;
		}
		
		public int alramStockNum() {
			Service_st serv_st = new Service_st();
			StockOptionVO stOpt = serv_st.getStockOption();
			int alNum = 0;
			alNum = stOpt.getAlramNum();
			return alNum;
		}
		
		// 파라미터 값을 넣어 checked 가 오면 true 반환
		public boolean alramParamCheck(String opt) {
			boolean result = false;
			if (opt != null && opt.equals("checked")) {
				result = true;
			}
			return result;
		}
		
		public boolean getAlramOpt() {
			Service_st st_serv = new Service_st();
			boolean alOpt = st_serv.getStockOption().isAlramOpt();
			return alOpt;
		}
}
