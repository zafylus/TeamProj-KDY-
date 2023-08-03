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
		String sql = "INSERT INTO product (pr_code, pr_name, pr_price, pr_ctgry) "
				+ "VALUES (?, ?, ?, ?)";
		try {
			String pr_code = p.getPr_code();
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
			String pr_code = p.getPr_code();
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
	public ArrayList<Product> productList(){
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
				String pr_img = rs.getString(5);
				Product p = new Coffee(pr_code, pr_name, pr_price, pr_ctgry, pr_img);
				plist.add(p);
			}
		} catch (SQLException e) {
			System.out.println("상품등록 SQL 구문 오류");
			e.printStackTrace();
		}
		
		return plist;
	}	
	
	//상품 목록 이미지 없이
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
	
	//상품 하나
	public Product productOne(String pr_code){
		Product p = null;
		
		try {
			String sql = "SELECT * FROM product WHERE pr_code = ?;";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, pr_code);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				pr_code = rs.getString("pr_code");
				String pr_name = rs.getString("pr_name");
				int pr_price = rs.getInt("pr_price");
				String pr_ctgry = rs.getString("pr_ctgry");
				String pr_img = rs.getString("pr_img");
				p = new Coffee(pr_code, pr_name, pr_price, pr_ctgry, pr_img);
			}
			
		} catch(SQLException e) {
			System.out.println("상품등록 SQL 구문 오류");
			e.printStackTrace();
		}
		
		return p;
	}	
	
	//레시피 목록
	public ArrayList<RecipeDTO> recipeList(){
		ArrayList<RecipeDTO> rlist = null;
		
		try {
			rlist = new ArrayList<RecipeDTO>();
			String sql = "SELECT * FROM recipe;";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				double ma001 = rs.getDouble(1);
				double ma002 = rs.getDouble(2);
				double ma003 = rs.getDouble(3);
				RecipeDTO r = new RecipeDTO(ma001, ma002, ma003);
				rlist.add(r);
			}
		} catch (SQLException e) {
			System.out.println("상품등록 SQL 구문 오류");
			e.printStackTrace();
		}
		
		return rlist;
	}	
	
	//레시피
	public RecipeDTO recipe(String pr_code){
		RecipeDTO r = null;
		
		try {
			String sql = "SELECT * FROM recipe where pr_code = ?;";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, pr_code);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				rs.getString(1);
				double ma001 = rs.getDouble(2);
				double ma002 = rs.getDouble(3);
				double ma003 = rs.getDouble(4);
				r = new RecipeDTO(ma001, ma002, ma003);
			}
		} catch (SQLException e) {
			System.out.println("상품등록 SQL 구문 오류");
			e.printStackTrace();
		}
		
		return r;
	}	
		
	//Update
	public int updateProduct(Coffee p) {
		int res = 0;
		String sql = "UPDATE product SET \r\n" + 
				"pr_name = ?, pr_price = ?, pr_ctgry = ?, pr_img = ? \r\n" + 
				"WHERE pr_code = ?;";

		try {
			String pr_name = p.getPr_name();
			int pr_price = p.getPr_price();
			String pr_ctgry = p.getPr_ctgry();
			String pr_code = p.getPr_code();
			String pr_img = p.getPr_img();
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, pr_name);
			stmt.setInt(2, pr_price);
			stmt.setString(3, pr_ctgry);
			stmt.setString(4, pr_img);
			stmt.setString(5, pr_code);
			
			res = stmt.executeUpdate();
			System.out.println("ProductDAO Update Success");
		} catch (SQLException e1) {
			System.out.println("ProducDAO update method sql 구문 오류");
			e1.printStackTrace();
		}
		
		return res;
	}
	
	//레시피 수정
	public int updateRecipe(RecipeDTO r) {
		int res = 0;		
		String sql = "UPDATE recipe SET ma001 = ?, ma002 = ?, ma003 = ? \r\n" + 
					"WHERE pr_code = ? ;";

		try {
			String pr_code = r.getPr_code();
			double ma001 = r.getMa001();
			double ma002 = r.getMa002();
			double ma003 = r.getMa003();
			
			stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, ma001);
			stmt.setDouble(2, ma002);
			stmt.setDouble(3, ma003);
			stmt.setString(4, pr_code);
			res = stmt.executeUpdate();
			
			System.out.println("Recipe Update Success");
		} catch (SQLException e1) {
			System.out.println("Recipe update method sql 구문 오류");
			e1.printStackTrace();
		}
		return res;
	}
	
	//Delete
	public void deleteProduct(String prodno) {
		String sql = "DELETE from product WHERE pr_code = ?;";

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
	public String getMaxProdno(String category) {
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
}
