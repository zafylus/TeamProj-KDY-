package util;

public class PageCheck {

	public String stockPageCheck(String req) {
		String page = null;
		if (req != null && req.equals("list")) {
			page = "stockList.jsp";
		} else if(req.equals("reg")) {
			page = "insertStock.jsp";
		} else if(req.equals("opt")) {
			page = "stockOption.jsp";
		} else {
			page = "totalStock.jsp";
		}
		return page;
	}
}
