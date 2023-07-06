package expense;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dao.ExpenseDAO;
import dao.FixedCostDAO;
import dao.MaterialDAO;
import dto.ExpenseDTO;
import dto.FixedCostDTO;
import dto.MaterialDTO;
import dto.StockDTO;
import stock.Service_st;



public class Service_ex {

	public void insertExpense(String ma_code, int ex_cost, int ex_ea) {
		ExpenseDTO e = new ExpenseDTO();
		e.setMa_code(ma_code);
		e.setEx_cost(ex_cost);
		e.setEx_ea(ex_ea);
		e.setEx_date(LocalDateTime.now());
		Service_st s_serv = new Service_st();
		Service_ex e_serv = new Service_ex();
		ExpenseDAO dao = new ExpenseDAO();
		StockDTO s = null;
		
		if (dao.insert(e))
			System.out.println("지출 입력 완료");
		
			//지출 입력시 재고 데이터 확인후 재고 입력
			if(e_serv.auto_io(e) != null)
				s= e_serv.auto_io(e);
				s_serv.insertStock(s.getMa_code(), s.getSt_ea());
				System.out.println("재고 자동 입력 완료");
	}
	
	public void updateExpense(ExpenseDTO e) {
		ExpenseDAO dao = new ExpenseDAO();
		Object dto = e;
		if (dao.update(dto))
			System.out.println("수정 완료");
	}
	
	// 모든 지출 리스트 받아와 반환
	public List<ExpenseDTO> selectAllExpense(int p) {
		ExpenseDAO dao = new ExpenseDAO();
		List<Object> list = dao.getData(p);
		@SuppressWarnings("unchecked")
		List<ExpenseDTO> elist = (List<ExpenseDTO>)(Object)list;
		return elist;
	}
	
	public void deleteExpense(ExpenseDTO e) {
		ExpenseDAO dao = new ExpenseDAO();
		if (dao.dalete(e))
			System.out.println("삭제 완료");
	}
	
	
	// 오늘 날짜와 고정비 지출 날짜 동일 시 자동 입력
	public boolean fixedCostInsert() {
		FixedCostDAO dao = new FixedCostDAO();
		boolean flag = false;
		LocalDateTime today = LocalDateTime.now();
		int day = today.getDayOfMonth();
		@SuppressWarnings("unchecked")
		List<FixedCostDTO> fList = (List<FixedCostDTO>)(Object)dao.getData();
		for (FixedCostDTO f : fList) {
			if(f.getFi_date() == day) {
				ExpenseDTO dto = new ExpenseDTO();
				dto.setMa_code(f.getFi_name());
				dto.setEx_cost(f.getFi_cost());
				dto.setEx_ea(1);
				dto.setEx_date(LocalDateTime.now());
				if (dao.insert(dto))
					System.out.println("고정비 등록 완료");
					flag = true;
			}
		}
		return flag;
	}
	
	// 오늘 날짜와 고정비 입력 날짜 체크 후 당일 고정비 목록 반환
	public ArrayList<String> fixedCostCheck() {
		FixedCostDAO dao = new FixedCostDAO();
		LocalDateTime today = LocalDateTime.now();
		int day = today.getDayOfMonth();
		@SuppressWarnings("unchecked")
		List<FixedCostDTO> fList = (List<FixedCostDTO>)(Object)dao.getData();
		ArrayList<String> f_names = new ArrayList<>();
		for (FixedCostDTO f : fList) {
			if(f.getFi_date() == day) {
				f_names.add(f.getFi_name());
			}
		}
		return f_names;
	}
	
	// 지출시 재고 영역 자동 입력을 위한 재고 객체 생성
	public StockDTO auto_io(ExpenseDTO e) {
		StockDTO s = null;
		MaterialDAO mdao = new MaterialDAO();
		@SuppressWarnings("unchecked")
		List<MaterialDTO> mlist = (List<MaterialDTO>)(Object)mdao.getData();
		for (MaterialDTO m : mlist) {
			if(m.getMa_code().equals(e.getMa_code())) {
				String ma_code = e.getMa_code();
				int st_ea = e.getEx_ea();
				s = new StockDTO();
				s.setMa_code(ma_code);
				s.setSt_ea(st_ea);
			}
		}
		return s;
	}
	
	// 특정 날짜 사이의 지출 리스트 보여주기
	public void betweenDateList(String date1, String date2) {
		ExpenseDAO edao = new ExpenseDAO();
		List<ExpenseDTO> eList = edao.getDateData(date1, date2);
		for (ExpenseDTO e : eList) {
			System.out.println(e);
		}
	}
}
