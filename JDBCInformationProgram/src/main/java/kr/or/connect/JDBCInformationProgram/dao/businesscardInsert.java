package kr.or.connect.JDBCInformationProgram.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class businesscardInsert {
	
	private static String dburl = "jdbc:mysql://localhost:3306/springt?useSSL=false&serverTimezone = UTC&useUnicode=true&characterEncoding=UTF-8";
	private static String dbUser = "root";
	private static String dbpasswd = "0000";
	
	public businesscardInsert(String name, String phone, String company) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Timestamp createDate = new Timestamp(System.currentTimeMillis());
		System.out.println(createDate);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			String sql = "INSERT INTO businesscard VALUES (?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, phone);
			ps.setString(3, company);
			ps.setTimestamp(4, createDate);
			ps.executeUpdate();
					
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
	}	
}
