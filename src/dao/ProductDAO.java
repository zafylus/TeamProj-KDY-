package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.RecipeDTO;

public class ProductDAO {
	
	public List<RecipeDTO> getRecipeList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RecipeDTO> rlist = new ArrayList<>();
		
		String query = "SELECT p.pr_name, r.ma001, r.ma002, r.ma003 "
							+ "FROM recipe r, product p "
							+ "WHERE r.pr_code = p.pr_code";
		
		try {
			con = DButil.DBcon.getConn();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if( rs != null ) {
					RecipeDTO dto = new RecipeDTO();
					dto.setPr_code(rs.getString("p.pr_name"));
					dto.setMa001(rs.getDouble("r.ma001"));
					dto.setMa002(rs.getDouble("r.ma002"));
					dto.setMa003(rs.getDouble("r.ma003"));
					rlist.add(dto);
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
		return rlist;
	}
		
}
