package org.chaofei;

import java.util.List;

import org.chaofei.dao.impl.StudentJDBCTemplate;
import org.chaofei.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-beans.xml");
        StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
        testListStudents(studentJDBCTemplate);
    }

    private static void testListStudents(StudentJDBCTemplate studentJDBCTemplate) {
        System.out.println("----------------------Listing Multiple Recocrds----------------");
        List<Student> students = studentJDBCTemplate.listStudents();
        for (Student record : students) {
            System.out.print("id : " + record.getId());
            System.out.print(", name : " + record.getName());
            System.out.print(", age : " + record.getAge());
            System.out.print(", image : " + record.getImage());
            System.out.println(", description : " + record.getDescription());
        }
    }
}
