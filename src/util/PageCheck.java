package util;

public class PageCheck {
	
	public static int pageNumCheck(String page_str) {
		int pageNum = 1;
		if (page_str != null) {
			pageNum = Integer.parseInt(page_str);
		}
		return pageNum;
	}
}
