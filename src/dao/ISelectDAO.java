package dao;

import java.sql.Connection;


//DAO Interface
public interface ISelectDAO {
	final Connection conn = DButil.DBcon.getConn();
	
	public Object selectAll();
}
