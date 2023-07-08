package javaJdbc;
import java.sql.*;
import java.util.Scanner;
public class preparedStatement {

	public static void main(String[] args) throws Exception {
		
		String url= "jdbc:mysql://localhost:3306/Student";
		String userName="root";
		String password="root12345";
		String query = "insert into student values (?,?,?)";
//		String query = "DELETE FROM student WHERE student_id= ?";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,userName,password);
		PreparedStatement ps= con.prepareStatement(query);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id:");
		int stuId= sc.nextInt();
		System.out.println("Enter Name:");
		String stuName= sc.next();
		System.out.println("Enter stuName:");
		String city =sc.next();
		
		ps.setInt(1, stuId);
		ps.setString(2, stuName);
		ps.setString(3, city);
		int count = ps.executeUpdate();
		System.out.println(count + " row affected");
		
		ps.close();
		con.close();

	}

}
