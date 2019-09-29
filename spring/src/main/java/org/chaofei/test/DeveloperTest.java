package org.chaofei.test;

import org.chaofei.entity.Developer;
import org.chaofei.entity.Language;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeveloperTest {
    private static ApplicationContext context = null;
    
    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    
    @Test
    public void testLanguage() {
        Language language = (Language) context.getBean("language");
        System.out.println(language);
    }
    
    @Test
    public void testDeveloper() {
        Developer developer = (Developer) context.getBean("developer");
        System.out.println(developer);
    }
}
