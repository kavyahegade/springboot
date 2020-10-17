package com.sj.DBConnector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DbConnector {
	static Connection con;
	
	
	

	
		
		
		
		
		
		public static Connection getConnection() throws ClassNotFoundException {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");  
			} catch(java.lang.ClassNotFoundException e) {
				System.err.println("class not found exception");
				
			}
			try {
				con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/schemaone","root","qwerty@26");
				
			} catch(SQLException ex) {
				System.err.println("SQL exception");
			}
			return con;
		}
		
		

	}


