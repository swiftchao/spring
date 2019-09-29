package org.chaofei.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
/**
 * @author chaofei
 *   但是，两个类似的 bean "org.chaofei.entity.APerson" 在 bean 配置文件中声明。
 * Spring会知道哪个person bean应当自动装配？
 *   要解决上述问题，需要使用 @Quanlifier 告诉Spring哪些bean应当自动装配。
 */
public class ACustomer {
    // @Autowired 字段
    // Spring不能找到一个匹配的Bean，person属性将不设定
//    @Autowired(required=false)
    @Autowired
    @Qualifier("aperson2")
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
