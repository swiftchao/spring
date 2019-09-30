package org.chaofei.common;

import org.chaofei.user.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppFilterAutoScan {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-filter-auto-scan.xml");
        UserService userService = (UserService) context.getBean("userService");
        System.out.println(userService);
    }
}
