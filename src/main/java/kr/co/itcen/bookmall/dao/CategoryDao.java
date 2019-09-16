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

public class CategoryDao {
	
		public Boolean insert(CategoryVo vo1) {
			Boolean result = false;
			Connection connection = null;
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;

			try {
				connection = getConnection();

				String sql = "insert into category(no,category_name) values(?,?)";
				pstmt = connection.prepareStatement(sql);
				
				pstmt.setInt(1, vo1.getCategory_no());
				pstmt.setString(2, vo1.getCategory_name());

				
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

		public List<CategoryVo> getList() {
			List<CategoryVo> result = new ArrayList<CategoryVo>();

			Connection connection = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				connection = getConnection();

				String sql = "select no,category_name from category;";
				pstmt = connection.prepareStatement(sql);

				rs = pstmt.executeQuery();

				while (rs.next()) {

					int category_no = rs.getInt("no");
					String category_name = rs.getString("category_name");
					
					CategoryVo vo = new CategoryVo();
					
					vo.setCategory_no(category_no);
					vo.setCategory_name(category_name);
					
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
	}