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

			String sql = "insert into cart(no,count,price,user_no,book_no) values(null,?,?,?,?)";
			pstmt = connection.prepareStatement(sql);
			
			
			//pstmt.setInt(1, vo1.getBook_no());
			pstmt.setInt(1, vo1.getCount());
			pstmt.setInt(2, vo1.getPrice());
			pstmt.setInt(3, vo1.getUser_no());
			pstmt.setInt(4, vo1.getBook_no());
			
			
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

			String sql = "select no,count,price,user_no,book_no from cart;";
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				int bookId = rs.getInt("no");
				int amount = rs.getInt("count");
				int price = rs.getInt("price");
				int userNo = rs.getInt("user_no");
				int bookNo = rs.getInt("book_no");
				
				CartVo vo = new CartVo();
				
				vo.setBook_no(bookId);
				vo.setCount(amount);
				vo.setPrice(price);
				vo.setUser_no(userNo);
				vo.setBook_no(bookNo);
			
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

