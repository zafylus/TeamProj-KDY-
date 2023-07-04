package dbCon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBcon {

	public static Connection conn = null;
	
	public Connection getConnection() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://localhost:3306/erp";
			String id = "root";
			String pw = "1234";
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB Connecting Success(기본 생성자)");
		}  catch (Exception e) {
			System.out.println("커넥션 객체 못가져옴 : " + e.getMessage());
		}

		return conn;
	}
	
	public static void close() throws SQLException {
		if(conn != null) conn.close();
	}
}
