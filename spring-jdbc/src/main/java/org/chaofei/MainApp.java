package org.chaofei;

import java.util.ArrayList;
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

        testDelete(studentJDBCTemplate);
        testListStudents(studentJDBCTemplate);

        testGetStudentByStoredProcedure(studentJDBCTemplate);

        testGetStudentByStoreFun(studentJDBCTemplate);

        testUpdateStudentImageByBLOB(studentJDBCTemplate);

        testUpdateStudentDescriptionByCOLB(studentJDBCTemplate);

        testBatchUpdate(studentJDBCTemplate);

        testObjectBatchUpdate(studentJDBCTemplate);
        
        testMutipleBatchUpdate(studentJDBCTemplate);
    }

    private static void testUpdate(StudentJDBCTemplate studentJDBCTemplate) {
        System.out.println("-----------------Updating Record with ID = 2-----------------");
        studentJDBCTemplate.update(2, 26);
        Student student = testGetStudentById(studentJDBCTemplate, 1);
        System.out.println(student.toString());
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

    private static void testGetStudentByStoredProcedure(StudentJDBCTemplate studentJDBCTemplate) {
        System.out.println("-----------------Get Student's Name By ID 1:-----------------");
        Student student = studentJDBCTemplate.getStudentByStoredProcedure(1);
        System.out.println(student);
    }

    private static void testGetStudentByStoreFun(StudentJDBCTemplate studentJDBCTemplate) {
        System.out.println("-----------------Get Student's Name By ID 3:-----------------");
        Student student = studentJDBCTemplate.getStudentByStoreFun(3);
        System.out.println(student);
    }

    private static void testUpdateStudentImageByBLOB(StudentJDBCTemplate studentJDBCTemplate) {
        System.out.println("-----------------Update Student's image By ID 1:-----------------");
        byte[] imageData = { 0, 1, 0, 8, 20, 40, 95 };
        studentJDBCTemplate.updateStudentImageByBLOB(1, imageData);
        Student student = testGetStudentById(studentJDBCTemplate, 1);
        System.out.println(student.toString());
    }

    private static void testUpdateStudentDescriptionByCOLB(StudentJDBCTemplate studentJDBCTemplate) {
        System.out.println("-----------------Update Student's description By ID 1:-----------------");
        String description = "This can be a very long text upto 4 GB of size.";
        studentJDBCTemplate.updateStudentDescriptionByCOLB(1, description);
        Student student = testGetStudentById(studentJDBCTemplate, 1);
        System.out.println(student.toString());
    }

    private static Student testGetStudentById(StudentJDBCTemplate studentJDBCTemplate, Integer id) {
        System.out.println("----------------------Listing Multiple Recocrds----------------");
        return studentJDBCTemplate.getStudentById(id);
    }

    private static void testBatchUpdate(StudentJDBCTemplate studentJDBCTemplate) {
        System.out.println("----------------------Recocrds Creation----------------");
        studentJDBCTemplate.create("Maxsu", 21);
        studentJDBCTemplate.create("Curry", 22);
        studentJDBCTemplate.create("Weiwei", 25);
        testListStudents(studentJDBCTemplate);

        System.out.println(testGetStudentById(studentJDBCTemplate, 1));
        System.out.println(testGetStudentById(studentJDBCTemplate, 3));
        Student student = new Student();
        student.setId(1);
        student.setAge(25);
        Student student1 = new Student();
        student1.setId(3);
        student1.setAge(25);
        List<Student> students = new ArrayList<Student>();
        students.add(student);
        students.add(student1);
        studentJDBCTemplate.batchUpdate(students);

        System.out.println("----------------------Updated Students----------------");
        System.out.println(testGetStudentById(studentJDBCTemplate, 1));
        System.out.println(testGetStudentById(studentJDBCTemplate, 3));
    }

    private static void testObjectBatchUpdate(StudentJDBCTemplate studentJDBCTemplate) {
        System.out.println("----------------------Recocrds Creation----------------");
        studentJDBCTemplate.create("Maxsu", 21);
        studentJDBCTemplate.create("Curry", 22);
        studentJDBCTemplate.create("Weiwei", 25);
        testListStudents(studentJDBCTemplate);

        System.out.println(testGetStudentById(studentJDBCTemplate, 1));
        System.out.println(testGetStudentById(studentJDBCTemplate, 3));
        Student student = new Student();
        student.setId(1);
        student.setAge(15);
        Student student1 = new Student();
        student1.setId(3);
        student1.setAge(16);
        List<Student> students = new ArrayList<Student>();
        students.add(student);
        students.add(student1);
        studentJDBCTemplate.objectBatchUpdate(students);

        System.out.println("----------------------Updated Students----------------");
        System.out.println(testGetStudentById(studentJDBCTemplate, 1));
        System.out.println(testGetStudentById(studentJDBCTemplate, 3));
    }
    
    private static void testMutipleBatchUpdate(StudentJDBCTemplate studentJDBCTemplate) {
        System.out.println("----------------------Recocrds Creation----------------");
        studentJDBCTemplate.create("Maxsu", 21);
        studentJDBCTemplate.create("Curry", 22);
        studentJDBCTemplate.create("Xiaowei", 25);
        testListStudents(studentJDBCTemplate);

        System.out.println(testGetStudentById(studentJDBCTemplate, 1));
        System.out.println(testGetStudentById(studentJDBCTemplate, 3));
        Student student = new Student();
        student.setId(1);
        student.setAge(17);
        Student student1 = new Student();
        student1.setId(3);
        student1.setAge(18);
        List<Student> students = new ArrayList<Student>();
        students.add(student);
        students.add(student1);
        studentJDBCTemplate.mutipleBatchUpdate(students);

        System.out.println("----------------------Updated Students----------------");
        System.out.println(testGetStudentById(studentJDBCTemplate, 1));
        System.out.println(testGetStudentById(studentJDBCTemplate, 3));
    }
}
