package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.CartVo;

public class CartDao {

	
	public Boolean insert(CartVo vo1) {
		Boolean result = false;
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;


		try {
			connection = getConnection();

			String sql = "insert into cart(book_id,user_id,amount) values(?,?,?)";
			pstmt = connection.prepareStatement(sql);
			
			
			pstmt.setInt(1, vo1.getBookNumber());
			pstmt.setLong(2, vo1.getUser_id());
			pstmt.setInt(3, vo1.getCount());
			
			//pstmt.setInt(1, vo1.getBookNumber());
	
			int count = pstmt.executeUpdate();
			result = (count == 1);
			
			stmt = connection.createStatement();
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public List<CartVo> getList() {
		List<CartVo> result = new ArrayList<CartVo>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			connection = getConnection();

			String sql = "select book_id,user_id,amount from cart;";
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				int bookId = rs.getInt("book_id");
				int userId = rs.getInt("user_id");
				int amount = rs.getInt("amount");
				CartVo vo = new CartVo();
				
				vo.setBookNumber(bookId);
				vo.setUser_id((long) userId);
				vo.setCount(amount);
			
				result.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	private Connection getConnection() throws SQLException {
		Connection connection = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");

			String url = "jdbc:mariadb://192.168.1.78:3306/bookmall?characterEncoding=utf8";
			connection = DriverManager.getConnection(url, "bookmall", "bookmall");

		} catch (ClassNotFoundException e) {
			System.out.println("Fail to Loading Driver:" + e);
		}

		return connection;
	}

	public void delete() {
		// TODO Auto-generated method stub
		

		Connection connection = null;
		PreparedStatement pstmt = null;
		try {

			connection = getConnection();

			String sql = "delete from book";
			pstmt = connection.prepareStatement(sql);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
//
//	public void update(int book_id, String name) {
//		// TODO Auto-generated method stub
//		Connection connection = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			connection = getConnection();
//
//			String sql = "update book set name = ? where book_id = ?";
//
//			pstmt = connection.prepareStatement(sql);
//
//			pstmt.setString(1,name);
//			pstmt.setLong(2, book_id);
//
//			pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			System.out.println("error:" + e);
//		} finally {
//
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			// 자원정리해주기 Connection
//			if (connection != null) {
//				try {
//					connection.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
}

