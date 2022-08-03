package com.restaurant.admin.controller.web;

import com.restaurant.admin.entity.Menu;
import com.restaurant.admin.service.ServiceMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WebAdminMenu {

    @Autowired
    ServiceMenu serviceMenu;

    @RequestMapping()
    public String getMenu(Model model){
        List<Menu> menuList = serviceMenu.getMenu();
        model.addAttribute("menuList", menuList);
        return "";
    }

}
