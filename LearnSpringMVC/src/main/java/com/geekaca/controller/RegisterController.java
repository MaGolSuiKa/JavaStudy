package com.geekaca.controller;

import com.geekaca.domain.User;
import com.geekaca.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private UserService us;

    @RequestMapping("/input")
    public String reg(@RequestParam("uname") String username
            , @RequestParam(required = true) String password){
        User user = new User(username,password);
        int register = us.register(user);
        if (register>0){
            return "ok";
        }else{
            return "error";
        }

    }
}
