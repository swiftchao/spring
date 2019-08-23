package org.chaofei.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.chaofei.dao.StudentDAO;
import org.chaofei.dao.mapper.StudnetMapper;
import org.chaofei.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentJDBCTemplate implements StudentDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	public void create(String name, Integer age) {
		String SQL = "insert into student (name, age) values (?, ?)";
		jdbcTemplateObject.update(SQL, name, age);
	}

	public Student getStudent(Integer id) {
		return null;
	}

	public List<Student> listStudents() {
		String SQL = "select * from student";
		List<Student> students = jdbcTemplateObject.query(SQL, new StudnetMapper());
		return students;
	}
	
}
