package erp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SaleDAO {

	public ArrayList<SaleVO> getMonth() {
		ArrayList<SaleVO> slist = new ArrayList<>();
		Connection conn;
		try {
			conn = DBcon.getConnection();
			String query = "SELECT * from month;";
			PreparedStatement pstt = conn.prepareStatement(query);
			ResultSet rs = pstt.executeQuery();
			while(rs.next()) {
				SaleVO s = new SaleVO();
				s.setDate(rs.getInt("date"));
				s.setSale(rs.getInt("sale"));
				s.setMargin(rs.getInt("margin"));
				s.setCost(rs.getInt("cost"));
				s.setIncome(rs.getInt("income"));
				slist.add(s);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return slist;
	}
	public ArrayList<SaleVO> getDay() {
		ArrayList<SaleVO> slist = new ArrayList<>();
		Connection conn;
		try {
			conn = DBcon.getConnection();
			String query = "SELECT DATE, sale, income FROM month;";
			PreparedStatement pstt = conn.prepareStatement(query);
			ResultSet rs = pstt.executeQuery();
			while(rs.next()) {
				SaleVO s = new SaleVO();
				s.setDate(rs.getInt("date"));
				s.setSale(rs.getInt("sale"));
				s.setIncome(rs.getInt("income"));
				slist.add(s);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return slist;
	}
}
