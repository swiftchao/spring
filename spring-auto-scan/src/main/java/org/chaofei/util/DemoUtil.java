package org.chaofei.util;

import org.chaofei.customer.dao.CustomerDAO;
import javax.annotation.PostConstruct;
import org.chaofei.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoUtil {
    @Autowired
    private Customer customer;
    @Autowired
    private CustomerDAO customerDAO;
    
    public static DemoUtil instance;
    
    @PostConstruct
    public void init() throws Exception {
        System.out.println("initialize DemoUtil.........");
        System.out.println("instance: " + instance);
        System.out.println("this: " + this);
        System.out.println("instance.customer: " + instance.customer);
        System.out.println("this.customer: " + this.customer);
        instance = this;
        instance.customer = this.customer;
        instance.customerDAO = this.customerDAO;
        System.out.println("InitEnd === instance.customer: " + instance.customer);
    }
    
    public static DemoUtil getInstance() {
        if (null == instance) {
            instance = new DemoUtil();
        }
        return instance;
    }
    
    public  void testCustomer() {
        System.out.println("test === instance: " + instance);
        System.out.println("test === instance.customer: " + instance.customer);
        System.out.println("test === this.customer: " + this.customer);
        if (null == instance.customer) {
            System.out.println("null =========");
        } else {
            System.out.println("OK--------");
            instance.customer.sayHello();
        }
    }
}
