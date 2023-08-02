package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DButil.DBcon;
import dto.FixedCostDTO;

public class FixedCostDAO implements IERP_DAO{

	@Override
	public boolean insert(Object dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		FixedCostDTO cost = (FixedCostDTO) dto;
		
		String query = "INSERT INTO fixedcost VALUE (?, ? ,?)";
		
		try {
			con = DBcon.getConn();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, cost.getFi_name());
			pstmt.setInt(2, cost.getFi_cost() );
			pstmt.setInt(3, cost.getFi_date());
			int result = pstmt.executeUpdate();
			if (result == 1 )
				flag = true;
		} catch (Exception e) {
			System.out.println("고정비 입력 실패 : " + e.getMessage());
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
		
		String query = "SELECT * FROM fixedcost";
		
		try {
			con = DButil.DBcon.getConn();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if( rs != null ) {
					FixedCostDTO dto = new FixedCostDTO();
					dto.setFi_name(rs.getString("fi_name"));
					dto.setFi_cost(rs.getInt("fi_cost"));
					dto.setFi_date(rs.getInt("fi_date"));
					list.add(dto);
				}
			}
		} catch (Exception e) {
			System.out.println("고정비 리스트 반환 실패 : " + e.getMessage());
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
		FixedCostDTO cost = (FixedCostDTO)dto;
		boolean flag = false;
		
		String query = "UPDATE FROM fixedcost SET fi_cost=?, fi_date=? WHERE fi_name=?";
		
		try {
			con = DBcon.getConn();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cost.getFi_cost());
			pstmt.setInt(2, cost.getFi_date());
			pstmt.setString(3, cost.getFi_name());
			int result = pstmt.executeUpdate();
			
			if (result == 1 )
				flag = true;
		} catch (Exception e) {
			System.out.println("고정비 수정 실패 : " + e.getMessage());
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
		FixedCostDTO cost = (FixedCostDTO)dto;
		boolean flag = false;
		
		String query = "DELETE FROM fixedcost WHERE fi_name=?";
		
		try {
			con = DBcon.getConn();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, cost.getFi_name());
			int result = pstmt.executeUpdate();
			
			if (result ==1)
				flag = true;
			
		} catch (Exception e) {
			System.out.println("고정비 삭제 실패 : " +e.getMessage());
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
	
}
