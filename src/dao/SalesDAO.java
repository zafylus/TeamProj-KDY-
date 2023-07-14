package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;

import dto.EachProductSalesVO;
import dto.SalesByDateDTO;

//상품 관리 DAO
public class SalesDAO implements SelectDAO{
	
	//월별 매출
	public int monthSales(String yearMonth){
		int sales = 0;
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
	
	//일자별 상품 정보
	public ArrayList<EachProductSalesVO> daySalesStat(String date) {
		ArrayList<EachProductSalesVO> epsList = new ArrayList<EachProductSalesVO>();
		String startDate = date + " 00:00:00";
		String endDate = date + " 23:59:59";
		
		try {
			String sql = "SELECT pr_code, pr_name, sum(amount) AS amount, sum(sales) AS sales\r\n" + 
					"FROM ordr_view\r\n" + 
					"WHERE odr_date BETWEEN ? and ? \r\n" + 
					"GROUP BY pr_code\r\n" + 
					"ORDER BY sales DESC";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, startDate);
			stmt.setString(2, endDate);
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
	
	//일자별 매출
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
