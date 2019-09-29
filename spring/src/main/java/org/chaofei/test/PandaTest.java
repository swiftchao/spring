package org.chaofei.test;

import org.chaofei.entity.KungFu;
import org.chaofei.entity.Panda;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PandaTest {
 private static ApplicationContext context = null;
    
    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    
    @Test
    public void testKungFu() {
        KungFu kungfu = (KungFu) context.getBean("kungfu");
        System.out.println(kungfu);
    }
    
    @Test
    public void testPanda() {
        Panda panda = (Panda) context.getBean("panda");
        System.out.println(panda);
    }
}
