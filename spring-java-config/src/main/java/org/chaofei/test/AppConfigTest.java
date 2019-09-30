package org.chaofei.test;

import org.chaofei.config.AllAppConfig;
import org.chaofei.core.CustomerBo;
import org.chaofei.core.SchedulerBo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppConfigTest {
    private static ApplicationContext context = null;
    
    @Before
    public void setup() {
        context = new AnnotationConfigApplicationContext(AllAppConfig.class);
    }
    
    @Test
    public void testCustomerBo() {
        CustomerBo customerBo = (CustomerBo) context.getBean("customerBo");
        customerBo.printMsg("Hello 666");
    }
    
    @Test
    public void testSchedulerBo() {
        SchedulerBo schedulerBo = (SchedulerBo) context.getBean("schedulerBo");
        schedulerBo.printMsg("Hello 888");
    }
    
}
