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
		
		String query = "INSERT INTO stock " + 
							"(rm_name, rm_enExEa, rm_TotalEa, recDate) VALUE (?, ?, ?, ?)";
		
		try {
			con = DBcon.getConn();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, stock.getRm_name());
			pstmt.setInt(2, stock.getRm_enExEa());
			pstmt.setInt(3, stock.getRm_TotalEa());
			pstmt.setTimestamp(4, Timestamp.valueOf(stock.getRecDate()));
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
					int rm_no = rs.getInt("rm_no");
					String rm_name = rs.getString("rm_name");
					int rm_enExEa = rs.getInt("rm_enExEa");
					int rm_TotalEa = rs.getInt("rm_TotalEa");
					LocalDateTime recDate = rs.getTimestamp("recDate").toLocalDateTime();
					LocalDateTime forwDate = rs.getTimestamp("forwDate").toLocalDateTime();
					StockDTO dto = 
							new StockDTO(rm_no, rm_name, rm_enExEa, rm_TotalEa, recDate, forwDate);
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
		
		String query = "UPDATE stock SET rm_name = ?, rm_enExEa = ?, rm_TotalEa = ?, recDate = ?, forwDate = ? "
							+ "WHERE rm_no = ?"; 
		
		try {
			con = DBcon.getConn();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, stock.getRm_name());
			pstmt.setInt(2, stock.getRm_enExEa());
			pstmt.setInt(3, stock.getRm_TotalEa());
			pstmt.setTimestamp(4, Timestamp.valueOf(stock.getRecDate()));
			pstmt.setTimestamp(5, Timestamp.valueOf(stock.getForwDate()));
			pstmt.setInt(6, stock.getRm_no());
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
		
		String query = "DELETE FROM stock WHERE rm_no=?";
		
		try {
			con = DBcon.getConn();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, stock.getRm_no());
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
