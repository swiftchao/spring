package org.chaofei.test;

import org.chaofei.config.AppConfig;
import org.chaofei.hello.HelloWorld;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldTest {
    private static ApplicationContext context = null;
    
    @Before
    public void setup() {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        
    }
    
    @Test
    public void testPrintHelloWorld() {
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloBean");
        helloWorld.printHelloWorld("Spring Java Config");
    }
}
