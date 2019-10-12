package org.chaofei.util;

import java.util.HashMap;
import java.util.Map;

import org.chaofei.customer.dao.CustomerDAO;
import org.chaofei.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoBase {
    
    public static DemoBase instance;
    
    private Map<String, DemoUtil> registerdDrivers = new HashMap<String, DemoUtil>();

    public static void setInstance(DemoBase instance) {
        DemoBase.instance = instance;
    }

    public DemoBase(){
        registerDrivers();
    }

    public static DemoBase getInstance(){
        if (instance == null){
            instance = new DemoBase();
        }
        return instance;
    }

    private void registerDrivers(){
        registerDriver(DemoUtil.getInstance());
    }
    
    private void registerDriver(DemoUtil driver){
        registerdDrivers.put("OPS", driver);
    }
    
    public void testDemo() {
        DemoUtil demoUtil = registerdDrivers.get("OPS"); 
        demoUtil.testCustomer();
    }
    
    public DemoUtil getDemoUtil() {
        return registerdDrivers.get("OPS"); 
    }
}
