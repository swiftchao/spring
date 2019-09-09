package org.chaofei.test;

import java.util.ArrayList;
import java.util.List;

import org.chaofei.dao.impl.StudentJDBCTemplate;
import org.chaofei.entity.Student;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class StudentJDBCTemplateTest extends TestCase {
    private static ApplicationContext context = null;
    private static StudentJDBCTemplate studentJDBCTemplate = null;

    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("application-beans.xml");
        studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
    }

    @Test
    public void testUpdate() {
        System.out.println("-----------------Updating Record with ID = 3-----------------");
        studentJDBCTemplate.update(3, 26);
        Student student = testGetStudentById(3);
        System.out.println(student.toString());
    }

    @Test
    public static void testListStudents() {
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

    @Test
    public void testInsert() {
        System.out.println("----------------------Records Creation-----------------------");
        studentJDBCTemplate.create("Maxsu", 19);
        studentJDBCTemplate.create("Minsu", 19);
        studentJDBCTemplate.create("Allen", 27);
    }

    @Test
    public void testDelete() {
        System.out.println("-----------------Delete Record with ID = 2-----------------");
        studentJDBCTemplate.delete(2);
    }

    @Test
    public void testGetStudentByStoredProcedure() {
        System.out.println("-----------------Get Student's Name By ID 1:-----------------");
        Student student = studentJDBCTemplate.getStudentByStoredProcedure(1);
        System.out.println(student);
    }

    @Test
    public void testGetStudentByStoreFun() {
        System.out.println("-----------------Get Student's Name By ID 3:-----------------");
        Student student = studentJDBCTemplate.getStudentByStoreFun(3);
        System.out.println(student);
    }

    @Test
    public void testUpdateStudentImageByBLOB() {
        System.out.println("-----------------Update Student's image By ID 1:-----------------");
        byte[] imageData = { 0, 1, 0, 8, 20, 40, 95 };
        studentJDBCTemplate.updateStudentImageByBLOB(1, imageData);
        Student student = testGetStudentById(1);
        System.out.println(student.toString());
    }

    @Test
    public void testUpdateStudentDescriptionByCOLB() {
        System.out.println("-----------------Update Student's description By ID 1:-----------------");
        String description = "This can be a very long text upto 4 GB of size.";
        studentJDBCTemplate.updateStudentDescriptionByCOLB(1, description);
        Student student = testGetStudentById(1);
        System.out.println(student.toString());
    }

    @Test
    public void testGetStudentById() {
        System.out.println("----------------------Get Student Recocrds By ID 1----------------");
        Student student = testGetStudentById(1);
        System.out.println(student.toString());
    }

    @Test
    public void testBatchUpdate() {
        System.out.println("----------------------Recocrds Creation----------------");
        studentJDBCTemplate.create("Maxsu", 21);
        studentJDBCTemplate.create("Curry", 22);
        studentJDBCTemplate.create("Weiwei", 25);
        testListStudents();

        System.out.println(testGetStudentById(1));
        System.out.println(testGetStudentById(3));
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
        System.out.println(testGetStudentById(1));
        System.out.println(testGetStudentById(3));
    }

    @Test
    public void testObjectBatchUpdate() {
        System.out.println("----------------------Recocrds Creation----------------");
        studentJDBCTemplate.create("Maxsu", 21);
        studentJDBCTemplate.create("Curry", 22);
        studentJDBCTemplate.create("Weiwei", 25);
        testListStudents();

        System.out.println(testGetStudentById(1));
        System.out.println(testGetStudentById(3));
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
        System.out.println(testGetStudentById(1));
        System.out.println(testGetStudentById(3));
    }

    @Test
    public void testMutipleBatchUpdate() {
        System.out.println("----------------------Recocrds Creation----------------");
        studentJDBCTemplate.create("Maxsu", 21);
        studentJDBCTemplate.create("Curry", 22);
        studentJDBCTemplate.create("Xiaowei", 25);
        testListStudents();

        System.out.println(testGetStudentById(1));
        System.out.println(testGetStudentById(3));
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
        System.out.println(testGetStudentById(1));
        System.out.println(testGetStudentById(3));
    }
    
    @Test
    public void testListStudentsWithResultSetExtractor() {
        List<Student> students = studentJDBCTemplate.listStudentsWithResultSetExtractor();
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
    
    @Test
    public void testCreateByParameters() {
        studentJDBCTemplate.createByParameters("Maxsu", 21);
        studentJDBCTemplate.createByParameters("Curry", 22);
        studentJDBCTemplate.createByParameters("Suzend", 23);
        testListStudents();
    }

    /*
     * get Student by id
     */
    public static Student testGetStudentById(Integer id) {
        System.out.println("----------------------Listing Multiple Recocrds----------------");
        return studentJDBCTemplate.getStudentById(id);
    }
}
