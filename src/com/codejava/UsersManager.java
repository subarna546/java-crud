package com.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UsersManager{
	public static void main(String[] args) {
		String jdbcURL="jdbc:mysql://localhost:3306/sampledb";
		String dbusername="root";
		String dbpassword="";
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter  std_username,std_password,std_age,std_fullName");
		String username=sc.next();
		String password=sc.next();
		String email=sc.next();
		String fullName=sc.next();
		
		
		try {
			
			Connection connection=DriverManager.getConnection(jdbcURL,dbusername,dbpassword);
			
			String sql="INSERT INTO users (username, password, fullname, email) VALUES (?, ?, ?, ?)";
			PreparedStatement stm=connection.prepareStatement(sql);
			stm.setString(1, username);
			stm.setString(2, password);
			stm.setString(3, fullName);
			stm.setString(4, email);
			
			int rows=stm.executeUpdate();
		
			if(rows>0) {
				System.out.println("New Row added");
			}
			
				connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
