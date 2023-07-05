package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import db.DBcon;
import vo.DateBeginEnd;
import vo.ProductSaleVO;

public class ProductSaleDAO {
	private DBcon dbcon;

	public ProductSaleDAO() {
		dbcon = new DBcon();
	}

	public List<ProductSaleVO> getTop3(DateBeginEnd date) {
		List<ProductSaleVO> top3List = new ArrayList<>();
		LocalDate startLocalDate = date.getBeginPeriod();
		LocalDate endLocalDate = date.getEndPeriod();
		
		Date startDate = Date.valueOf(startLocalDate);
		Date endDate = Date.valueOf(endLocalDate);

		try {
			String sql = "SELECT pr_name, COUNT(pr_no) * pr_ea AS COUNT "
					+ "FROM sale_view "
					+ "WHERE sa_date BETWEEN ? AND ? "
					+ "AND pr_price > 0 "
					+ "GROUP BY pr_no "
					+ "ORDER BY COUNT(pr_no) * pr_ea DESC "
					+ "LIMIT 3";

			PreparedStatement pstmt = dbcon.con.prepareStatement(sql);
			pstmt.setDate(1, startDate);
			pstmt.setDate(2, endDate);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String prName = rs.getString("pr_name");
				int count = rs.getInt("COUNT");

				ProductSaleVO productSale = new ProductSaleVO(prName, "", count);
				top3List.add(productSale);
			}

			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return top3List;
	}

	public List<ProductSaleVO> getCategoryOrder(DateBeginEnd date) {
		List<ProductSaleVO> categoryOrderList = new ArrayList<>();
		
		LocalDate startLocalDate = date.getBeginPeriod();
		LocalDate endLocalDate = date.getEndPeriod();
		
		Date startDate = Date.valueOf(startLocalDate);
		Date endDate = Date.valueOf(endLocalDate);

		try {
			String sql = "SELECT "
					+ "CASE WHEN CAST(SUBSTRING(pr_no, 3) AS INT) <= 500 THEN '커피' "
					+ "     WHEN CAST(SUBSTRING(pr_no, 3) AS INT) >= 501 THEN '디저트' "
					+ "END AS category, "
					+ "COUNT(*) AS count "
					+ "FROM sale "
					+ "WHERE sa_date BETWEEN ? AND ? "
					+ "AND pr_price > 0 "
					+ "GROUP BY category";

			PreparedStatement pstmt = dbcon.con.prepareStatement(sql);
			pstmt.setDate(1, startDate);
			pstmt.setDate(2, endDate);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String category = rs.getString("category");
				int count = rs.getInt("count");

				ProductSaleVO productSale = new ProductSaleVO("", category, count);
				categoryOrderList.add(productSale);
			}

			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return categoryOrderList;
	}

	public void close() {
		dbcon.close();
	}
}
