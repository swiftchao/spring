package org.chaofei.test;

import org.chaofei.entity.Customer;
import org.chaofei.entity.Person;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerTest {
    private static ApplicationContext context = null;
    
    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    
    @Test
    public void testPerson() {
        Person person = (Person) context.getBean("person");
        System.out.println(person.toString());
    }
    
    @Test
    public void testGeneratorOutput() {
        Customer customer = (Customer) context.getBean("customer");
        System.out.println(customer.toString());
    }
}
