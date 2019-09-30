package org.chaofei.common;

import org.chaofei.customer.services.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppAutoScan {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-auto-scan.xml");
        CustomerService customerService = (CustomerService) context.getBean("customerService");
        System.out.println(customerService);
    }
}
