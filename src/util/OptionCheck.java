package util;

import services.Service_st;
import vos.StockOptionVO;

public class OptionCheck {

		// 알림 여부를 받아와 true 일 경우 checked 문자열 반환
		public static String alramStockCheck() {
			boolean opt = getAlramOpt();
			String check = "";
			
			if (opt) 
				check = "checked";
			return check;
		}
		
		// DB에 저장된 알림 설정 수치를 받아와서 반환
		public static int alramStockNum() {
			Service_st serv_st = new Service_st();
			StockOptionVO stOpt = serv_st.getStockOption();
			int alNum = 0;
			alNum = stOpt.getAlramNum();
			return alNum;
		}
		
		// 파라미터 값을 넣어 checked 가 오면 true 반환
		public static boolean alramParamCheck(String opt) {
			boolean result = false;
			if (opt != null && opt.equals("checked")) {
				result = true;
			}
			return result;
		}
		
		// DB에 저장된 알림 켜고 끄기 옵션을 boolean으로 받아온 후 반환
		public static boolean getAlramOpt() {
			Service_st st_serv = new Service_st();
			boolean alOpt = st_serv.getStockOption().isAlramOpt();
			return alOpt;
		}
}
