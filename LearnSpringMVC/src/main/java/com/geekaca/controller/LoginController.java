package com.geekaca.controller;

import com.geekaca.domain.User;
import com.geekaca.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService us;

    @RequestMapping("/input")
    @ResponseBody
    public String login(String username, String password) {
        System.out.println("login start");

        User userInput = new User(username, password);
        boolean isLogin = us.login(userInput);
        if (isLogin){
            return "登录成功";
        }else {
            return "登录失败";
        }
    }


}
