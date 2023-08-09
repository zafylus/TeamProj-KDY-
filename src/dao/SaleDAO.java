package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.sale.saleCalendar.DailySaleVO;

public class SaleDAO {
	private Connection con;
	private Date startDate;
	private Date endDate;

	public SaleDAO(Date startDate, Date endDate) {
		con = db.DBcon.getConn();
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	// 실질 기간 별 매출 (달력 파트)
	public int getRealTotalSales() {
		String totalSalesQuery = "SELECT SUM(sales) AS total_pay " + "FROM ordr_view "
				+ "WHERE odr_date BETWEEN ? AND ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(totalSalesQuery);
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
		String dailyTotalSalesQuery = "SELECT odr_date, SUM(sales) AS sales " 
		+ "FROM ordr_view "
		+ "WHERE odr_date BETWEEN ? AND ? "
		+ "AND pr_price > 0 " 
		+ "GROUP BY odr_date";
		try {
			PreparedStatement pstmt = con.prepareStatement(dailyTotalSalesQuery);
			pstmt.setDate(1, startDate);
			pstmt.setDate(2, endDate);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				DailySaleVO daily = new DailySaleVO();
				daily.setDate(rs.getDate("odr_date"));
				daily.setDailySale(rs.getInt("sales"));
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
			String totalSalesQuery = "SELECT SUM(sales) AS total_pay " + "FROM ordr_view "
					+ "WHERE odr_date BETWEEN ? AND ? " + "AND pr_price > 0";
			try {
				PreparedStatement pstmt = con.prepareStatement(totalSalesQuery);
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

		String saleCountQuery = "SELECT COUNT(odr_no) AS sa_cnt " + "FROM ordr_view " + "WHERE odr_date BETWEEN ? AND ? "
				+ "AND pr_price > 0";
		try {
			PreparedStatement pstmt = con.prepareStatement(saleCountQuery);
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
		String averagePayQuery = "SELECT CAST(AVG(sales) AS INT) AS pr_avg " + "FROM ( "
				+ "    SELECT odr_no, SUM(sales) AS sales " + "    FROM ordr_view "
				+ "    WHERE odr_date BETWEEN ? AND ? " + "      AND pr_price > 0 " + "    GROUP BY odr_no "
				+ ") AS subquery";
		try {
			PreparedStatement pstmt = con.prepareStatement(averagePayQuery);
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

		String totalRefundsQuery = "SELECT SUM(sales) AS sales " + "FROM ordr_view "
				+ "WHERE odr_date BETWEEN ? AND ? " + "AND pr_price < 0";

		try {
			PreparedStatement pstmt = con.prepareStatement(totalRefundsQuery);
			pstmt.setDate(1, startDate);
			pstmt.setDate(2, endDate);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				totalRefunds = rs.getInt("sales");
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

		String refundCountQuery = "SELECT COUNT(odr_no) AS sa_cnt " + "FROM ordr_view "
				+ "WHERE odr_date BETWEEN ? AND ? " + "AND pr_price < 0";

		try {
			PreparedStatement pstmt = con.prepareStatement(refundCountQuery);
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

		String averageRefundQuery = "	SELECT CAST(AVG(sales) AS INT) AS pr_avg\r\n" + 
				"	FROM (\r\n" + 
				"    SELECT odr_no, SUM(sales) AS sales\r\n" + 
				"    FROM ordr_view\r\n" + 
				"    WHERE odr_date BETWEEN ? AND ?\r\n" + 
				"      AND pr_price < 0\r\n" + 
				"    GROUP BY odr_no\r\n" + 
				"	) AS subquery";

		try {
			PreparedStatement pstmt = con.prepareStatement(averageRefundQuery);
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

	public void close() throws Exception {
		con.close();
	}
}
