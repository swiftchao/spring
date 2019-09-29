package org.chaofei.entity;

import org.springframework.beans.factory.annotation.Autowired;

public class ACustomer {
    //you want autowired this field
    //  @Autowired 字段
    @Autowired
    // Spring不能找到一个匹配的Bean，person属性将不设定
//    @Autowired(required=false)
    private APerson aperson;
    private int type;
    private String action;

    public ACustomer() {
        super();
    }
    
    //  @Autowired 构造方法
//    @Autowired
    public ACustomer(APerson aperson) {
        super();
        this.aperson = aperson;
    }
    
    public ACustomer(APerson aperson, int type, String action) {
        super();
        this.aperson = aperson;
        this.type = type;
        this.action = action;
    }

    public APerson getAperson() {
        return aperson;
    }
    
    public void setAperson(APerson aperson) {
        this.aperson = aperson;
    }

    public int getType() {
        return type;
    }
    
    public void setType(int type) {
        this.type = type;
    }
    
    public String getAction() {
        return action;
    }
    
    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "ACustomer [aperson=" + aperson + ", type=" + type + ", action=" + action + "]";
    }
}
