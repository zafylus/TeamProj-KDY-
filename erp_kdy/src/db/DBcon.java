package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBcon {
	public Connection con;
	public Statement stmt;
	public PreparedStatement pstt;
	public ResultSet rs;
	
	public  DBcon() {
		
		try {
			InitialContext initCtx  = new InitialContext(); 
			Context ctx = (Context)initCtx.lookup("java:comp/env");
			DataSource source = (DataSource)ctx.lookup("erp.db");
			
			con = source.getConnection();
			
			System.out.println("DB 커넥션 풀 연결 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void close() {
		try {
			if(rs != null) 
				rs.close();
			if(stmt != null) 
				stmt.close();
			if(pstt != null)
				pstt.close();
			if (con !=null)
				con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
