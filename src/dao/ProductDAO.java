package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Coffee;
import dto.Product;

//상품 관리 DAO
public class ProductDAO implements SelectDAO{
	
	//상품등록
	public void regist(Product p) {
		String sql = "INSERT INTO product VALUES (?, ?, ?, ?)";
		PreparedStatement stmt = null;

		try {
			String prodno = plusProdno(p.getCategory());
			String prodname = p.getProdname();
			int price = p.getPrice();
			String category = p.getCategory();
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, prodno);
			stmt.setString(2, prodname);
			stmt.setInt(3, price);
			stmt.setString(4, category);
			
			stmt.executeUpdate();
			System.out.println("ProductDAO Regist Success");
		} catch (SQLException e1) {
			System.out.println("ProducDAO insert method sql is wrong");
			e1.printStackTrace();
		}
	}
	
	//전체 상품 목록 조회
	@Override
	public ArrayList<Product> selectAll() {
		ArrayList<Product> plist = null;
		try {
			plist = new ArrayList<Product>();
			String sql = "SELECT * FROM product";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				String prodno = rs.getString(1);
				String prodname = rs.getString(2);
				int price = rs.getInt(3);
				String category = rs.getString(4);
				Product p = new Coffee(prodno, price, prodname, category);
				plist.add(p);
			}
		} catch (SQLException e) {
			System.out.println("상품등록 SQL 구문 오류");
			e.printStackTrace();
		}
		
		return plist;
	}
	
	//Update
	public void updateProduct(Product p) {
		String sql = "UPDATE product SET pr_name = ?, pr_price = ?, pr_ctgry = ? WHERE pr_code = ?;";
		PreparedStatement stmt = null;

		try {
			String prodname = p.getProdname();
			int price = p.getPrice();
			String category = p.getCategory();
			String prodno = p.getProd_no();
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, prodname);
			stmt.setInt(2, price);
			stmt.setString(3, category);
			stmt.setString(4, prodno);
			
			stmt.executeUpdate();
			System.out.println("ProductDAO Update Success");
		} catch (SQLException e1) {
			System.out.println("ProducDAO update method sql 구문 오류");
			e1.printStackTrace();
		}
	}
	
	//Delete
	public void deleteProduct(String prodno) {
		String sql = "DELETE from product WHERE pr_code = ?;";
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, prodno);
			stmt.executeUpdate();
			System.out.println("ProductDAO Delete Success");
		} catch (SQLException e1) {
			System.out.println("ProducDAO delete method sql 구문 오류");
			e1.printStackTrace();
		}
	}
		
	//카테고리별 최대 상품번호 등록
	private String getMaxProdno(String category) {
		String maxNo = null;
		
		try {
			String sql = "SELECT MAX(pr_code) FROM product WHERE pr_ctgry = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, category);
			ResultSet rs = stmt.executeQuery();
	
			if (rs.next()) {
				maxNo = rs.getString(1);
			}else {
				System.out.println("카테고리에 해당되는 상품 목록이 없습니다");
			}
		}
		catch (SQLException e) {
			System.out.println("상품등록 SQL 구문 오류");
			e.printStackTrace();
		
		} 
		return maxNo;
	}
	
	
	// 상품번호 +1
	private String plusProdno(String category) {
		String prodno = null;
		String maxNo = getMaxProdno(category);
		int no = Integer.parseInt(maxNo.substring(2))+1;
		String temp = ""+no;
		
		switch(temp.length()) {
			case 1:
				prodno = maxNo.substring(0, 2)+"00"+no;
				break;
			case 2:
				prodno = maxNo.substring(0, 2)+"0"+no;
				break;
			case 3:
				prodno = maxNo.substring(0, 2)+no;
				break;
			default:
				System.out.println("상품번호가 1000 이상입니다");
				break;
		}
		
		return prodno;
	}

}
