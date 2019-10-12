package org.chaofei.services;

import org.springframework.beans.factory.annotation.*;

public class CustomerService {
    String message;
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public void initIt() {
        System.out.println("Init method after properties are set : " + message);
    }
    
}
