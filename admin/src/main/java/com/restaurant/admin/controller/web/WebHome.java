package com.restaurant.admin.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebHome {

    @GetMapping("/")
    public String index(){
        return "login";
    }

}
