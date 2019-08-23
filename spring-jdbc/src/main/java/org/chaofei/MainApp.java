package org.chaofei;

import java.util.List;

import org.chaofei.dao.impl.StudentJDBCTemplate;
import org.chaofei.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-beans.xml");
		
		StudentJDBCTemplate studentJDBCTemplate = testInsert(context);
		
		testListStudents(studentJDBCTemplate);
		
		testUpdate(studentJDBCTemplate);
		
		testListStudents(studentJDBCTemplate);
		
		testDelete(studentJDBCTemplate);
		
		testListStudents(studentJDBCTemplate);
	}

	private static void testUpdate(StudentJDBCTemplate studentJDBCTemplate) {
		System.out.println("-----------------Updating Record with ID = 2-----------------");
		studentJDBCTemplate.update(2, 26);
	}

	private static void testListStudents(StudentJDBCTemplate studentJDBCTemplate) {
		System.out.print("----------------------Listing Multiple Recocrds----------------");
		List<Student> students = studentJDBCTemplate.listStudents();
		for (Student record : students) {
			System.out.print("ID : " + record.getId());
			System.out.print(", Name : " + record.getName());
			System.out.println(", Age : " + record.getAge());
		}
	}

	private static StudentJDBCTemplate testInsert(ApplicationContext context) {
		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
		System.out.println("----------------------Records Creation-----------------------");
		studentJDBCTemplate.create("Maxsu", 19);
		studentJDBCTemplate.create("Minsu", 19);
		studentJDBCTemplate.create("Allen", 27);
		return studentJDBCTemplate;
	}
	
	private static void testDelete(StudentJDBCTemplate studentJDBCTemplate) {
		System.out.println("-----------------Delete Record with ID = 2-----------------");
		studentJDBCTemplate.delete(2);
	}
}
