package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.CategoryVo;
import kr.co.itcen.bookmall.vo.Order_BookVo;

public class Order_BookDao {

	public Boolean insert(Order_BookVo vo1) {
		Connection connection =null;
		PreparedStatement pstmt = null;
		Statement stmt =null;
		ResultSet rs =null;
		Boolean result = false;
		
		try {
			connection = getConnection();
			String sql= "insert into order_book values(null,?,?,?)";
			pstmt = connection.prepareStatement(sql);

			pstmt.setLong(1, vo1.getAmount());
			pstmt.setInt(2, vo1.getOrderNumber());
			pstmt.setInt(3, vo1.getBookNumber());
			

			
			int count = pstmt.executeUpdate();
			result = (count == 1);
			
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select last_insert_id()");
			if(rs.next()) {
				Long no = rs.getLong(1);
				vo1.setNo(no);
				
			}
			
			String sql1 = "select book_price from book where no= ?";
			pstmt = connection.prepareStatement(sql1);
			pstmt.setLong(1,  vo1.getBookNumber());
			rs=pstmt.executeQuery();
			long total_price = 0; 
			
			 while(rs.next()) {
				 long price = rs.getLong(1);
				 total_price = (long) (price*vo1.getAmount());
			 }
			 
			 String sql2 = "select payment from orders where no= ?";
			 pstmt = connection.prepareStatement(sql2);
			 pstmt.setLong(1, vo1.getOrderNumber());
				rs=pstmt.executeQuery(); 
				
			 while(rs.next()) {
				 int price =rs.getInt(1);
					 total_price+=price;
					 
			}
			 
			 String sql3 ="update orders set payment=? where no=?";
			
			 pstmt = connection.prepareStatement(sql3);
				
			 pstmt.setLong(1, total_price);									
			 pstmt.setLong(2, vo1.getOrderNumber());
				 
			 pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			if(rs!=null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(connection!=null) {
				connection.close();
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;	

	}
	public ArrayList getList() {
		
		ArrayList result = new ArrayList<Order_BookVo>();
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = getConnection();

			String sql = "select ob.book_no,b.title,ob.order_book_count"
					+ " from order_book ob, book b"
					+ " where ob.book_no =b.no";
			pstmt = connection.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {

				Long no = rs.getLong(1);
				String book_title=rs.getString(2);
				Long book_count=rs.getLong(3);
				
				ArrayList temp = new ArrayList();
				temp.add(no);
				temp.add(book_title);
				temp.add(book_count);
				
				result.add(temp);
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

}

