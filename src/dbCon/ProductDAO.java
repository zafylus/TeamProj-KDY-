package dbCon;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.SelectDAO;
import dto.Coffee;
import dto.Product;

//상품 관리 DAO
public class ProductDAO implements SelectDAO{

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
				Product p = new Coffee(prodname, price, category, prodno);
				plist.add(p);
			}
		} catch (SQLException e) {
			System.out.println("상품등록 SQL 구문 오류");
			e.printStackTrace();
		}
		
		return plist;
	}

}
