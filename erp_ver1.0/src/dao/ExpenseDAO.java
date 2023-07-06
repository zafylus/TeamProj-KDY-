package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import DButil.DBcrud;
import dto.ExpenseDTO;

public class ExpenseDAO implements DBcrud{

	@Override
	public boolean insert(Object dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ExpenseDTO expense = (ExpenseDTO)dto;
		boolean flag = false;
		
		String query = "INSERT INTO expense VALUE (null, ?, ?, ?, ?, ?)";
				
		try {
			con = DButil.DBcon.getConn();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, expense.getMa_code());
			pstmt.setInt(2, expense.getEx_cost());
			pstmt.setInt(3, expense.getEx_ea());
			pstmt.setTimestamp(4, Timestamp.valueOf(expense.getEx_date()));
			pstmt.setString(5, expense.getEx_note());
			int result = pstmt.executeUpdate();
			
			if (result ==1 )
				flag = true;
			
		} catch (Exception e) {
			System.out.println("입력 실패 : " + e.getMessage());
		} finally {
			try {
				if (pstmt != null) 
					pstmt.close();
				if (con != null) 
					con.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패 : " + e.getMessage());
			}
		}
		return flag;
	}

	@Override
	public List<Object> getData(int p) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Object> list = new ArrayList<>();
		
		String query = "SELECT * FROM expense";
		
		try {
			con = DButil.DBcon.getConn();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if( rs != null ) {
					ExpenseDTO dto = new ExpenseDTO();
					dto.setEx_no(rs.getInt("ex_no"));
					dto.setMa_code(rs.getString("ma_code"));
					dto.setEx_cost(rs.getInt("ex_cost"));
					dto.setEx_ea(rs.getInt("ex_ea"));
					dto.setEx_date(rs.getTimestamp("ex_date").toLocalDateTime());
					dto.setEx_note(rs.getNString("ex_note"));
					list.add(dto);
				}
			}
		} catch (Exception e) {
			System.out.println("데이터 반환 실패 : " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패 : " + e.getMessage());
			}
		}
		return list;
	}

	@Override
	public boolean update(Object dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ExpenseDTO expense = (ExpenseDTO)dto;
		boolean flag = false;
		
		String query = "UPDATE expense SET ma_code = ?, ex_cost = ?, ex_ea = ?, ex_date = ? "
							+ "WHERE ex_no = ?";
		
		try {
			con = DButil.DBcon.getConn();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, expense.getMa_code());
			pstmt.setInt(2, expense.getEx_cost());
			pstmt.setInt(3, expense.getEx_ea());
			pstmt.setTimestamp(4, Timestamp.valueOf(expense.getEx_date()));
			pstmt.setInt(5, expense.getEx_no());
			int result = pstmt.executeUpdate();
			
			if ( result == 1)
				flag = true;
			
		} catch (Exception e) {
			System.out.println("업데이트 실패 : " + e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패 : " + e.getMessage());
			}
		}
		return flag;
	}

	@Override
	public boolean dalete(Object dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ExpenseDTO expense = (ExpenseDTO)dto;
		boolean flag = false;
		
		String query = "DELETE FROM expense WHERE ex_no = ?";
		
		try {
			con = DButil.DBcon.getConn();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, expense.getEx_no());
			int result = pstmt.executeUpdate();
			
			if (result == 1) 
				flag = true;
			
		} catch (Exception e) {
			System.out.println("삭제 실패 : " + e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패 : " + e.getMessage());
			}
		}
		return flag;
	}
	
	// 특정 날짜 사이의 지출 리스트 반환
	public List<ExpenseDTO> getDateData(String date1, String date2) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ExpenseDTO> list = new ArrayList<>();
		
		String query = "SELECT * FROM expense WHERE date(ex_date) BETWEEN ? AND ?;";
		
		try {
			con = DButil.DBcon.getConn();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, date1);
			pstmt.setString(2, date2);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if( rs != null ) {
					ExpenseDTO dto = new ExpenseDTO();
					dto.setEx_no(rs.getInt("ex_no"));
					dto.setMa_code(rs.getString("ma_code"));
					dto.setEx_cost(rs.getInt("ex_cost"));
					dto.setEx_ea(rs.getInt("ex_ea"));
					dto.setEx_date(rs.getTimestamp("ex_date").toLocalDateTime());
					dto.setEx_note(rs.getNString("ex_note"));
					list.add(dto);
				}
			}
		} catch (Exception e) {
			System.out.println("데이터 반환 실패 : " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패 : " + e.getMessage());
			}
		}
		return list;
	}
}
