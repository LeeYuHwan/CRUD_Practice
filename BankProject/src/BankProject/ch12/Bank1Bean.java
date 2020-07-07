package BankProject.ch12;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class Bank1Bean {
	private int aid;
	private String aname;
	private int balance;
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	
	String jdbc_driver = "com.mysql.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost:3306/jspdb?serverTimezone = UTC&useUnicode=true&characterEncoding=UTF-8";
	
	public void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "root", "0000");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
		if(pstmt != null) {
			try {
				pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt != null) {
			try {
				stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("close");
	}
	
	public void getData() {
		connect();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from bank1");
			rs.next();
			aid = rs.getInt("aid");
			aname = rs.getString("aname");
			balance = rs.getInt("balance");
		}catch(Exception e) {
			System.out.println(aid + aname + balance);
			System.out.println(e);
		}finally {
			disconnect();
		}
	}
	
	public boolean transfer(int bal) {
		connect();
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement("update bank1 set balance = balance - ? where aid = 101");
			pstmt.setInt(1, bal);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("update bank2 set balance = balance + ? where aid = 201");
			
			pstmt.setInt(1, bal);
			pstmt.executeUpdate();
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("select balance from bank2 where aid=201");
			
			rs.next();
			
			if(rs.getInt(1) > 40) {
				conn.rollback();
				return false;
			}
			else {
				conn.commit();
			}		
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			disconnect();
		}
		return true;
	}
	
	public int getAid() {
		return aid;
	}
	
	public String getAname() {
		return aname;
	}
	
	public int getBalance() {
		return balance;
	}
	

}
