package org.chaofei.config;

import org.chaofei.core.CustomerBo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Bean(name="customerBo")
    public CustomerBo customerBo() {
        return new CustomerBo();
    }
}
