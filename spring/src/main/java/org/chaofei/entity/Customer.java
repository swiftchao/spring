package org.chaofei.entity;
/**
 * 1.注解的类必须得有无参构造函数
 * 2.注解必须得有set方法
 * 3.想要输出好看必须重写toString方法
 * @author chaofei
 *
 */
public class Customer {
    public Customer() {
        super();
    }

    private Person person;
    
    public Customer(Person person) {
        this.person = person;
    }
    
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Customer [person=" + person + "]";
    }
}
