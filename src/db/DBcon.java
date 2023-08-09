package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBcon {
	
	public static Connection getConn() {
		String driver = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3306/erp";
		String uid = "root";
		String upw = "1234";
		Connection con = null;
		
		try {
			Class.forName(driver);
		}catch (Exception e) {
			System.out.println("클래스 로드 실패 : " + e.getMessage());
		}
		
		try {
		con = DriverManager.getConnection(url, uid, upw);
		} catch (Exception e) {
			System.out.println("커넥션 객체 생성 실패" + e.getMessage());
		}
		return con;
	}
}
