package org.chaofei.core;

import org.chaofei.config.AppConfig;
import org.chaofei.hello.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloBean");
        helloWorld.printHelloWorld("Spring Java Config");
    }
}
