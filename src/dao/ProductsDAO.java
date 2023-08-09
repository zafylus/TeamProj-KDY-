package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.ProductDTO;
import dto.RecipeDTO;

public class ProductsDAO implements IERP_DAO {
	
	@Override
	public boolean insert(Object dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Object> getData() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Object> list = new ArrayList<>();
		
		
		String query = "SELECT * FROM product";
		
		try {
			con = db.DBcon.getConn();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if (rs != null) {
				while(rs.next()) {
					ProductDTO dto = new ProductDTO();
					dto.setPr_code(rs.getString("pr_code"));
					dto.setPr_name(rs.getString("pr_name"));
					dto.setPr_price(rs.getInt("pr_price"));
					dto.setPr_ctgry(rs.getString("pr_ctgry"));
					list.add(dto);
				}
			}
			
		} catch (Exception e) {
			System.out.println("상품 리스트 반환 실패 : " + e.getMessage());
			
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패 : " + e.getMessage());
			}
		}
		return list;
	}

	@Override
	public boolean update(Object dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object dto) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public List<RecipeDTO> getRecipeList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RecipeDTO> rlist = new ArrayList<>();
		
		String query = "SELECT * FROM recipe";
		
		try {
			con = db.DBcon.getConn();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RecipeDTO dto = new RecipeDTO();
				dto.setPr_code(rs.getString("pr_code"));
				dto.setMa001(rs.getDouble("ma001"));
				dto.setMa002(rs.getDouble("ma002"));
				dto.setMa003(rs.getDouble("ma003"));
				rlist.add(dto);
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
		return rlist;
	}

}
