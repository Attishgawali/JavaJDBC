package javaJdbc;

import java.sql.*;
import java.io.*;

public class ImageSave {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String query = "insert into images(pic) values(?)";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student",
				"root","root12345");
		
		FileInputStream fis = new FileInputStream("cake.jpg");
		PreparedStatement ps= con.prepareStatement(query);
		ps.setBinaryStream(1, fis,fis.available());
		
		ps.executeUpdate();
		System.out.println("Done...");
		
		ps.close();
		con.close();
		

	}

}
