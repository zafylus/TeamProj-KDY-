package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBcon;
import vo.DailySaleVO;

public class SaleDAO {
	private DBcon dbcon;
	private Date startDate;
	private Date endDate;

	public SaleDAO(Date startDate, Date endDate) {
		dbcon = new DBcon();
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	// 실질 기간 별 매출 (달력 파트)
	public int getRealTotalSales() {
		String totalSalesQuery = "SELECT SUM(pr_pay) AS total_pay " + "FROM sale_view "
				+ "WHERE sa_date BETWEEN ? AND ?";
		try {
			PreparedStatement pstmt = dbcon.con.prepareStatement(totalSalesQuery);
			pstmt.setDate(1, startDate);
			pstmt.setDate(2, endDate);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				return rs.getInt("total_pay");
			}

			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	
	
	// 일별 매출(달력 파트)
	public List<DailySaleVO> getDailySales() {
		List<DailySaleVO> saleDailyList = new ArrayList<>(); 
		String dailyTotalSalesQuery = "SELECT sa_date, SUM(pr_pay) AS pr_pay " 
		+ "FROM sale_view "
		+ "WHERE sa_date BETWEEN ? AND ? "
		+ "AND pr_price > 0 " 
		+ "GROUP BY sa_date";
		try {
			PreparedStatement pstmt = dbcon.con.prepareStatement(dailyTotalSalesQuery);
			pstmt.setDate(1, startDate);
			pstmt.setDate(2, endDate);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				DailySaleVO daily = new DailySaleVO();
				daily.setDate(rs.getDate("sa_date"));
				daily.setDailySale(rs.getInt("pr_pay"));
				saleDailyList.add(daily);
			}

			rs.close();
			pstmt.close();

			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return saleDailyList;
	}
	
	// 기간 별 매출 (분석 파트)
		public int getTotalSales() {
			String totalSalesQuery = "SELECT SUM(pr_pay) AS total_pay " + "FROM sale_view "
					+ "WHERE sa_date BETWEEN ? AND ? " + "AND pr_price > 0";
			try {
				PreparedStatement pstmt = dbcon.con.prepareStatement(totalSalesQuery);
				pstmt.setDate(1, startDate);
				pstmt.setDate(2, endDate);
				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
					return rs.getInt("total_pay");
				}

				rs.close();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			return 0;
		}

	// 기간 별 매출 건수(분석 파트)
	public int getSaleCount() {

		String saleCountQuery = "SELECT COUNT(sa_no) AS sa_cnt " + "FROM sale_view " + "WHERE sa_date BETWEEN ? AND ? "
				+ "AND pr_price > 0";
		try {
			PreparedStatement pstmt = dbcon.con.prepareStatement(saleCountQuery);
			pstmt.setDate(1, startDate);
			pstmt.setDate(2, endDate);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				return rs.getInt("sa_cnt");
			}

			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}
	

	// 기간 별 평균 결제 금액 (분석 파트)
	public int getAveragePayment() {
		String averagePayQuery = "SELECT CAST(AVG(pr_pay) AS INT) AS pr_avg " + "FROM ( "
				+ "    SELECT sa_no, SUM(pr_pay) AS pr_pay " + "    FROM sale_view "
				+ "    WHERE sa_date BETWEEN ? AND ? " + "      AND pr_price > 0 " + "    GROUP BY sa_no "
				+ ") AS subquery";
		try {
			PreparedStatement pstmt = dbcon.con.prepareStatement(averagePayQuery);
			pstmt.setDate(1, startDate);
			pstmt.setDate(2, endDate);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				return rs.getInt("pr_avg");
			}

			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}



	// 기간 별 총 환불 금액(공통)
	public int getTotalRefunds() {
		int totalRefunds = 0;

		String totalRefundsQuery = "SELECT SUM(pr_pay) AS pr_pay " + "FROM sale_view "
				+ "WHERE sa_date BETWEEN ? AND ? " + "AND pr_price < 0";

		try {
			PreparedStatement pstmt = dbcon.con.prepareStatement(totalRefundsQuery);
			pstmt.setDate(1, startDate);
			pstmt.setDate(2, endDate);
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

	// 환불 횟수 (분석 파트)
	public int getRefundCount() {
		int refundCount = 0;

		String refundCountQuery = "SELECT COUNT(sa_no) AS sa_cnt " + "FROM sale_view "
				+ "WHERE sa_date BETWEEN ? AND ? " + "AND pr_price < 0";

		try {
			PreparedStatement pstmt = dbcon.con.prepareStatement(refundCountQuery);
			pstmt.setDate(1, startDate);
			pstmt.setDate(2, endDate);
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

	// 평균 환불 금액 (분석 파트)
	public int getAverageRefund() {
		int averageRefund = 0;

		String averageRefundQuery = "FROM ( " +
				"    SELECT sa_no, SUM(pr_pay) AS pr_pay " +
				"    FROM sale_view " +
				"    WHERE sa_date BETWEEN ? AND ? " +
				"      AND pr_price < 0 " +
				"    GROUP BY sa_no " +
				") AS Subquery";

		try {
			PreparedStatement pstmt = dbcon.con.prepareStatement(averageRefundQuery);
			pstmt.setDate(1, startDate);
			pstmt.setDate(2, endDate);
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
