package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.OrderVo;
import kr.co.itcen.bookmall.vo.OrderVo;

public class OrderDao {
	
	public Boolean insert(OrderVo vo1) {
		Boolean result = false;
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		try {
			connection = getConnection();

			String sql = "insert into orders(order_number,user_id,payment,delivery_address,order_status) values(?,?,?,?,?)";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setLong(1, vo1.getOrderNumber());
			pstmt.setLong(2, vo1.getUserNumber());
			pstmt.setLong(3, vo1.getPrice());
			pstmt.setString(4, vo1.getDeliveryAddress());
			pstmt.setString(5, vo1.getOrderStatus());
			
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

	public List<OrderVo> getList() {
		List<OrderVo> result = new ArrayList<OrderVo>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			connection = getConnection();
		
			String sql = "select order_number,user_id,payment,delivery_address,order_status from orders;";
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				
				int orderNumber = rs.getInt("order_number");
				int userNumber = rs.getInt("user_id"); 
				int price = rs.getInt("payment");
				String deliveryAddress = rs.getString("delivery_address");
				String orderStatus = rs.getString("order_status");

				
				OrderVo vo = new OrderVo();
				
				vo.setOrderNumber(orderNumber);
				vo.setUserNumber(userNumber);
				vo.setPrice(price);
				vo.setDeliveryAddress(deliveryAddress);
				vo.setOrderStatus(orderStatus);
				
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

			String sql = "delete from orders";
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

	public void update(long order_number, String delivery_address) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {

			connection = getConnection();

			String sql = "update orders set delivery_address = ? where order_number = ?";

			pstmt = connection.prepareStatement(sql);

			pstmt.setLong(1,order_number);
			pstmt.setString(2, delivery_address);

			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 자원정리해주기 Connection
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
