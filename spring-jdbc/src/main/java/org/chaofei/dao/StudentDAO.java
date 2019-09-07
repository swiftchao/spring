package org.chaofei.dao;

import java.util.List;

import javax.sql.DataSource;

import org.chaofei.entity.Student;

public interface StudentDAO {
	/**
	 * this is the method to be used to initialize database resources ie. connection.
	 * @param ds
	 */
	public void setDataSource(DataSource ds);
	
	/**
	 * This is the method to be used to create a record in the Student table.
	 * @param name
	 * @param age
	 */
	public void create(String name, Integer age);
	
	public Student getStudentByStoredProcedure(Integer id);
	
	public Student getStudentByStoreFun(Integer id);

	/**
	 * This is the method to be used to list down all the records from the Student table.
	 * @return
	 */
	public List<Student> listStudents();
	
	/**
	 * This is the method to be used to update a record into the Student table.
	 * @param id
	 * @param age
	 */
	public void update(Integer id, Integer age);
	
	/**
	 * This is the method to be used to delete a record from the Student table corresponding to a passed student id.
	 * @param id
	 */
	public void delete(Integer id);
	
	public void updateStudentImageByBLOB(Integer id, byte[] imageData);
	
	public Student getStudentById(Integer id);
}
