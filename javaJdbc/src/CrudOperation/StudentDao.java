package CrudOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import CrudOperation.ConnectionProvider;
import CrudOperation.Student;


public class StudentDao {
	
	//CREATE STUDENT METHOD
		public void addStudent(Student stu) {
			try {
				String q="insert into student values(?,?,?)";
				Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps= con.prepareStatement(q);
				ps.setInt(1, stu.getId());
				ps.setString(2, stu.getName());
				ps.setString(3, stu.getCity());
				
				int count = ps.executeUpdate();
				System.out.println(count + " row inserted successfully");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		//READ STUDNET METHOD
		public Student getStudent(int id) 
		{	
			try {
				String q="select * from student where id =?";
				
				Student s= new Student();
				Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement(q);
				ps.setInt(1, id);
				ResultSet rs= ps.executeQuery();
				
				rs.next();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setCity(rs.getString(3));
				return s;
				
			}
			catch(Exception e){
				return null;
			}
			
		}
		
		//UPDATE STUDENT
		public void updateStudent(int id,String updatedName, String updatedCity) {
			try {
				String q="Update student set name=?,city=? where id=?";
				Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps= con.prepareStatement(q);
				ps.setString(1, updatedName);
				ps.setString(2, updatedCity);
				ps.setInt(3, id);
				int count = ps.executeUpdate();
				System.out.println(count + " row updated successfully");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		
		//DELETE STUDENT BY ID METHOD
		
		public void removeStudentById(int id) {
			try {
				String q="delete from student where id=?";
				Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps= con.prepareStatement(q);
				ps.setInt(1, id);
				int count = ps.executeUpdate();
				System.out.println(count + " row deleted successfully");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
}
