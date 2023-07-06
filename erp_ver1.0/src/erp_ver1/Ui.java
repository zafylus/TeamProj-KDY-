package erp_ver1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.ExpenseDTO;
import dto.StockDTO;
import expense.Service_ex;
import stock.Service_st;
import vo.TotalStockVO;

public class Ui {

	public static void mainUi() {
		Scanner sc = new Scanner(System.in);
		Service_ex e_serv = new Service_ex();
		Service_st s_serv = new Service_st();
		LocalDate today = LocalDate.now();
		line(80);
		System.out.println("ERP ver1.0                   "+today);
		line(80);
		if (e_serv.fixedCostCheck().size() != 0) {
			todayFixedCost();
			System.out.println("지출 자동 입력하시겠습니까 ?  (1:Yes / 0:No)");
			selectForm();
			int sel3 = sc.nextInt();
			sc.nextLine();
			switch(sel3) {
			case 0 : 
				System.out.println("자동 입력을 취소하셨습니다.");
				break;
			case 1 :
				e_serv.fixedCostInsert();
				break;
			}
		}
		menu1();
		int sel = sc.nextInt();
		sc.nextLine();
		ln(30);
		switch(sel) {
		case 1:
			emenu();
			selectForm();
			int sel2 = sc.nextInt();
			sc.nextLine();
			ln(30);
			line(80);
			switch(sel2) {
			case 1: 
				System.out.println("재료 코드를 입력하세요 (M000)");
				selectForm();
				String m_code = sc.next();
				System.out.println("단가를 입력하세요.");
				selectForm();
				int e_cost = sc.nextInt();
				sc.nextLine();
				System.out.println("수량을 입력하세요.");
				selectForm();
				int e_amount = sc.nextInt();
				sc.nextLine();
				e_serv.insertExpense(m_code, e_cost, e_amount);
				break;
			case 2:
				menu2();
				selectForm();
				int sel3 = sc.nextInt();
				sc.nextLine();
				switch(sel3) {
				case 1:
					line(80);
					e_serv.selectAllExpense();
					break;
				case 2:
					System.out.println("조회할 기간을 입력하세요.");
					System.out.println("기간1 (yyyy-MM-dd) : >>");
					String date1 = sc.next();
					System.out.println("기간2 (yyyy-MM-dd) : >>");
					String date2 = sc.next();
					e_serv.betweenDateList(date1, date2);
				}
				break;
			}
			break;
		case 2:
			smenu();
			selectForm();
			sel2 = sc.nextInt();
			sc.nextLine();
			line(80);
			switch(sel2) {
			case 1:
				System.out.println("재료 코드를 입력하세요 (M000)");
				selectForm();
				String m_code = sc.next();
				System.out.println("수량을 입력하세요.");
				int s_amount = sc.nextInt();
				selectForm();
				sc.nextLine();
				s_serv.insertStock(m_code, s_amount);
				break;
			case 2:
				menu2();
				selectForm();
				int sel3 = sc.nextInt();
				sc.nextLine();
				switch(sel3) {
				case 1:
					line(80);
					s_serv.getTotalList();
					line(80);
					s_serv.selectAllStock();
					break;
				case 2:
					System.out.println("조회할 기간을 입력하세요.");
					System.out.println("기간1 (yyyy-MM-dd) : >>");
					String date1 = sc.next();
					System.out.println("기간2 (yyyy-MM-dd) : >>");
					String date2 = sc.next();
					line(80);
					s_serv.stockDateList(date1, date2);
					
				}
				break;
			}
		}
	}
	
	
	public static void line(int cnt) {
		for (int i = 0; i < cnt; i++) {
			System.out.print("=");
		}
		System.out.println();
	}
	
	public static void ln(int cnt) {
		for (int i = 0; i < cnt; i++) {
			System.out.println();
		}
	}
	
	public static void menu1() {
		System.out.println("1. 지출 관리\t 2. 재고 관리");
	}
	
	public static void menu2() {
		System.out.println("1.전체 조회\t 2. 기간 조회");
	}
	
	public static void emenu() {
		System.out.println("1. 지출 입력\t 2. 지출 조회");
	}
	
	public static void smenu() {
		System.out.println("1. 재고 입력\t 2. 재고 조회");
	}
	
	public static void selectForm() {
		System.out.print("입력 >> ");
	}
	
	public static void todayFixedCost() {
		Service_ex e_serv = new Service_ex();
		ArrayList<String> f_names = e_serv.fixedCostCheck();
		System.out.print("오늘 고정비 지출 내역은 [ ");
		for (String s : f_names) {
			System.out.print(s +"  ");
		}
		System.out.print("] 입니다.");
		System.out.println();
	}
}
