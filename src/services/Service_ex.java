package services;

import java.time.LocalDateTime;
import java.util.List;

import org.json.JSONArray;

import dao.ExpenseDAO;
import dao.FixedCostDAO;
import dto.ExpenseDTO;
import dto.FixedCostDTO;
import util.NameCheck;



public class Service_ex {

	public void insertExpense(String ma_code, int ex_cost, int ex_ea) {
		ExpenseDTO e = new ExpenseDTO();
		e.setMa_code(NameCheck.MaNameToCode(ma_code));
		e.setEx_cost(ex_cost);
		e.setEx_ea(ex_ea);
		e.setEx_date(LocalDateTime.now());
		ExpenseDAO dao = new ExpenseDAO();
		
		if (dao.insert(e))
			System.out.println("지출 입력 완료");
	}
	
	public void updateExpense(ExpenseDTO e) {
		ExpenseDAO dao = new ExpenseDAO();
		Object dto = e;
		if (dao.update(dto))
			System.out.println("수정 완료");
	}
	
	// 모든 지출 리스트 받아와 반환
	public List<ExpenseDTO> getList() {
		ExpenseDAO dao = new ExpenseDAO();
		List<Object> list = dao.getData();
		@SuppressWarnings("unchecked")
		List<ExpenseDTO> elist = (List<ExpenseDTO>)(Object)list;
		return elist;
	}
	
	public void deleteExpense(ExpenseDTO e) {
		ExpenseDAO dao = new ExpenseDAO();
		if (dao.delete(e))
			System.out.println("삭제 완료");
	}
	
	// 특정 날짜 사이의 지출 리스트 보여주기
	// 페이지를 입력하여 20개 단위의 데이터 반환
	public List<ExpenseDTO> expenseDateBTWList(String date1, String date2, int p) {
		ExpenseDAO edao = new ExpenseDAO();
		List<ExpenseDTO> eList = edao.getDateData(date1, date2, p);
		
		for(ExpenseDTO dto : eList) {
			if(NameCheck.MaCodeCheck(dto.getMa_code()))
				dto.setMa_code(NameCheck.MaCodeToName(dto.getMa_code()));
		}
		return eList;
	}
	
	// 두 기간 사이의 재고 입출 자료 총 갯수 반환
	public int getListCntBtwDate(String date1, String date2) {
		ExpenseDAO sdao = new ExpenseDAO();
		int cnt = sdao.getListCntBetweenDate(date1, date2);
		return cnt;
	}
	
	// 리스트의 재료코드를 재료이름으로 변환
	public List<ExpenseDTO> allCodeToName(List<ExpenseDTO> list) {
		for(ExpenseDTO dto : list) {
			if(NameCheck.MaCodeCheck(dto.getMa_code()))
				dto.setMa_code(NameCheck.MaCodeToName(dto.getMa_code()));
		}
		return list;
	}
	
	// 리스트의 재료이름을 재료코드로 변환
	public List<ExpenseDTO> allNameToCode(List<ExpenseDTO> list) {
		for(ExpenseDTO dto : list) {
			if(NameCheck.MaNameCheck(dto.getMa_code()))
				dto.setMa_code(NameCheck.MaNameToCode(dto.getMa_code()));
		}
		return list;
	}
	
	public void registFixedCost(FixedCostDTO dto) {
		FixedCostDAO dao = new FixedCostDAO();
		
		if(dao.insert(dto))
			System.out.println("고정비 등록 완료");
	}
	
	
	// 고정비 리스트 DAO에서 가져와서 리스트 반환
	public List<FixedCostDTO> getFixedCostList() {
		FixedCostDAO fdao = new FixedCostDAO();
		@SuppressWarnings("unchecked")
		List<FixedCostDTO> flist = (List<FixedCostDTO>)(Object)fdao.getData();
		return flist;
	}
	
	public void modifyFixedCost(FixedCostDTO dto) {
		FixedCostDAO dao = new FixedCostDAO();
		
		if(dao.update(dto))
			System.out.println("고정비 수정 완료");
	}
	
	public void deleteFixedCost(FixedCostDTO dto) {
		FixedCostDAO dao = new FixedCostDAO();
		if(dao.delete(dto))
			System.out.println("고정비 삭제 완료");
	}
	
}
