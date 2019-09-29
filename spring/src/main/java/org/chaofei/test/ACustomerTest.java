package org.chaofei.test;

import org.chaofei.entity.ACustomer;
import org.chaofei.entity.APerson;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ACustomerTest {
    private static ApplicationContext context = null;
    
    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    
    @Test
    public void testAPerson() {
        APerson aperson = (APerson) context.getBean("aperson");
        System.out.println(aperson);
    }
    
    @Test
    public void testACustomer() {
        ACustomer acustomer = (ACustomer) context.getBean("acustomer");
        System.out.println(acustomer);
    }
}
