package com.geekaca;

import com.geekaca.config.SpringConfig;
import com.geekaca.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test01 {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        //面向接口，不受接口实现类的影响，解除耦合

        AccountService accountService = ctx.getBean(AccountService.class);
        accountService.transfer("Jerry", "Tom", 100D);

    }
}
