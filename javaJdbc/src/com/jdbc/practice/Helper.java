package com.jdbc.practice;
import java.awt.Image;
import java.io.InputStream;
import java.sql.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Helper {
	
	public static ImageIcon getImageIconById(int id, Connection con) throws Exception{
		ImageIcon icon = null;
		
		String q= "select pic from images where id=?";
		PreparedStatement pstmt= con.prepareStatement(q);
		pstmt.setInt(1, id);
		
		ResultSet set = pstmt.executeQuery();
		
		if(set.next()) {
			Blob b = set.getBlob("pic");
			InputStream is= b.getBinaryStream();
			
			Image image= ImageIO.read(is);
			
			icon = new ImageIcon(image);
		}
		
		return icon;
	}

}
