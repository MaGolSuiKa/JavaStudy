package com.geekaca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {
    @RequestMapping("/register")
    @ResponseBody
    public String reg(@RequestParam("uname") String username
            , @RequestParam(required = true) String password){
        System.out.println(username);
        System.out.println(password);

        return "ok";
    }
}
