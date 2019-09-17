package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.UserVo;

public class UserDao {

	public Boolean insert(UserVo vo1) {
		Boolean result = false;
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		try {
			connection = getConnection();

			String sql = "insert into user(no,name,phone,email,password) values(null,?,?,?,password(?))";
			pstmt = connection.prepareStatement(sql);


			pstmt.setString(1, vo1.getUserName());
			pstmt.setString(2, vo1.getPhoneNumber());
			pstmt.setString(3, vo1.getEmail());
			pstmt.setString(4, vo1.getPassword());

			int count = pstmt.executeUpdate();
			result = (count == 1);
			stmt = connection.createStatement();
			rs =stmt.executeQuery("select last_insert_id()");
	          if(rs.next()) {
	             Long no=rs.getLong(1);
	              vo1.setNo(no);
	          }
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

	public List<UserVo> getList() {
		List<UserVo> result = new ArrayList<UserVo>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			connection = getConnection();

			String sql = "select no,name,phone,email,password from user;";
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				Long userId = rs.getLong("user_id");
				String userName = rs.getString("name");
				String phoneNumber = rs.getString("phone_number");
				String email = rs.getString("email");
				String password = rs.getString("password");

				UserVo vo = new UserVo();
				vo.setNo(userId);
				vo.setUserName(userName);
				vo.setPhoneNumber(phoneNumber);
				vo.setEmail(email);
				vo.setPassword(password);

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

		Connection connection = null;
		PreparedStatement pstmt = null;
		try {

			connection = getConnection();

			String sql = "delete from user";
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

	public void update(long no, String name) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {

			connection = getConnection();

			String sql = "update user set name = ? where user_id = ?";
			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setLong(2, no);

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
