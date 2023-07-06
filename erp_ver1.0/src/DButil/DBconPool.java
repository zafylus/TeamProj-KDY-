package DButil;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class DBconPool {
	Connection con;
	
	public DBconPool() {
		try {
			InitialContext initCtx = new InitialContext();
			Context ctx = (Context)initCtx.lookup("java:comp/env");	
 			DataSource source = (DataSource)ctx.lookup("db.erp");
			
			con = source.getConnection();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Connection getConn() {
		DBconPool pool = new DBconPool();
		return pool.con;
	}
}
