package com.jdbc.practice;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.FileInputStream;
import java.io.File;
import java.sql.*;
//import com.jdbc.practice.ConnectionProvider;

public class Main {

	public static void main(String[] args) throws Exception{
		
		Connection c= ConnectionProvider.getConnection();
		
		String q="insert into images(pic) values (?)";
		
		PreparedStatement pstmt = c.prepareStatement(q);
		
		JFileChooser jfc= new JFileChooser();
		jfc.showOpenDialog(null);
		
		File file= jfc.getSelectedFile();
		
		FileInputStream fis = new FileInputStream(file);
		
		pstmt.setBinaryStream(1, fis,fis.available());
		
		pstmt.executeUpdate();
		
		JOptionPane.showMessageDialog(null, "success");

	}

}
