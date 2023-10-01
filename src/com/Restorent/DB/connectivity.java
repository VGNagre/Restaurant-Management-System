package com.Restorent.DB;

import java.sql.*;
import javax.swing.JFrame;

public class connectivity extends JFrame{

	public Connection c;
	public Statement s;
	public PreparedStatement pst;
	 ResultSet rs;
	public connectivity(){
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");

//		     String url = "jdbc:mysql://localhost:3306/Restaurant";
//
//		     String username = "root";
//
//		     String password = "Pass@1234";
		    
		
		      c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant", "root", "Pass@1234");
		  
		      s = c.createStatement();
		      
		     String sql1 = "show databases";
		     s.execute(sql1);
		    
		    
		    
		 } catch (Exception e) {
			 
		  e.printStackTrace();

		 }
	}

	
	

}
