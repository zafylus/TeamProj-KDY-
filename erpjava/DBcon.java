package erp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBcon {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String driverName = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3306/erp";
		String uid = "root";
		String upw = "1234";
		Class.forName(driverName);
		Connection conn = DriverManager.getConnection(url,uid,upw);
		return conn;
	}
}
