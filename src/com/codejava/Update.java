package com.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
	public static void main(String[] args) {
		String jdbcURL="jdbc:mysql://localhost:3306/sampledb";
		String dbusername="root";
		String dbpassword="";
		try {
			Connection connection=DriverManager.getConnection(jdbcURL,dbusername,dbpassword);
			String sql="UPDATE users SET password ='keysk' WHERE username='Aabhushan'";
			Statement stm=connection.createStatement();
			int rows=stm.executeUpdate(sql);
			if(rows>0) {
				System.out.println("The table has been updated");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
