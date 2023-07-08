package com.jdbc.practice;
import java.sql.*;
import java.util.Scanner;

public class updateJDBC {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		String q="Update student set name=?,city=? where id=?";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student"
				,"root","root12345");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter new name :");
		String name= sc.nextLine();
		
		System.out.println("Enter new city :");
		String city= sc.nextLine();
		
		System.out.println("Enter student id :");
		int id= sc.nextInt();
		
		PreparedStatement ps= con.prepareStatement(q);
		
		ps.setString(1, name);
		ps.setString(2,city);
		ps.setInt(3, id);
		
		System.out.println("Name updated succefully..");
		ps.close();
		con.close();
	}

}
