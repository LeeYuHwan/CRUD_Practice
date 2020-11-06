package org.web.guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.web.guestbook.dto.Guestbook;
import org.web.guestbook.util.DBUtil;

public class GuestbookDao {
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Guestbook> getGuestbooks(){
        List<Guestbook> list = new ArrayList<>();
        
        try {
			conn = DBUtil.getConnection();
			String sql = "SELECT id, name, content, regdate FROM guestbook";		
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				long id = rs.getLong("id");
				String name = rs.getString("name");
				String content = rs.getString("content");
				Timestamp regdate = rs.getTimestamp("regdate");
				
				list.add(new Guestbook(id, name, content, regdate));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
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
		}

        return list;
    }

    public void addGuestbook(Guestbook guestbook){		
		try {
			conn = DBUtil.getConnection();
			String sql = "INSERT INTO guestbook(name, content, regdate) VALUES (?,?,?)";		
			ps = conn.prepareStatement(sql);
			ps.setString(1, guestbook.getName());
			ps.setString(2, guestbook.getContent());
			ps.setTimestamp(3, guestbook.getRegdate());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
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
		}		
    }
}
