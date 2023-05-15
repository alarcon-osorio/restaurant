package com.restaurant.admin.controller;

import com.restaurant.admin.entity.MeasureUnit;
import com.restaurant.admin.security.entity.Users;
import com.restaurant.admin.service.ServiceUsers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.yaml.snakeyaml.tokens.ScalarToken;

import java.util.List;

@Slf4j
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

    @RequestMapping("/createUsers")
    public String createUsers(Model model, Users users, @Nullable @RequestParam boolean create){

        if (create){
            try {
                String password = users.getPassword();
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String hashedPassword = passwordEncoder.encode(password);

                users.setPassword(hashedPassword);
                users.setEnabled(true);

                serviceUsers.saveUsers(users);
                return "redirect:/users?success";
            }catch (Exception ex) {
                return "redirect:/createUsers?exception&create=false";
            }

        }

        return "pages/forms/users-form-create";
    }

    @RequestMapping("/editUsers")
    public String editMeasureUnits(Model model, Users users, @Nullable @RequestParam boolean edit, @RequestParam long id){
        Users usersPrincipal = serviceUsers.findUserById(id);
        String password = usersPrincipal.getPassword();

        if (edit){
            try {
                String hashedPassword = users.getPassword();
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

                if (passwordEncoder.matches(password, hashedPassword)) {
                    users.setPassword(hashedPassword);
                }else{
                    String updatePass = users.getPassword();
                    String updatePassHashed = passwordEncoder.encode(updatePass);

                    users.setPassword(updatePassHashed);
                }

                serviceUsers.saveUsers(users);
                return "redirect:/users?edit";
            }catch (Exception ex) {
                return "redirect:/createUsers?exception&create=false";
            }
        }

        model.addAttribute("usersPrincipal", usersPrincipal);
        return "pages/forms/users-form-edit";
    }

    @RequestMapping("/deleteUsers")
    public String deleteMeasureUnits(@RequestParam long id){
        serviceUsers.deleteUsers(id);
        return "redirect:/users?delete";
    }


}
