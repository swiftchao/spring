package org.chaofei.test;

import org.chaofei.common.MailMail;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MailMailTest {
    @Test
    public void setup() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mail.xml");
        MailMail mm = (MailMail) context.getBean("mailMail");
        String from = "smtp.qq.com";
        String to = "chaofeibest@163.com";
        String subnet = "Testing Email-1";
        String msg = "Testing only \\n\\n Hello Spring Email Sender";
        mm.sendMail(from, to, subnet, msg);
    }
}
