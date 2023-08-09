package service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDAO;
import dao.StockDAO;
import dto.RecipeDTO;
import dto.StockDTO;
import vos.StockOptionVO;
import vos.TotalStockVO;

public class Service_st {

		public void insertStock(String ma_code, int st_ea, String note) {
			StockDTO s = new StockDTO();
			StockDAO dao = new StockDAO();
			s.setMa_code(ma_code);
			s.setSt_ea(st_ea);
			s.setSt_note(note);
			s.setSt_recDate(LocalDateTime.now());
			if (dao.insert(s)) {
				System.out.println("재고 등록 완료");
			}
		}
		
		public void updateStock(StockDTO s) {
			StockDAO dao = new StockDAO();
			s.setSt_recDate(LocalDateTime.now());
			Object dto = s;
			if (dao.update(dto)) {
				System.out.println("수정 완료");
			}
		}
		
		public List<StockDTO> selectAllStock() {
			StockDAO dao = new StockDAO();
			List<Object> list = dao.getData();
			@SuppressWarnings("unchecked")
			List<StockDTO> slist = (List<StockDTO>)(Object)list;
			return slist;
		}
		
		
		
		public void deleteStock(StockDTO s) {
			StockDAO dao = new StockDAO();
			if (dao.delete(s)) {
				System.out.println("삭제 완료");
			}
		}
		
		// 두 기간 사이의 재고 입출력 리스트 보여주기 ( 페이지 단위 )
		public List<StockDTO> stockDateBTWList(String date1, String date2, int p) {
			StockDAO sdao = new StockDAO();
			List<StockDTO> eList = sdao.getStockDateData(date1, date2, p);
			return eList;
		}
		
		// 재고 총량 리스트 반환 후 보여주기
		public ArrayList<TotalStockVO> getTotalList() {
			StockDAO sdao = new StockDAO();
			ArrayList<TotalStockVO> alist = (ArrayList<TotalStockVO>) sdao.getTotal();
			return alist;
		}
		
		//재고 입출 자료 총 갯수 반환
		public int getListCnt() {
			StockDAO sdao = new StockDAO();
			int cnt = sdao.getListCnt();
			return cnt;
		}
		
		// 두 기간 사이의 재고 입출 자료 총 갯수 반환
		public int getListCntBtwDate(String date1, String date2) {
			StockDAO sdao = new StockDAO();
			int cnt = sdao.getListCntBetweenDate(date1, date2);
			return cnt;
		}
		
		// 재고 알람 옵션 설정
		public void setStockOption(boolean checked, int num) {
			StockDAO sdao = new StockDAO();
			if(sdao.setOption(checked, num)) {
				System.out.println("옵션 변경 완료");
			}
		}
		
		// 재고 알람 옵션 가져오기
		public StockOptionVO getStockOption() {
			StockDAO sdao = new StockDAO();
			StockOptionVO opt = new StockOptionVO();
			
			opt = sdao.getOption();
			return opt;
		}
		
		// 상품 레시피 리스트 가져오기
		public List<RecipeDTO> getRecipeList() {
			ProductDAO pdao = new ProductDAO();
			List<RecipeDTO> rlist = pdao.getRecipeList();
			return rlist;
		}
}
