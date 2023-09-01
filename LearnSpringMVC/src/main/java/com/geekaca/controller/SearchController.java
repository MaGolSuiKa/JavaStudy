package com.geekaca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/search")
public class SearchController {

    @RequestMapping("/all")
    @ResponseBody
    public void findBrand(){

    }
}
