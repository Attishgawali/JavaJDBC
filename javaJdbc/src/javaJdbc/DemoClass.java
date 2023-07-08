package javaJdbc;
import java.sql.*;
//Java Database Connectivity theory 

/*
 * 1. Import java.sql.*;
 * 2. load and Register the driver -->com.
 * 3. Create connection
 * 4. Create a statement
 * 5. Execute the query
 * 6. process the resultSet
 * 7. close
 */


public class DemoClass {

	public static void main(String[] args) throws Exception {
		
		String url="jdbc:mysql://localhost:3306/Student";
		String userName="root";
		String password="root12345";
//		String query="select * from student";
		int stuId=5;
		String stuName ="Tejas";
		String query="insert into student values("+stuId+",'"+stuName +"')";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,userName,password);
		
		Statement st = con.createStatement();
//		ResultSet rs=st.executeQuery(query); excuteQuery() is use to fetch data only
		int count = st.executeUpdate(query);
		System.out.println(count + " Row  affected");

		
		st.close();
		con.close();
		
		

	}

}
