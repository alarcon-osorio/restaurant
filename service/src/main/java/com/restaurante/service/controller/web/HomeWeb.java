package com.restaurante.service.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeWeb {

    @RequestMapping(value = "/")
    public String index(){
        return "login";
    }

}
