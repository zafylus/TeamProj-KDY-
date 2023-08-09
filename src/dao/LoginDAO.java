package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

		PreparedStatement pstt = null;


	    public boolean checkLogin(String id, String password) {
	    	Connection con = db.DBcon.getConn();
	        boolean isValid = false;
	        ResultSet rs = null;

	        try {
	            String query = "SELECT id FROM login WHERE id = ? AND pw = ?";
	            
	            pstt = con.prepareStatement(query);
	            pstt.setString(1, id);
	            pstt.setString(2, password);

	            rs = pstt.executeQuery();

	            if (rs.next()) {
	                isValid = true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	try {
	        		con.close();
	        	}catch (Exception e) {
	        		e.printStackTrace();
	        	}
	        }

	        return isValid;
	    }
	}
