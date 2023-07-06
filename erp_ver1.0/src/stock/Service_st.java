package stock;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dao.StockDAO;
import dto.StockDTO;
import vo.TotalStockVO;

public class Service_st {

		public void insertStock(String ma_code, int st_ea) {
			StockDTO s = new StockDTO();
			StockDAO dao = new StockDAO();
			s.setMa_code(ma_code);
			s.setSt_ea(st_ea);
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
		
		public List<StockDTO> selectAllStock(int p) {
			StockDAO dao = new StockDAO();
			List<Object> list = dao.getData(p);
			@SuppressWarnings("unchecked")
			List<StockDTO> slist = (List<StockDTO>)(Object)list;
			return slist;
		}
		
		
		
		public void deleteStock(StockDTO s) {
			StockDAO dao = new StockDAO();
			if (dao.dalete(s)) {
				System.out.println("삭제 완료");
			}
		}
		
		// 두 기간 사이의 재고 입출력 리스트 보여주기
		public void stockDateList(String date1, String date2, int p) {
			StockDAO sdao = new StockDAO();
			List<StockDTO> eList = sdao.getStockDateData(date1, date2, p);
			for (StockDTO s : eList) {
				System.out.println(s);
			}
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
}
