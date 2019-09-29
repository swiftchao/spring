package org.chaofei.test;

import org.chaofei.core.HelloWorld;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HellWorldTest {
    private static ApplicationContext context = null;
    
    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    
    @Test
    public void testPringHello() {
        HelloWorld hello = (HelloWorld) context.getBean("helloBean");
        hello.pringHello();
    }
    
}
