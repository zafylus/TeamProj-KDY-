package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import dto.OrderListVO;

//주문 DAO
public class OrderDAO implements ISelectDAO{
	private PreparedStatement stmt = null;
	
	//주문등록
	public int regist() {
		String sql = "INSERT INTO order_tbl (odr_code) VALUES\r\n" + 
				"(?)";
		int res = 0;
		try {
			String prodno = plusOdrCode();
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, prodno);
			res = stmt.executeUpdate();
			System.out.println("OrderDAO Regist Success");
		} catch (SQLException e1) {
			System.out.println("OrderDAO insert method sql 구문 잘못됌");
			e1.printStackTrace();
		}
		
		return res;
	}
	
	//주문 상세 등록
	public void registOrderList(OrderListVO olVO, String odr_code) {
		String sql = "INSERT INTO orderlist (odr_code, pr_code, amount) values\r\n" + 
				"(?, ?, ?)";
	
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, odr_code);
			stmt.setString(2, olVO.getPr_code());
			stmt.setInt(3, olVO.getAmount());
			stmt.executeUpdate();
			System.out.println("OrderDAO registOrder Success");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	// 주문 목록 조회
	@Override
	public Map<String, Timestamp> selectAll() {
		Map<String, Timestamp> orderList = null;
		try {
			orderList = new LinkedHashMap<String, Timestamp>();
			String sql = "SELECT * FROM order_tbl ORDER BY odr_code DESC;";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				String odr_code = rs.getString(1);
				Timestamp odr_date = rs.getTimestamp(2);
				orderList.put(odr_code, odr_date);
			}
		} catch (SQLException e) {
			System.out.println("상품등록 SQL 구문 오류");
			e.printStackTrace();
		}
		
		return orderList;
	}
	
	//주문상세 목록 조회
	public ArrayList<OrderListVO> selectAllOrderList(){
		ArrayList<OrderListVO> olist = null;
		try {
			olist = new ArrayList<OrderListVO>();
			String sql = "SELECT * FROM orderlist ORDER BY odr_no desc";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				String odr_no = rs.getString(1);
				String odr_code = rs.getString(2);
				String pr_code = rs.getString(3);
				int amount = rs.getInt(4);
				OrderListVO oVo = new OrderListVO(odr_no, odr_code, pr_code, amount);
				olist.add(oVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return olist;
	}
	
	//최대 주문번호 등록
		public String getMaxOdrCode() {
			String maxNo = null;
			
			try {
				String sql = "SELECT MAX(odr_code) FROM order_tbl;";
				stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
		
				if (rs.next()) {
					maxNo = rs.getString(1);
				}
			}
			catch (SQLException e) {
				System.out.println("상품등록 SQL 구문 오류");
				e.printStackTrace();
			
			} 
			return maxNo;
		}
	
	// 주문번호 +1
		private String plusOdrCode() {
			String odr_code = null;
			String maxNo = getMaxOdrCode();
			int no = Integer.parseInt(maxNo.substring(2))+1;
			String strNo = ""+no;
			odr_code = maxNo.substring(0, 2);
			for (int i = 0; i < 3-strNo.length(); i++) {
				odr_code += "0";
			}
			odr_code += no;
			System.out.println(odr_code);
			return odr_code;
		}
}
