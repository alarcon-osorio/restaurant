package com.restaurant.admin.controller;

import com.restaurant.admin.security.entity.Users;
import com.restaurant.admin.service.ServiceUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WebUsers {

    @Autowired
    ServiceUsers serviceUsers;

    @RequestMapping("/users")
    public String getUsers(Model model){
        List<Users> usersList = serviceUsers.findUsers();
        model.addAttribute("usersList", usersList);
        return "pages/tables/users";
    }

}
