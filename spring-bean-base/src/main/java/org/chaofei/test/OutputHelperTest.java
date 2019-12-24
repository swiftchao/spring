package org.chaofei.test;

import org.chaofei.output.OutputHelper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OutputHelperTest {

    public static void main(String[] args) {
        //要调用的Driver方法入参
        Map<String, String> args = new HashMap<>();
        args.put("subnet_id", (String) map.get("subnet_id"));
        args.put("subnet_type", (String) map.get("subnet_type"));
        args.put("resourcezone_id", (String) map.get("resourcezone_id"));
        args.put("router_id", (String) map.get("router_id"));
        JSONObject.toJSONString(args);
    }
    
    static void test(Integer length) {
        if (null != length) {
            System.out.println("nnnnnnnnnnnnn");
        } else {
            System.out.println("=-=------");
        }
    }

}
