package org.chaofei.procedure;

import java.sql.Types;
import java.util.Map;

import javax.sql.DataSource;

import org.chaofei.entity.Student;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class StudentProcedure extends StoredProcedure {

    public StudentProcedure() {
        super();
    }
    
    public StudentProcedure(DataSource dataSource, String procedureName) {
        super(dataSource, procedureName);
        declareParameter(new SqlParameter("in_id", Types.INTEGER));
        declareParameter(new SqlOutParameter("out_name", Types.VARCHAR));
        declareParameter(new SqlOutParameter("out_age", Types.INTEGER));
    }
    
    public Student execute(Integer id) {
        Map<String, Object> out = super.execute(id);
        Student student = new Student();
        student.setId(id);
        student.setName((String) out.get("out_name"));
        student.setAge((Integer) out.get("out_age"));
        return student;
    }
}
