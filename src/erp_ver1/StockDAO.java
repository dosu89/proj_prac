package erp_ver1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StockDAO implements DBcrud{

	@Override
	public boolean insert(Object dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		StockDTO stock = (StockDTO)dto;
		
		String query = "INSERT INTO (m_code, s_amount, s_TotalAmount, recDate, forwDate) "
				+ "(stock VALUE (?, ?, ?, ?, ?, ?)";
		
		try {
			con = DBcon.getConn();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, stock.getS_no());
			pstmt.setString(2, stock.getM_code());
			pstmt.setInt(3, stock.getS_amount());
			pstmt.setInt(4, stock.getS_totalAmount());
			pstmt.setTimestamp(5, Timestamp.valueOf(stock.getRecDate()));
			pstmt.setTimestamp(5, Timestamp.valueOf(stock.getForwDate()));
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.println("입력 실패 : " + e.getMessage());
			
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
			con = DBcon.getConn();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if (rs != null) {
				while(rs.next()) {
					int s_no = rs.getInt("s_no");
					String m_code = rs.getString("m_code");
					int s_amount = rs.getInt("s_amount");
					int s_totalAmount = rs.getInt("s_totalAmount");
					LocalDateTime recDate = rs.getTimestamp("recDate").toLocalDateTime();
					LocalDateTime forwDate = rs.getTimestamp("forwDate").toLocalDateTime();
					StockDTO dto = 
							new StockDTO(s_no, m_code, s_amount, s_totalAmount, recDate, forwDate);
					list.add(dto);
				}
			}
			
		} catch (Exception e) {
			System.out.println("데이터 반환 실패 : " + e.getMessage());
			
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
		
		String query = "UPDATE stock SET m_code = ?, s_amount = ?, s_totalAmount = ?, recDate = ?, forwDate = ? "
							+ "WHERE s_no = ?"; 
		
		try {
			con = DBcon.getConn();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, stock.getM_code());
			pstmt.setInt(2, stock.getS_amount());
			pstmt.setInt(3, stock.getS_totalAmount());
			pstmt.setTimestamp(4, Timestamp.valueOf(stock.getRecDate()));
			pstmt.setTimestamp(5, Timestamp.valueOf(stock.getForwDate()));
			pstmt.setInt(6, stock.getS_no());
			int result = pstmt.executeUpdate();
			
			if (result == 1) {
				flag = true;
			} else {
				System.out.println("업데이트 실패");
			}
			
		} catch (Exception e) {
			System.out.println("업데이트 실패 : " + e.getMessage());
			
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
	public boolean dalete(Object dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		StockDTO stock = (StockDTO)dto;
		boolean flag = false;
		
		String query = "DELETE FROM stock WHERE s_no=?";
		
		try {
			con = DBcon.getConn();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, stock.getS_no());
			int result = pstmt.executeUpdate();
			
			if (result == 1)
				flag = true;
			
		} catch (Exception e) {
			System.out.println("삭제 실패 : "+ e.getMessage());
			
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
}
