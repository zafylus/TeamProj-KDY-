package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.SalesByDateDTO;

public class SalesDAO implements SelectDAO{
	
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
				int sales = rs.getInt(2);
				SalesByDateDTO sbd = new SalesByDateDTO(date, sales);
				slist.add(sbd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return slist;
	}

}
