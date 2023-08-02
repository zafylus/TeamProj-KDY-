package util;

public class PageCheck {

	public static String stockPageCheck(String req) {
		String page = null;
		if (req != null && req.equals("list")) {
			page = "stockList.jsp";
		} else if(req.equals("reg")) {
			page = "insertStock.jsp";
		} else if(req.equals("opt")) {
			page = "stockOption.jsp";
		} else if(req.equals("calc")) {
			page = "stockCalc.jsp";
		} else {
			page = "totalStock.jsp";
		}
		return page;
	}
	
	public static String expensePageCheck(String req) {
		String page = null;
		if (req != null && req.equals("list")) {
			page = "expenseList.jsp";
		} else {
			page = "insertExpense.jsp";
		}
		return page;
	}
	
	public static int pageNumCheck(String page_str) {
		int pageNum = 1;
		if (page_str != null) {
			pageNum = Integer.parseInt(page_str);
		}
		return pageNum;
	}
}
