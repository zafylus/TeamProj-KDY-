package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import db.DBcon;
import vo.DateBeginEnd;
import vo.SaleCategoryVO;
import vo.SaleTop3VO;

public class ProductSaleDAO {
	private DBcon dbcon;

	public ProductSaleDAO() {
		dbcon = new DBcon();
	}

	public List<SaleTop3VO> getTop3(DateBeginEnd date) {
		List<SaleTop3VO> top3List = new ArrayList<>();
		LocalDate startLocalDate = date.getBeginPeriod();
		LocalDate endLocalDate = date.getEndPeriod();
		
		Date startDate = Date.valueOf(startLocalDate);
		Date endDate = Date.valueOf(endLocalDate);
		
		System.out.println("StartDate" + startDate);
		System.out.println("EndDate" + endDate);

		try {
			String sql = "	SELECT pr_name, COUNT(pr_no) * pr_ea AS COUNT, COUNT(pr_no) * pr_ea * pr_price  AS pay\r\n" + 
					"	FROM sale_view\r\n" + 
					"	WHERE sa_date BETWEEN '2023-07-' AND '2023-07-21'\r\n" + 
					"	  AND pr_price > 0\r\n" + 
					"	GROUP BY pr_no\r\n" + 
					"	ORDER BY COUNT(pr_no) * pr_ea DESC\r\n" + 
					"	LIMIT 3;";

			PreparedStatement pstmt = dbcon.con.prepareStatement(sql);
			pstmt.setDate(1, startDate);
			pstmt.setDate(2, endDate);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String prName = rs.getString("pr_name");
				int count = rs.getInt("COUNT");
				int pay = rs.getInt("pay");

				SaleTop3VO productSale = new SaleTop3VO(prName, count, pay);
				top3List.add(productSale);
			}

			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return top3List;
	}

	public List<SaleCategoryVO> getCategoryOrder(DateBeginEnd date) {
		List<SaleCategoryVO> categoryOrderList = new ArrayList<>();
		
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

				SaleCategoryVO productSale = new SaleCategoryVO(category, count);
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
	public int getTotalProductSale(DateBeginEnd date) {
	    int totalCount = 0;
	    
	    LocalDate startLocalDate = date.getBeginPeriod();
	    LocalDate endLocalDate = date.getEndPeriod();
	    
	    Date startDate = Date.valueOf(startLocalDate);
	    Date endDate = Date.valueOf(endLocalDate);

	    try {
	        String sql = "SELECT COUNT(pr_no) * pr_ea AS cnt " +
	                     "FROM sale_view " +
	                     "WHERE sa_date BETWEEN ? AND ? " +
	                     "AND pr_price > 0";

	        PreparedStatement pstmt = dbcon.con.prepareStatement(sql);
	        pstmt.setDate(1, startDate);
	        pstmt.setDate(2, endDate);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            totalCount = rs.getInt("cnt");
	        }

	        rs.close();
	        pstmt.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return totalCount;
	}
}
