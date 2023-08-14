package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBcon;
import dto.ReceiptItem;
import dto.ReceiptSales;

public class ReceiptDAO {
    private Connection conn;

    public ReceiptDAO() {
        conn = DBcon.getConn();
    }

    public List<ReceiptSales> getSales() {
        List<ReceiptSales> salesList = new ArrayList<>();

        try {
            String query = "SELECT odr_code, SUM(sales) AS total_sales, order_date " +
                           "FROM ordr_view " +
                           "WHERE order_date BETWEEN DATE_SUB(CURRENT_DATE(), INTERVAL 6 MONTH) AND CURRENT_DATE()+1 " +
                           "GROUP BY odr_code " +
                           "ORDER BY odr_code ASC";

            PreparedStatement pstt = conn.prepareStatement(query);
            ResultSet rs =  pstt.executeQuery();

            while (rs.next()) {
                String odrCode = rs.getString("odr_code");
                double totalSales = rs.getDouble("total_sales");
                String odrDate = rs.getString("order_date");

                ReceiptSales sales = new ReceiptSales(odrCode, totalSales, odrDate);
                salesList.add(sales);
            }

            rs.close();
            pstt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return salesList;
    }

    public List<ReceiptItem> getItems(String order_no) {
        List<ReceiptItem> itemList = new ArrayList<>();

        try {
            String query = "SELECT odr_code,pr_code , pr_name,pr_price ,amount " +
                           "FROM ordr_view " +
                           "WHERE order_date BETWEEN DATE_SUB(CURRENT_DATE(), INTERVAL 6 MONTH) AND CURRENT_DATE()+1 " +
                           "AND odr_code = ? " +
                           "ORDER BY odr_code ASC";

            PreparedStatement pstt = conn.prepareStatement(query);
            pstt.setString(1, order_no);
            ResultSet rs = pstt.executeQuery();

            while (rs.next()) {
                String odrCode = rs.getString("odr_code");
                String prNo = rs.getString("pr_code");
                String prName = rs.getString("pr_name");
                int prPrice = rs.getInt("pr_price");
                int amount = rs.getInt("amount");

                ReceiptItem item = new ReceiptItem(odrCode, prNo, prName,prPrice ,amount);
                itemList.add(item);
            }

            rs.close();
            pstt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itemList;
    }
    public int getMaxodrCode() {
        int maxodrCode = 0;

        try {
            String query = "SELECT MAX(odr_code) AS highest_odr_code FROM ordr_view";
            PreparedStatement pstt = conn.prepareStatement(query);
            ResultSet rs = pstt.executeQuery();

            if (rs.next()) {
                maxodrCode = rs.getInt("highest_odr_code");
            }

            rs.close();
            pstt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maxodrCode;
    }
    

    public boolean insertOrder(String odrCode, String prCode, int amount) {
        try {
            String query = "INSERT INTO orderlist (odr_code, pr_code, amount) VALUES (?,?, ?)";
            PreparedStatement pstt = conn.prepareStatement(query);
            pstt.setString(1, odrCode);
            pstt.setString(2, prCode);
            pstt.setInt(3, amount);

            int rowsAffected = pstt.executeUpdate();
            pstt.close();

            return rowsAffected > 0; // 삽입이 성공하면 true 반환
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("DB 커넥션 종료 성공");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
