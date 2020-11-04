package kr.or.connect.JDBCInformationProgram.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import kr.or.connect.JDBCInformationProgram.dto.businesscard;

public class businesscardDao {
	
	private static String dburl = "jdbc:mysql://localhost:3306/springt?useSSL=false&serverTimezone = UTC&useUnicode=true&characterEncoding=UTF-8";
	private static String dbUser = "root";
	private static String dbpasswd = "0000";
	
	public businesscard getName(String name) {
		businesscard b_card = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			String sql = "SELECT name, phone, company, createDate FROM businesscard WHERE NAME LIKE ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String name1 = rs.getString("name");
				String phone = rs.getString("phone");
				String company = rs.getString("company");
				Timestamp createDate = rs.getTimestamp("createDate");
				b_card = new businesscard(name1, phone, company, createDate);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		
		return b_card;
	}
}
