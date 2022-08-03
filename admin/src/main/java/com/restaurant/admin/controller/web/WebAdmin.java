package com.restaurant.admin.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebAdmin {

    @RequestMapping("/admin")
    public String viewAdmin(Model model){
        return "viewAdmin";
    }

    @RequestMapping("/menu")
    public String viewMenuPage(Model model){
        return "pages/tables/basic-table";
    }
}
