package org.chaofei.test;

import org.chaofei.output.OutputSpringHelper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OutputSpringHelperTest {
    private static ApplicationContext context = null;
    
    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    
    @Test
    public void testGeneratorOutput() {
        OutputSpringHelper output = (OutputSpringHelper) context.getBean("outputSpringHelper");
        output.generateOutput();
    }
}
