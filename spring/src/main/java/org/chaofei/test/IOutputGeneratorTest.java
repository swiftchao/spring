package org.chaofei.test;

import org.chaofei.output.IOutputGenerator;
import org.chaofei.output.impl.CsvOutputGenerator;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOutputGeneratorTest {
    private static ApplicationContext context = null;
    
    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    
    @Test
    public void testGenerateoutput() {
       IOutputGenerator output = new CsvOutputGenerator();
       output.generateoutput();
    }
}
