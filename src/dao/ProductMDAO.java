package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Coffee;
import dto.Product;
import dto.RecipeDTO;

//상품 관리 DAO
public class ProductMDAO implements ISelectDAO{
	
	private PreparedStatement stmt = null;
	
	//상품등록
	public int regist(Product p) {
		int res = 0;
		String sql = "INSERT INTO product VALUES (?, ?, ?, ?)";
		try {
			String pr_code = plusProdno(p.getPr_code());
			String pr_name = p.getPr_name();
			int pr_price = p.getPr_price();
			String pr_ctgry = p.getPr_ctgry();
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, pr_code);
			stmt.setString(2, pr_name);
			stmt.setInt(3, pr_price);
			stmt.setString(4, pr_ctgry);
			
			res = stmt.executeUpdate();
			System.out.println("ProductDAO Regist Success");
		} catch (SQLException e1) {
			System.out.println("ProducDAO insert method sql 구문 잘못됌");
			e1.printStackTrace();
		}
		return res;
	}
	
	//레시피 등록
	public int registRecipe(RecipeDTO p) {
		int res = 0;
		String sql = "INSERT INTO recipe VALUES (?, ?, ?, ?)";
		try {
			String pr_code = plusProdno(p.getPr_code());
			double ma001 = p.getMa001();
			double ma002 = p.getMa002();
			double ma003 = p.getMa003();
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, pr_code);
			stmt.setDouble(2, ma001);
			stmt.setDouble(3, ma002);
			stmt.setDouble(4, ma003);
			
			res = stmt.executeUpdate();
			System.out.println("ProductDAO Regist Success");
		} catch (SQLException e1) {
			System.out.println("ProducDAO insert method sql 구문 잘못됌");
			e1.printStackTrace();
		}
		
		return res;
	}
	
	//전체 상품 목록 조회
	@Override
	public ArrayList<dto.ProductInfoDTO> selectAll() {
		ArrayList<dto.ProductInfoDTO> plist = null;
		try {
			plist = new ArrayList<dto.ProductInfoDTO>();
			String sql = "SELECT * FROM prod_info;";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				String pr_code = rs.getString(1);
				String pr_name = rs.getString(2);
				String pr_img = rs.getString(3);
				String pr_ctgry = rs.getString(4);
				int pr_price = rs.getInt(5);
				int total_cost = rs.getInt(6);
				int margin = rs.getInt(7);
				double margin_per = Math.round(rs.getDouble(8)*100)/100.0;
				dto.ProductInfoDTO p = new dto.ProductInfoDTO(pr_code, pr_name, pr_price, pr_ctgry, pr_img, total_cost, margin, margin_per);
				plist.add(p);
			}
		} catch (SQLException e) {
			System.out.println("상품등록 SQL 구문 오류");
			e.printStackTrace();
		}
		
		return plist;
	}
	
	//상품 목록
	public ArrayList<Product> productList_imgX() {
		ArrayList<Product> plist = null;
		try {
			plist = new ArrayList<Product>();
			String sql = "SELECT * FROM product;";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				String pr_code = rs.getString(1);
				String pr_name = rs.getString(2);
				int pr_price = rs.getInt(3);
				String pr_ctgry = rs.getString(4);
				Product p = new Coffee(pr_code, pr_name, pr_price, pr_ctgry);
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
		String sql = "UPDATE product SET prodname = ?, price = ?, "
				+ "category = ? WHERE prodno = ?";
		PreparedStatement stmt = null;

		try {
			String prodname = p.getPr_name();
			int price = p.getPr_price();
			String category = p.getPr_ctgry();
			String prodno = p.getPr_code();
			
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
		String sql = "DELETE from product WHERE prodno = ?;";
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
			String sql = "SELECT MAX(prodno) FROM product WHERE category = ?;";
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
		int no = Integer.parseInt(maxNo.substring(4))+1;
		String temp = ""+no;
		
		switch(temp.length()) {
			case 1:
				prodno = maxNo.substring(0, 4)+"000"+no;
				break;
			case 2:
				prodno = maxNo.substring(0, 4)+"00"+no;
				break;
			case 3:
				prodno = maxNo.substring(0, 4)+"0"+no;
				break;
			case 4:
				prodno = maxNo.substring(0, 4)+no;
				break;
			default:
				System.out.println("상품번호가 10000 이상입니다");
				break;
		}
		
		return prodno;
	}

}
