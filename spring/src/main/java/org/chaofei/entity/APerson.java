package org.chaofei.entity;

public class APerson {
    private String name;
    private Integer age;
    private String address;

    public APerson() {
        super();
    }
    
    public APerson(String name, Integer age, String address) {
        super();
        this.name = name;
        this.age = age;
        this.address = address;
    }


    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "APerson [name=" + name + ", age=" + age + ", address=" + address + "]";
    }
}
