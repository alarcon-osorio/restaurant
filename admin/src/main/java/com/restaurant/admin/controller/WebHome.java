package com.restaurant.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebHome {

    @GetMapping("/")
    public String index(){
        return "login";
    }

}
