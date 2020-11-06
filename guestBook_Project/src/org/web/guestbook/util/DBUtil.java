package org.web.guestbook.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection getConnection() {
		
		return getConnection("jdbc:mysql://localhost:3306/springt?useSSL=false&serverTimezone = UTC&useUnicode=true&characterEncoding=UTF-8","root","0000");
	}
	
	public static Connection getConnection(String dbURL, String dbId, String dbPassword){
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbId, dbPassword);
            return conn;
        }catch(Exception ex){
            throw new RuntimeException("Connection Error");
        }
    }
}
