package dao;

import java.sql.Connection;
import java.util.ArrayList;

import dbCon.DBcon;
import dto.Product;

public interface SelectDAO {
	final Connection conn = (new DBcon()).getConnection();
	
	public Object selectAll();
}
