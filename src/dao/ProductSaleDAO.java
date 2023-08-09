package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.sale.productAnalysis.AllProductSaleVO;
import vo.sale.productAnalysis.SaleTop3VO;


public class ProductSaleDAO {
	private Connection con;
	private Date startDate;
	private Date endDate;
	
	

	public ProductSaleDAO(Date startDate, Date endDate) {
		
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public List<SaleTop3VO> getTop3(){
		con = db.DBcon.getConn();
		List<SaleTop3VO> top3List = new ArrayList<>();
		

		try {
			String sql = "SELECT pr_name, SUM(amount) AS total_amount, SUM(amount * pr_price) AS pay\r\n" + 
					"FROM ordr_view\r\n" + 
					"WHERE odr_date BETWEEN ? AND ?\r\n" + 
					"  AND pr_price > 0\r\n" + 
					"GROUP BY pr_code, pr_name\r\n" + 
					"ORDER BY total_amount DESC, pay DESC\r\n" + 
					"LIMIT 3;";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, startDate);
			pstmt.setDate(2, endDate);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String prName = rs.getString("pr_name");
				int count = rs.getInt("total_amount");
				int pay = rs.getInt("pay");

				SaleTop3VO productSale = new SaleTop3VO(prName, count, pay);
				top3List.add(productSale);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }

		
		return top3List;
	}
	
		public List<AllProductSaleVO> getAllPruductOrder() {
			con = db.DBcon.getConn();
			List<AllProductSaleVO> allProductList = new ArrayList<>();
			
	
			try {
				String sql = "SELECT pr_name, SUM(amount) AS total_amount, SUM(amount * pr_price) AS pay\r\n" + 
						"		FROM ordr_view\r\n" + 
						"		WHERE odr_date BETWEEN ? AND ?\r\n" + 
						"  		AND pr_price > 0\r\n" + 
						"		GROUP BY pr_code, pr_name\r\n" + 
						"		ORDER BY total_amount DESC;";
	
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setDate(1, startDate);
				pstmt.setDate(2, endDate);
				ResultSet rs = pstmt.executeQuery();
	
				while (rs.next()) {
					String prName= rs.getString("pr_name");
					int count = rs.getInt("total_amount");
					int pay = rs.getInt("pay");
	
					AllProductSaleVO productSale = new AllProductSaleVO(prName, count, pay);
					allProductList.add(productSale);
				}
	
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					con.close(); 
				}catch (Exception e) {
					e.printStackTrace();
				}
		    }
	
			return allProductList;
		}
	
		
	public int getTotalProductSale() {
		con = db.DBcon.getConn();
	    int totalCount = 0;
	   

	    try {
	        String sql = "SELECT pr_name, SUM(amount) AS total_amount\r\n" + 
	        		"	FROM ordr_view\r\n" + 
	        		"	WHERE odr_date BETWEEN ? AND ?\r\n" + 
	        		"	AND pr_price >0 \r\n" + 
	        		"	LIMIT 3;";

	        PreparedStatement pstmt = con.prepareStatement(sql);
	        pstmt.setDate(1, startDate);
	        pstmt.setDate(2, endDate);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            totalCount = rs.getInt("total_amount");
	        }

	    } catch (Exception e) {
	    	
	        e.printStackTrace();
	    }finally {
	    	try {
	    		con.close(); 
	    	} catch (Exception e) {
	    		e.printStackTrace();
			}
	    }

	    return totalCount;
	}
}
