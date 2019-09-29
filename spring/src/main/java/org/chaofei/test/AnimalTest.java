package org.chaofei.test;

import org.chaofei.entity.Ability;
import org.chaofei.entity.Animal;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnimalTest {
 private static ApplicationContext context = null;
    
    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    
    @Test
    public void testAbility() {
        Ability ability = (Ability) context.getBean("ability");
        System.out.println(ability);
    }
    
    @Test
    public void testAnimal() {
        Animal animal = (Animal) context.getBean("animal");
        System.out.println(animal.toString());
    }
    
    
    /* 测试报按类型自动装配报错的函数
    @Test
    public void testAnimal2() {
        Animal animal = (Animal) context.getBean("animaltest");
        System.out.println(animal.toString());
    }
    */
}
