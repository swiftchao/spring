package org.chaofei.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.chaofei.entity.Student;
import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<Student> {
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        student.setAge(rs.getInt("age"));
        student.setImage(rs.getBytes("image"));
        student.setDescription(rs.getString("description"));
        return student;
    }
}