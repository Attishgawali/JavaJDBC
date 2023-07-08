package CrudOperation;

import CrudOperation.StudentDao;

public class Service {
	
	public static void main(String[] args) throws Exception
	{
		StudentDao dao=new StudentDao();
		
		//CREATE STUDENT 
//		Student s =new Student(5,"Ironman","USA");
		Student s= new Student();
		s.setId(9);
		s.setName("shubhu");
		s.setCity("Russia");
		dao.addStudent(s);
		
		//SHOW STUDENT
//		Student s1= dao.getStudent(3); 
//		System.out.println(s1);
		
		//UPDATE STUDENT
//		dao.updateStudent(4, "captainAmerica", "america");

		//DELETE STUDENT
//		dao.removeStudentById(2);
		
		

	}
}
