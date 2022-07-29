package com.restaurant.warehouse.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebHome {

    @GetMapping(value = "/")
    public String home(){
        return "index";
    }

}
