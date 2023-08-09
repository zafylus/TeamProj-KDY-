package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import DButil.DBcon;
import DButil.DBconnect;
import dto.StockDTO;
import vos.StockOptionVO;
import vos.TotalStockVO;

public class StockDAO implements IERP_DAO{

	@Override
	public boolean insert(Object dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		StockDTO stock = (StockDTO)dto;
		
		String query = "INSERT INTO stock "
				+ "VALUE (null, ?, ?, ?, ?)";
		
		try {
			DBconnect connect = new DBconnect();
			con = connect.getConn();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, stock.getMa_code());
			pstmt.setInt(2, stock.getSt_ea());
			pstmt.setTimestamp(3, Timestamp.valueOf(stock.getSt_recDate()));
			pstmt.setString(4, stock.getSt_note());
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.println("재고 입력 실패 : " + e.getMessage());
			
		} finally {
			try {
				if (pstmt != null) 
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패 : " + e.getMessage());
			}
		}
		return flag;
	}
	
	@Override
	public List<Object> getData() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Object> list = new ArrayList<>();
		
		
		String query = "SELECT * FROM stock";
		
		try {
			DBconnect connect = new DBconnect();
			con = connect.getConn();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if (rs != null) {
				while(rs.next()) {
					StockDTO dto = new StockDTO();
					dto.setSt_no(rs.getInt("st_no"));
					dto.setMa_code(rs.getString("ma_name"));
					dto.setSt_ea(rs.getInt("st_ea"));
					dto.setSt_recDate(rs.getTimestamp("st_recDate").toLocalDateTime());
					dto.setSt_note(rs.getString("st_note"));
					list.add(dto);
				}
			}
			
		} catch (Exception e) {
			System.out.println("재고 리스트 반환 실패 : " + e.getMessage());
			
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패 : " + e.getMessage());
			}
		}
		return list;
	}

	@Override
	public boolean update(Object dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		StockDTO stock = (StockDTO)dto;
		
		String query = "UPDATE stock SET ma_code = ?, st_ea = ?, st_recDate = ?, st_note = ? "
							+ "WHERE st_no = ?"; 
		
		try {
			con = DBcon.getConn();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, stock.getMa_code());
			pstmt.setInt(2, stock.getSt_ea());
			pstmt.setTimestamp(3, Timestamp.valueOf(stock.getSt_recDate()));
			pstmt.setString(4, stock.getSt_note());
			pstmt.setInt(5, stock.getSt_no());
			int result = pstmt.executeUpdate();
			
			if (result == 1)
				flag = true;
			
		} catch (Exception e) {
			System.out.println("재고 업데이트 실패 : " + e.getMessage());
			
		} finally {
			try {
				if (pstmt != null )
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패 : " + e.getMessage());
			}
		}
		return flag;
	}

	@Override
	public boolean delete(Object dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		StockDTO stock = (StockDTO)dto;
		boolean flag = false;
		
		String query = "DELETE FROM stock WHERE st_no=?";
		
		try {
			con = DBcon.getConn();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, stock.getSt_no());
			int result = pstmt.executeUpdate();
			
			if (result == 1)
				flag = true;
			
		} catch (Exception e) {
			System.out.println("재고 삭제 실패 : "+ e.getMessage());
			
		} finally {
			try {
				if (pstmt != null) 
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패 : " + e.getMessage());
			}
		}
		return flag;
	}
	
	// 현재 페이지 번호를 받아
	// 기간 사이의 재고 입출력 리스트 반환 (20개 단위)
	public List<StockDTO> getStockDateData(String date1, String date2, int p) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<StockDTO> list = new ArrayList<>();
		int firstPage = ((p-1) * 20);
		
		String query = "SELECT * FROM stocklist" + 
				" WHERE date(st_recDate) BETWEEN ? AND ?" + 
				" ORDER BY st_recDate DESC LIMIT ?, 20";
		
		
		try {
			con = DButil.DBcon.getConn();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, date1);
			pstmt.setString(2, date2);
			pstmt.setInt(3, firstPage);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if( rs != null ) {
					StockDTO dto = new StockDTO();
					dto.setSt_no(rs.getInt("st_no"));
					dto.setMa_code(rs.getString("ma_name"));
					dto.setSt_ea(rs.getInt("st_ea"));
					dto.setSt_recDate(rs.getTimestamp("st_recDate").toLocalDateTime());
					dto.setSt_note(rs.getString("st_note"));
					list.add(dto);
				}
			}
		} catch (Exception e) {
			System.out.println("기간 데이터 반환 실패 : " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패 : " + e.getMessage());
			}
		}
		return list;
	}
	
	// 현재 물품 별 재고 총량 갯수 리스트 반환
	public List<TotalStockVO> getTotal() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<TotalStockVO> list = new ArrayList<>();
		
		String query = "SELECT m.ma_name, SUM(s.st_ea) " + 
				"FROM stock s , material m " + 
				"WHERE s.ma_code = m.ma_code " + 
				"GROUP BY s.ma_code " + 
				"ORDER BY st_recDate DESC";
		
		try {
			con = DBcon.getConn();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				while(rs.next()) {
					TotalStockVO s = new TotalStockVO();
					s.setMa_name(rs.getString(1));
					s.setTotalEa(rs.getInt(2));
					list.add(s);
				}
			}
		} catch (Exception e) {
			System.out.println("총량 리스트 반환 실패 : " + e.getMessage());
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(con != null)
					con.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패 : " + e.getMessage());
			}
		}
		return list;
	}
	
	// 재고 리스트 데이터 총 갯수 반환
	public int getListCnt() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		
		String query = "SELECT count(*) FROM stock ";
		
		try {
			con = DBcon.getConn();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if (rs.next()) 
				cnt = rs.getInt(1);
			
		} catch (Exception e) {
			System.out.println("재고 리스트 총 갯수 데이터 반환 실패 : " + e.getMessage());
			
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패 : " + e.getMessage());
			}
		}
		return cnt;
	}
	
	// 두 기간 사이의 조회한 총 데이터 갯수 반환
	public int getListCntBetweenDate(String date1, String date2) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		
		String query = "SELECT count(*) FROM stock WHERE date(st_recDate) BETWEEN ? AND ?";
		
		try {
			con = DBcon.getConn();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, date1);
			pstmt.setString(2, date2);
			rs = pstmt.executeQuery();
			
			if (rs.next()) 
				cnt = rs.getInt(1);
			
		} catch (Exception e) {
			System.out.println("재고 리스트 총 갯수 데이터 반환 실패 : " + e.getMessage());
			
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패 : " + e.getMessage());
			}
		}
		return cnt;
	}
	
	// 재고 설정 옵션 저장 (매개변수 : 알람여부 , 알림 수량 설정)
	@SuppressWarnings("resource")
	public boolean setOption(boolean checked, int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		int result = 0;
		
		String sql1 = "DELETE FROM st_option";
		String sql2 = "INSERT INTO st_option VALUE (?, ?)";
		
		try {
			con = DBcon.getConn();
			pstmt = con.prepareStatement(sql1);
			result = pstmt.executeUpdate();
			
			if (result == 1) {
				result = 0;
				pstmt = con.prepareStatement(sql2);
				pstmt.setBoolean(1, checked);
				pstmt.setInt(2, num);
				result = pstmt.executeUpdate();
			}
			
			if (result == 1)
				flag = true;
			
		} catch (Exception e) {
			System.out.println("옵션 변경 실패 : " + e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패 : " + e.getMessage());
			}
		}
		return flag;
	}
	
	// 재고 설정 가져오기
	public StockOptionVO getOption() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StockOptionVO opt = new StockOptionVO();
		
		String sql = "SELECT * FROM st_option";
		
		try {
			con = DBcon.getConn();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				opt.setAlramOpt(rs.getBoolean(1));
				opt.setAlramNum(rs.getInt(2));
			}
		} catch (Exception e) {
			System.out.println("옵션 조회 실패 : " + e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패 : " + e.getMessage());
			}
		}
		return opt;
	}
}
