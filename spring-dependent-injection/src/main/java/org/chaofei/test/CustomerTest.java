package org.chaofei.test;

import org.chaofei.common.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerTest {
    public static void main(String[] args) {
        String contextFileName = "Customer.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(contextFileName);
        Customer customer = (Customer) context
                .getBean("customer");
        System.out.println(customer);
    }
}
