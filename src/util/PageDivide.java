package util;

public class PageDivide {

	// 한페이지에 자료가 20개 일 경우
	// 받은 자료 갯수로 만들수 있는 최대 페이지 수
	public static int pageMaxNum(int p) {
		int lastPageNum = (int)Math.ceil(p/20.0);
		return lastPageNum;
	}
	
	// 한 페이지 그룹당 5개씩 보여질 경우
	// 현재 페이지를 받아 
	// 현재 페이지 그룹 첫번째 숫자 반환
	public static int pageStartNum(int p) {
		int startPageNum = p-((p-1)%5);
		return startPageNum;
	}
	
	// 현재 페이지 그룹의 첫번째 숫자를 받아
	// 현재 페이지 그룹의 마지막 숫자 반환
	public static int pageEndNum(int p) {
		return p+4;
	}
	
	// 현재 페이지 그룹의 마지막 숫자와 최대 페이지수 비교 후
	// 마지막 페이지 숫자가 작을 경우 마지막 페이지 숫자 반환
	public static int checkEndLastPage(int endPage, int lastPage) {
		if(endPage > lastPage) {
			endPage = lastPage;
		}
		return endPage;
	}
}
