package org.chaofei.common;

import org.chaofei.util.DemoBase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppDemoUtil {
    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-auto-scan.xml");
        DemoBase demoBase = (DemoBase) context.getBean("demoBase");
        demoBase.testDemo();
    }
}
