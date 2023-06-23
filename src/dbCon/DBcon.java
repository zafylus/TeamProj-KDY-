package dbCon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBcon {

	public static Connection getConnection() {
		String url = "jdbc:mariadb://localhost:3306/erp";
		String uid = "root";
		String upw = "1234";
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			System.out.println("jdbc 라이브러리를 찾을 수 없습니다.");
			e1.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, uid, upw);
		} catch (SQLException e1) {
			System.out.println("SQL 구문 오류");
			e1.printStackTrace();
		}
		System.out.println("DBcon 객체 생성됨");
		return conn;
	}
}
