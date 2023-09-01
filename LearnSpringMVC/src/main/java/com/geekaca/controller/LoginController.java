package com.geekaca.controller;

import com.geekaca.domain.User;
import com.geekaca.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService us;

    @RequestMapping("/input")
    public String login(String username, String password) {
        System.out.println("login start");
        System.out.println(username);
        System.out.println(password);
        User userInput = new User(username, password);
        int isLogin = us.login(userInput);
        if (isLogin>0){
            return "ok";
        }else {
            return "false";
        }
    }


}
