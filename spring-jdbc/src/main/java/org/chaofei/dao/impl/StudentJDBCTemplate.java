package org.chaofei.dao.impl;

import java.io.ByteArrayInputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.chaofei.dao.StudentDAO;
import org.chaofei.dao.mapper.StudnetMapper;
import org.chaofei.entity.Student;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;

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
		System.out.println("Created Record Name = " + name + " Age = " + age);
	}

	public Student getStudentByStoredProcedure(Integer id) {
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getRecord");
		SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
		Map<String, Object> out = jdbcCall.execute(in);
		Student student = new Student();
		student.setId(id);
		student.setName((String) out.get("out_name"));
		student.setAge((Integer) out.get("out_age"));
		return student;
	}

	public List<Student> listStudents() {
		String SQL = "select * from student";
		List<Student> students = jdbcTemplateObject.query(SQL, new StudnetMapper());
		return students;
	}

	public void update(Integer id, Integer age) {
		String SQL = "update student set age = ? where id = ?";
		jdbcTemplateObject.update(SQL, age, id);
		System.out.println("Update Record with ID = " + id);
	}

	public void delete(Integer id) {
		String SQL = "delete from student where id = ?";
		jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted Record with ID = " + id);
	}

	public Student getStudentByStoreFun(Integer id) {
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withFunctionName("get_student_name");
		SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
		String name = jdbcCall.executeFunction(String.class, in);
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		return student;
	}

	public void updateStudentImageByBLOB(Integer id, byte[] imageData) {
		MapSqlParameterSource in = new MapSqlParameterSource();
		in.addValue("id", id);
		in.addValue("image", new SqlLobValue(new ByteArrayInputStream(imageData), 
				imageData.length, new DefaultLobHandler()), Types.BLOB);
		String SQL = "update student set image = :image where id = :id";
		NamedParameterJdbcTemplate jdbcTemplateObject = new NamedParameterJdbcTemplate(dataSource);
		jdbcTemplateObject.update(SQL, in);
		System.out.println("Updated Record with ID = " + id);
	}

	public Student getStudentById(Integer id) {
		MapSqlParameterSource in = new MapSqlParameterSource();
		in.addValue("id", id);
		String SQL = "select * from student where id = :id";
		NamedParameterJdbcTemplate jdbcTemplateObject = new NamedParameterJdbcTemplate(dataSource);
		System.out.println("Query Record with ID = " + id);
		Student student = jdbcTemplateObject.queryForObject(SQL, in, new StudnetMapper());
		return student;
	}

	public void updateStudentDescriptionByCOLB(Integer id, String description) {
		MapSqlParameterSource in = new MapSqlParameterSource();
		in.addValue("id", id);
		in.addValue("description", description);
		String SQL = "update student set description = :description where id = :id";
		NamedParameterJdbcTemplate jdbcTemplateObject = new NamedParameterJdbcTemplate(dataSource);
		jdbcTemplateObject.update(SQL, in);
		System.out.println("Updated Description Record with ID = " + id);
	}

	public void batchUpdate(final List<Student> students) {
		String SQL = "update student set age = ? where id = ?";
		int[] updateCounts = jdbcTemplateObject.batchUpdate(SQL, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setInt(1, students.get(i).getAge());
				ps.setInt(2, students.get(i).getId());
			}
			
			public int getBatchSize() {
				return students.size();
			}
		});
		
		System.out.println("Records updated! updateCounts = " + updateCounts.toString());
	}
}
