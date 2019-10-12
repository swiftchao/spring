package org.chaofei.test;

import org.chaofei.output.OutputHelperSetter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OutputHelperSetterTest {

    public static void main(String[] args) {
        String contextFileName = "OutputHelperSetter.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(contextFileName);
        OutputHelperSetter outputHelperSetter =  (OutputHelperSetter) context.getBean("outputHelperSetter");
        System.out.println(outputHelperSetter);
        outputHelperSetter.generateOutput();
    }
    
}
