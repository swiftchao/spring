package org.chaofei.config;

import org.chaofei.hello.HelloWorld;
import org.chaofei.hello.impl.HelloWorldImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author chaofei
 * Spring3 JavaConfig它等效于 @Import 功能
 */
@Configuration
public class AppConfig {

    @Bean(name="helloBean")
    public HelloWorld helloWorld() {
        return new HelloWorldImpl();
    }
}
