package dao;

import java.sql.Connection;
import java.util.ArrayList;

import dbCon.DBcon;
import dto.Product;

public interface SelectDAO {
	final Connection conn = DBcon.getConnection();
	
	public ArrayList<Product> selectAll();
}
