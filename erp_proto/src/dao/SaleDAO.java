package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBcon;
import vo.SaleVO;

public class SaleDAO {
	private DBcon dbcon;

	public SaleDAO() {
		dbcon = new DBcon();
	}

	public SaleVO getSaleAnalysis(String startDate, String endDate) {
		SaleVO saleAnalysis = new SaleVO();

		// Total Sales
		String totalSalesQuery = "SELECT SUM(pr_pay) AS total_pay "
				+ "FROM sale_view "
				+ "WHERE sa_date BETWEEN ? AND ? "
				+ "AND pr_price > 0";
		try {
			PreparedStatement pstmt = dbcon.con.prepareStatement(totalSalesQuery);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				saleAnalysis.setTotalSale(rs.getInt("total_pay"));
			}

			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Total Sale Count
		String saleCountQuery = "SELECT COUNT(sa_no) AS sa_cnt "
				+ "FROM sale_view "
				+ "WHERE sa_date BETWEEN ? AND ? "
				+ "AND pr_price > 0";
		try {
			PreparedStatement pstmt = dbcon.con.prepareStatement(saleCountQuery);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				saleAnalysis.setSaleCnt(rs.getInt("sa_cnt"));
			}

			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Average Payment
		String averagePayQuery = "SELECT CAST(AVG(pr_pay) AS INT) AS pr_avg "
				+ "FROM ( "
				+ "    SELECT sa_no, SUM(pr_pay) AS pr_pay "
				+ "    FROM sale_view "
				+ "    WHERE sa_date BETWEEN ? AND ? "
				+ "      AND pr_price > 0 "
				+ "    GROUP BY sa_no "
				+ ") AS subquery";
		try {
			PreparedStatement pstmt = dbcon.con.prepareStatement(averagePayQuery);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				saleAnalysis.setAvgPay(rs.getInt("pr_avg"));
				saleAnalysis.setAvgPay(rs.getInt("pr_avg"));
			}

			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Daily Total Sales
		String dailyTotalSalesQuery = "SELECT sa_date, SUM(pr_pay) AS pr_pay "
				+ "FROM sale_view "
				+ "WHERE sa_date BETWEEN ? AND ? "
				+ "AND pr_price > 0 "
				+ "GROUP BY sa_date";
		try {
			PreparedStatement pstmt = dbcon.con.prepareStatement(dailyTotalSalesQuery);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			ResultSet rs = pstmt.executeQuery();

			int dayTotalSale = 0;
			while (rs.next()) {
				dayTotalSale += rs.getInt("pr_pay");
			}

			saleAnalysis.setDayTotalSale(dayTotalSale);

			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return saleAnalysis;
	}
	public int getTotalRefunds(String startDate, String endDate) {
	    int totalRefunds = 0;

	    String totalRefundsQuery = "SELECT SUM(pr_pay) AS pr_pay "
	            + "FROM sale_view "
	            + "WHERE sa_date BETWEEN ? AND ? "
	            + "AND pr_price < 0";

	    try {
	        PreparedStatement pstmt = dbcon.con.prepareStatement(totalRefundsQuery);
	        pstmt.setString(1, startDate);
	        pstmt.setString(2, endDate);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            totalRefunds = rs.getInt("pr_pay");
	        }

	        rs.close();
	        pstmt.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return totalRefunds;
	}
	public int getRefundCount(String startDate, String endDate) {
	    int refundCount = 0;

	    String refundCountQuery = "SELECT COUNT(sa_no) AS sa_cnt "
	            + "FROM sale_view "
	            + "WHERE sa_date BETWEEN ? AND ? "
	            + "AND pr_price < 0";

	    try {
	        PreparedStatement pstmt = dbcon.con.prepareStatement(refundCountQuery);
	        pstmt.setString(1, startDate);
	        pstmt.setString(2, endDate);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            refundCount = rs.getInt("sa_cnt");
	        }

	        rs.close();
	        pstmt.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return refundCount;
	}
	public int getAverageRefund(String startDate, String endDate) {
	    int averageRefund = 0;

	    String averageRefundQuery = "SELECT CAST(AVG(pr_pay) AS INT) AS pr_avg "
	            + "FROM ( "
	            + "    SELECT sa_no, SUM(pr_pay) AS pr_pay "
	            + "    FROM sale_view "
	            + "    WHERE sa_date BETWEEN ? AND ? "
	            + "      AND pr_price < 0 "
	            + "    GROUP BY sa_no "
	            + ") AS subquery";

	    try {
	        PreparedStatement pstmt = dbcon.con.prepareStatement(averageRefundQuery);
	        pstmt.setString(1, startDate);
	        pstmt.setString(2, endDate);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            averageRefund = rs.getInt("pr_avg");
	        }

	        rs.close();
	        pstmt.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return averageRefund;
	}

	public void close() {
		dbcon.close();
	}
}
