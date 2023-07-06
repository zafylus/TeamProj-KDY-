package DButil;

import java.sql.Connection;

public class DBconnect {
	
	public Connection getConn() {
		Connection con = null;
		DBconPool pool = new DBconPool();
		String msg = "";
		try {
			//con = pool.getConn();
		//	msg = "풀 연결";
			if(con == null) {
				con = DBcon.getConn();
				msg = "DB컨 연결";
			}
			System.out.println(msg);
		}catch (Exception e) {
			System.out.println("커넥션 객체 생성 실패 : " + e.getMessage());
		}
		return con;
	}
}
