package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import DButil.DBcon;
import dto.EmployeeDTO;
import dto.ExpenseDTO;

public class EmployeeDAO implements IERP_DAO{

	@Override
	public boolean insert(Object dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		EmployeeDTO emp = (EmployeeDTO)dto;
		boolean flag = false;
		
		String query = "INSERT INTO employee (e_name, e_position, e_joinDate) VALUE (?, ?, ?)";
		
		try {
			con = DBcon.getConn();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, emp.getE_name());
			pstmt.setString(2,emp.getE_position());
			pstmt.setDate(3, Date.valueOf(emp.getE_joinDate()));
			int result = pstmt.executeUpdate();
			
			if (result == 1)
				flag = true;
		} catch (Exception e) {
			System.out.println("직원 입력 실패 : " + e.getMessage());
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(con != null)
					con.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패 : " + e.getMessage());
			}
		}
		return flag;
	}

	@Override
	public List<Object> getData() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Object> list = new ArrayList<>();
		
		String query = "SELECT * FROM employee";
		
		try {
			con = DButil.DBcon.getConn();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if( rs != null ) {
					int e_no = rs.getInt("e_no");
					String e_name = rs.getString("e_name");
					String e_position = rs.getString("e_position");
					LocalDate e_joinDate = rs.getDate("e_joinDate").toLocalDate();
					EmployeeDTO dto = new EmployeeDTO(e_no, e_name, e_position, e_joinDate);
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
		return false;
	}


	@Override
	public boolean delete(Object dto) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
