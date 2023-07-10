package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;

import dto.EachProductSalesVO;
import dto.SalesByDateDTO;

public class SalesDAO implements SelectDAO{
	
	//월 총 매출 반환
	//매개변수 형식 : 'YYYY-MM'형식
	public int monthSales(String yearMonth){
		int sales = -1;
		try {
			String sql = "SELECT DATE_FORMAT(odr_date, '%Y-%m') AS mon, SUM(sales)\r\n" + 
					"		FROM ordr_view\r\n" + 
					"		WHERE DATE_FORMAT(odr_date, '%Y-%m') = ?" + 
					"		GROUP BY mon";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, yearMonth);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				sales = rs.getInt(2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sales;
	}
	
	//당일 상품 통계 데이터 반환
	public ArrayList<EachProductSalesVO> daySalesStat(String date) {
		ArrayList<EachProductSalesVO> epsList = new ArrayList<EachProductSalesVO>();
		
		try {
			String sql = "SELECT pr_code, pr_name, sum(amount) AS amount, sum(sales) AS sales\r\n" + 
					"FROM ordr_view WHERE odr_date = ? GROUP BY pr_code ORDER BY sales DESC";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, date);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String pr_code = rs.getString(1);
				String pr_name = rs.getString(2);
				String amount = rs.getString(3);
				String sales = rs.getString(4);
				EachProductSalesVO e = new EachProductSalesVO(pr_code, pr_name, amount, sales);
				epsList.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return epsList;
	}
	
	
	//모든 매출을 일별로(날짜, 매출) 배열로 반환 
	@Override
	public ArrayList<SalesByDateDTO> selectAll() {
		ArrayList<SalesByDateDTO> slist = null;
		try {
			String sql = "SELECT * FROM sales_date";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			slist = new ArrayList<SalesByDateDTO>();
			while (rs.next()) {
				String date = rs.getString(1);
				int salesInt = rs.getInt(2);
				NumberFormat nf = NumberFormat.getInstance();
				String sales = nf.format(salesInt);
				SalesByDateDTO sbd = new SalesByDateDTO(date, sales);
				slist.add(sbd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return slist;
	}

}
