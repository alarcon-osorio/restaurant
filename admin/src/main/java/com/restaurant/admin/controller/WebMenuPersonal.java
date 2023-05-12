package com.restaurant.admin.controller;

import com.restaurant.admin.dto.MenuDTO;
import com.restaurant.admin.dto.MenuPersonalDTO;
import com.restaurant.admin.dto.MenuPersonalFormDTO;
import com.restaurant.admin.dto.MenuPersonalTypeDTO;
import com.restaurant.admin.entity.*;
import com.restaurant.admin.service.ServiceMenuPersonalForm;
import com.restaurant.admin.service.ServiceMenuPersonalType;
import com.restaurant.admin.service.ServiceMenuPersonalView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
public class WebMenuPersonal {

    @Autowired
    ServiceMenuPersonalForm serviceMenuPersonalForm;

    @Autowired
    ServiceMenuPersonalType serviceMenuPersonalType;

    @Autowired
    ServiceMenuPersonalView serviceMenuPersonalView;

    @RequestMapping("/menuPersonalForm")
    public String getMenuPersonalForm(Model model){
        List<MenuPersonalFormDTO> menuPersonalFormDTOList = serviceMenuPersonalForm.getMenuPersonalFormDTO();
        model.addAttribute("menuPersonalFormDTOList", menuPersonalFormDTOList);
        return "pages/tables/menu-personal-form";
    }

    @RequestMapping("/createMenuPersonalForm")
    public String createMenuPersonalForm(Model model, MenuPersonalForm menuPersonalForm, @Nullable @RequestParam boolean create){
        List<MenuPersonalType> menuPersonalTypeList = serviceMenuPersonalType.getMenuType();

        if (create){
            serviceMenuPersonalForm.saveMenuPersonalForm(menuPersonalForm);
            return "redirect:/menuPersonalForm?success";
        }

        model.addAttribute("menuPersonalTypeList", menuPersonalTypeList);
        return "pages/forms/menu-personal-options-form-create";
    }

    @RequestMapping("/editMenuPersonalForm")
    public String editMenuPersonalForm(Model model, MenuPersonalForm menuPersonalForm, @Nullable @RequestParam boolean edit, @RequestParam long id){
        MenuPersonalForm menuPersonalFormPrincipal = serviceMenuPersonalForm.getMenuPersonalById(id);
        long idMenuType = menuPersonalFormPrincipal.getType();
        MenuPersonalTypeDTO menuPersonalTypeDTO = serviceMenuPersonalType.getMenuTypeName(idMenuType);
        if (edit){
            serviceMenuPersonalForm.saveMenuPersonalForm(menuPersonalForm);
            return "redirect:/menuPersonalForm?edit";
        }
        model.addAttribute("menuPersonalTypeDTO", menuPersonalTypeDTO);
        model.addAttribute("menuPersonalFormPrincipal", menuPersonalFormPrincipal);
        return "pages/forms/menu-personal-options-form-edit";
    }

    @RequestMapping("/deleteMenuPersonalForm")
    public String deleteMenuOptional(@RequestParam long id){
        serviceMenuPersonalForm.deleteMenuPersonalForm(id);
        return "redirect:/menuPersonalForm?delete";
    }

    @RequestMapping("/menuPersonalType")
    public String menuPersonalType(Model model){
        List<MenuPersonalType> menuPersonalTypeList = serviceMenuPersonalType.getMenuType();
        model.addAttribute("menuPersonalTypeList", menuPersonalTypeList);
        return "pages/tables/menu-personal-type";
    }

    @RequestMapping("/menuPersonalView")
    public String menuPersonalView(Model model){
        List<MenuPersonalDTO> menuPersonalListDTO = serviceMenuPersonalView.getMenuPersonalListDTO();
        model.addAttribute("menuPersonalListDTO", menuPersonalListDTO);
        return "pages/tables/menu-personal-view";
    }


}
