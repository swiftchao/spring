package org.chaofei.test;

import org.chaofei.output.OutputHelperConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OutputHelperConstructorTest {

    public static void main(String[] args) {
        String contextFileName = "OutputHelperConstructor.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(contextFileName);
        OutputHelperConstructor outputHelperConstructor = (OutputHelperConstructor) context
                .getBean("outputHelperConstructor");
        System.out.println(outputHelperConstructor);
        outputHelperConstructor.generateOutput();
    }

}
