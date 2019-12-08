package com.rest.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnUtil {
	private static Connection conn=null;
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/wsdb","root","root");
			
			
		} catch (ClassNotFoundException e1) {
			System.out.println("---ClassNotFoundEx:"+e1.getMessage());
			
			
		} catch (SQLException e2) {
			System.out.println("---Sql ex:"+e2.getMessage());
		}
	}
	public static Connection getConn(){
		return conn;
	}
	
	
}