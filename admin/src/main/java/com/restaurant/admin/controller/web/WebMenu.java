package com.restaurant.admin.controller.web;

import com.restaurant.admin.dto.MenuAccompanimentDTO;
import com.restaurant.admin.dto.MenuDTO;
import com.restaurant.admin.dto.MenuIncludesDTO;
import com.restaurant.admin.dto.MenuOptionalDTO;
import com.restaurant.admin.entity.*;
import com.restaurant.admin.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
public class WebMenu {

    @Autowired
    ServiceMenu serviceMenu;

    @Autowired
    ServiceMenuType serviceMenuType;

    @Autowired
    ServiceMenuAccompaniment serviceMenuAccompaniment;

    @Autowired
    ServiceMenuIncludes serviceMenuIncludes;

    @Autowired
    ServiceMenuOptional serviceMenuOptional;

    @RequestMapping("/menu")
    public String getMenu(Model model){
        List<MenuDTO> menuList = serviceMenu.getMenu();
        model.addAttribute("menuList", menuList);
        return "pages/tables/menu-principal";
    }

    @RequestMapping("/createMenu")
    public String createMenu(Model model, Menu menu, @Nullable @RequestParam boolean create){
        if (create){
            serviceMenu.saveMenu(menu);
            return "redirect:/menu?success";
        }
        return "pages/forms/menu-form-create";
    }

    @RequestMapping("/editMenu")
    public String editMenu(Model model, Menu menu, @Nullable @RequestParam boolean edit, @RequestParam long id){
        Menu menuPrincipal = serviceMenu.getMenuId(id);
        if (edit){
            serviceMenu.saveMenu(menu);
            return "redirect:/menu?edit";
        }
        model.addAttribute("menuPrincipal", menuPrincipal);
        return "pages/forms/menu-form-edit";
    }

    @RequestMapping("/deleteMenu")
    public String deleteMenu(@RequestParam long id){
        serviceMenu.deleteById(id);
        return "redirect:/menu?delete";
    }


    @RequestMapping("/menuType")
    public String getMenuType(Model model){
        List<MenuType> menuTypeMenu = serviceMenuType.getMenuType();
        model.addAttribute("menuTypeMenu", menuTypeMenu);
        return "pages/tables/menu-type";
    }

    @RequestMapping("/createMenuType")
    public String createMenuType(MenuType menuType, @Nullable @RequestParam boolean create){

        if (create){
            serviceMenuType.saveMenuType(menuType);
            return "redirect:/menuType?success";
        }

        return "pages/forms/menu-type-form-create";
    }

    @RequestMapping("/editMenuType")
    public String editMenuType(Model model, MenuType menuType, @Nullable @RequestParam boolean edit, @RequestParam long id){
        MenuType menuTypePrincipal = serviceMenuType.getMenuTypeId(id);
        if (edit){
            serviceMenuType.saveMenuType(menuType);
            return "redirect:/menuType?edit";
        }
        model.addAttribute("menuTypePrincipal", menuTypePrincipal);
        return "pages/forms/menu-type-form-edit";
    }

    @RequestMapping("/deleteMenuType")
    public String deleteMenuType(@RequestParam long id){
        serviceMenuType.deleteById(id);
        return "redirect:/menuType?delete";
    }

    @RequestMapping("/menuAccompaniment")
    public String getMenuAccompaniment(Model model){
        List<MenuAccompanimentDTO> menuAccompaniments = serviceMenuAccompaniment.getMenuAccompanimentList();
        model.addAttribute("menuAccompaniments", menuAccompaniments);
        return "pages/tables/menu-accompaniment";
    }

    @RequestMapping("/createMenuAccompaniment")
    public String createMenuAccompaniment(Model model, MenuAccompaniment menuAccompaniment, @Nullable @RequestParam boolean create){
        List<MenuDTO> menuList = serviceMenu.getMenu();

        if (create){
            serviceMenuAccompaniment.saveMenuAccompaniment(menuAccompaniment);
            return "redirect:/menuAccompaniment?success";
        }

        model.addAttribute("menuList", menuList);
        return "pages/forms/menu-accompaniment-form-create";
    }

    @RequestMapping("/editMenuAccompaniment")
    public String editMenuAccompaniment(Model model, MenuAccompaniment menuAccompaniment, @Nullable @RequestParam boolean edit, @RequestParam long id){
        MenuAccompaniment menuAccompanimentPrincipal = serviceMenuAccompaniment.getMenuAccompanimentId(id);
        long idMenu = menuAccompanimentPrincipal.getIdMenu();
        Menu menu = serviceMenu.getMenuId(idMenu);
        if (edit){
            serviceMenuAccompaniment.saveMenuAccompaniment(menuAccompaniment);
            return "redirect:/menuAccompaniment?edit";
        }
        model.addAttribute("menu", menu);
        model.addAttribute("menuAccompanimentPrincipal", menuAccompanimentPrincipal);
        return "pages/forms/menu-accompaniment-form-edit";
    }

    @RequestMapping("/deleteMenuAccompaniment")
    public String deleteMenuAccompaniment(@RequestParam long id){
        serviceMenuAccompaniment.deleteMenuAccompaniment(id);
        return "redirect:/menuAccompaniment?delete";
    }

    @RequestMapping("/menuIncludes")
    public String getMenuIncludes(Model model){
        List<MenuIncludesDTO> menuIncludes = serviceMenuIncludes.getMenuIncludes();
        model.addAttribute("menuIncludes", menuIncludes);
        return "pages/tables/menu-includes";
    }

    @RequestMapping("/createMenuIncludes")
    public String createMenuIncludes(Model model, MenuIncludes menuIncludes, @Nullable @RequestParam boolean create){
        List<MenuDTO> menuList = serviceMenu.getMenu();

        if (create){
            serviceMenuIncludes.saveMenuInlcudes(menuIncludes);
            return "redirect:/menuIncludes?success";
        }

        model.addAttribute("menuList", menuList);
        return "pages/forms/menu-includes-form-create";
    }

    @RequestMapping("/editMenuIncludes")
    public String editMenuIncludes(Model model, MenuIncludes menuIncludes, @Nullable @RequestParam boolean edit, @RequestParam long id){
        MenuIncludes menuIncludesPrincipal = serviceMenuIncludes.getMenuIncludesById(id);
        long idMenu = menuIncludesPrincipal.getIdMenu();
        Menu menu = serviceMenu.getMenuId(idMenu);
        if (edit){
            serviceMenuIncludes.saveMenuInlcudes(menuIncludes);
            return "redirect:/menuIncludes?edit";
        }
        model.addAttribute("menu", menu);
        model.addAttribute("menuIncludesPrincipal", menuIncludesPrincipal);
        return "pages/forms/menu-includes-form-edit";
    }

    @RequestMapping("/deleteMenuIncludes")
    public String deleteMenuIncludes(@RequestParam long id){
        serviceMenuIncludes.deleteMenuInclcudes(id);
        return "redirect:/menuIncludes?delete";
    }

    @GetMapping("/menuOptional")
    public String getMenuOptional(Model model){
        List<MenuOptionalDTO> menuOptionals = serviceMenuOptional.getMenuOptionals();
        model.addAttribute("menuOptionals", menuOptionals);
        return "pages/tables/menu-optional";
    }


    @RequestMapping("/createMenuOptional")
    public String createMenuOptional(Model model, MenuOptional menuOptional, @Nullable @RequestParam boolean create){
        List<MenuDTO> menuList = serviceMenu.getMenu();

        if (create){
            serviceMenuOptional.saveMenuOptional(menuOptional);
            return "redirect:/menuOptional?success";
        }

        model.addAttribute("menuList", menuList);
        return "pages/forms/menu-optionals-form-create";
    }

    @RequestMapping("/editMenuOptional")
    public String editMenuOptional(Model model, MenuOptional menuOptional, @Nullable @RequestParam boolean edit, @RequestParam long id){
        MenuOptional menuOptionalPrincipal = serviceMenuOptional.getMenuOptionalById(id);
        long idMenu = menuOptionalPrincipal.getIdMenu();
        Menu menu = serviceMenu.getMenuId(idMenu);
        if (edit){
            serviceMenuOptional.saveMenuOptional(menuOptional);
            return "redirect:/menuOptional?edit";
        }
        model.addAttribute("menu", menu);
        model.addAttribute("menuOptionalPrincipal", menuOptionalPrincipal);
        return "pages/forms/menu-optionals-form-edit";
    }

    @RequestMapping("/deleteMenuOptional")
    public String deleteMenuOptional(@RequestParam long id){
        serviceMenuOptional.deleteMenuOptional(id);
        return "redirect:/menuOptional?delete";
    }


}
