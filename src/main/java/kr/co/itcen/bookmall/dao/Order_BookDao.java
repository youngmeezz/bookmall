package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.Order_BookVo;

public class Order_BookDao {

	
	
	public Boolean insert(Order_BookVo vo1) {
		int count = 0;
		Boolean result = false;
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;


		try {
			connection = getConnection();

			String sql2 ="select orders.order_number, cart.book_id ,cart.amount from orders inner join cart on orders.user_id=cart.user_id";
			
			pstmt = connection.prepareStatement(sql2);
			
			rs=pstmt.executeQuery();
			String orderNumber = null; //고객번호
			String amount = null; //각 책 수량
			String bookNumber= null; //책번호
			
			List<Order_BookVo> list = new ArrayList<Order_BookVo>();
			
			while(rs.next()) {
				System.out.println("asdasd");
				Order_BookVo bVo = new Order_BookVo();
				
				orderNumber =rs.getString(1);
				bookNumber =rs.getString(2);
				amount =rs.getString(3);
				System.out.println("00000000000000001234");
				int IorderNumber = Integer.parseInt(orderNumber);
				int IbookNumber = Integer.parseInt(bookNumber);
				int Iamount = Integer.parseInt(amount);
				System.out.println("000000000000567870");
				
				bVo.setOrderNumber(IorderNumber);
				bVo.setBookNumber(IbookNumber); 
				bVo.setAmount(Iamount);
				
				
				list.add(bVo);
			}
			
			for(Order_BookVo bvo : list) {
				Order_BookVo bVo = new Order_BookVo();
				int ammount = bvo.getAmount();
				int BookNumb = bVo.getBookNumber();
				int orNumb = bVo.getOrderNumber();
				
				String sql = "insert into order_book(order_number,book_id,book_count) values(?,?,?)";
				pstmt = connection.prepareStatement(sql);
				
				pstmt.setInt(1, orNumb);
				pstmt.setInt(2, BookNumb);
				pstmt.setInt(3, ammount);
				System.out.println("00000000000000000");
				count = pstmt.executeUpdate();
				System.out.println("11111111111111");
				
				
			}
			
//			String sql2 = "select"
			
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

	public List<Order_BookVo> getList() {
		List<Order_BookVo> result = new ArrayList<Order_BookVo>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			connection = getConnection();

			String sql = "select order_number,book_id,book_count from order_book;";
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				int orderNumber= rs.getInt("order_number");
				int bookId  = rs.getInt("book_id");
				int amount = rs.getInt("book_count");
				Order_BookVo vo = new Order_BookVo();
				
				vo.setBookNumber(bookId);
				vo.setOrderNumber(orderNumber);
				vo.setAmount(amount);
				
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

//	public void delete() {
//		// TODO Auto-generated method stub
//		
//
//		Connection connection = null;
//		PreparedStatement pstmt = null;
//		try {
//
//			connection = getConnection();
//
//			String sql = "delete from book";
//			pstmt = connection.prepareStatement(sql);
//
//			pstmt.executeUpdate();
//
//		} catch (SQLException e) {
//			System.out.println("error:" + e);
//		} finally {
//			try {
//				if (pstmt != null) {
//					pstmt.close();
//				}
//				if (connection != null) {
//					connection.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
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

