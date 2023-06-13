package erp_ver1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO implements DBcrud{

	@Override
	public boolean insert(Object dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ExpenseDTO expense = (ExpenseDTO)dto;
		boolean flag = false;
		
		String query = "INSERT INTO expense (e_name, e_ea, e_price, e_date) VALUE "
				+ "(?, ?, ?, ?)";
				
		try {
			con = DBcon.getConn();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, expense.getE_name());
			pstmt.setInt(2, expense.getE_ea());
			pstmt.setInt(3, expense.getE_price());
			pstmt.setTimestamp(4, Timestamp.valueOf(expense.getE_date()));
			int result = pstmt.executeUpdate();
			
			if (result ==1 )
				flag = true;
			
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
		
		String query = "SELECT * FROM expense";
		
		try {
			con = DBcon.getConn();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if( rs != null ) {
					int e_no = rs.getInt("e_no");
					String e_name = rs.getNString("e_name");
					int e_ea = rs.getInt("e_ea");
					int e_price = rs.getInt("e_price");
					LocalDateTime e_date = rs.getTimestamp("e_date").toLocalDateTime();
					ExpenseDTO dto = new ExpenseDTO(e_no, e_name, e_ea, e_price, e_date);
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
		ExpenseDTO expense = (ExpenseDTO)dto;
		boolean flag = false;
		
		String query = "UPDATE expense SET e_name = ?, e_ea = ?, e_price = ?, e_date = ? "
							+ "WHERE e_no = ?";
		
		try {
			con = DBcon.getConn();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, expense.getE_name());
			pstmt.setInt(2, expense.getE_ea());
			pstmt.setInt(3, expense.getE_price());
			pstmt.setTimestamp(4, Timestamp.valueOf(expense.getE_date()));
			pstmt.setInt(5, expense.getE_no());
			int result = pstmt.executeUpdate();
			
			if ( result == 1)
				flag = true;
			
		} catch (Exception e) {
			System.out.println("업데이트 실패 : " + e.getMessage());
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
	public boolean dalete(Object dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ExpenseDTO expense = (ExpenseDTO)dto;
		boolean flag = false;
		
		String query = "DELETE FROM expense WHERE e_no = ?";
		
		try {
			con = DBcon.getConn();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, expense.getE_no());
			int result = pstmt.executeUpdate();
			
			if (result == 1) 
				flag = true;
			
		} catch (Exception e) {
			System.out.println("삭제 실패 : " + e.getMessage());
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
