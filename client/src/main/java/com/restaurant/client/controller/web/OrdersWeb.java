package com.restaurant.client.controller.web;

import com.restaurant.client.entity.*;
import com.restaurant.client.entity.menu_personal.MenuPersonal;
import com.restaurant.client.entity.menu_personal.MenuPersonalForm;
import com.restaurant.client.service.*;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
public class OrdersWeb {

    @Autowired
    public ServiceOrders serviceOrders;

    @Autowired
    public ServiceMenuAccompaniment serviceMenuAccompaniment;

    @Autowired
    public ServiceMenuIncludes serviceMenuIncludes;

    @Autowired
    ServiceMenuOptional serviceMenuOptional;

    @Autowired
    ServiceMenuPersonalView serviceMenuPersonalView;

    @Autowired
    ServiceMenuPersonalForm serviceMenuPersonalForm;

    @RequestMapping(value = "/orders")
    public String orders(Model model, long table, boolean add, String username){

        log.info("objeto --> " + username);
        List<ServiceOrder> neatOrderList = serviceOrders.getNeatOrderByTable(table);


        List<String> tableNumberList = serviceOrders.getTableNumber();
        model.addAttribute("tableNumberList", tableNumberList);

        if (table == 0){
            List<ServiceOrder> serviceOrderList = serviceOrders.getServiceOrderByUser(username);
            if (serviceOrderList.isEmpty()){
                model.addAttribute("withOutOrders", "ok");
            }
            model.addAttribute("serviceOrderList", serviceOrderList);
            model.addAttribute("table", table);
            return "viewOrders";
        }

        try{
            List<ServiceOrder> serviceOrdersByTableNumber = serviceOrders.getByTableNumber(table);

            if (serviceOrdersByTableNumber.isEmpty()){
                model.addAttribute("table", table);
                model.addAttribute("empty", "ok");
                return "viewOrders";
            }

            for(ServiceOrder serviceOrder : serviceOrdersByTableNumber){
                if (serviceOrder.getOrdered() == 1 && serviceOrder.getPrepare() == 0) {
                    model.addAttribute("ordered", "ok");
                }else if (serviceOrder.getPrepare() == 1 && serviceOrder.getPrepared() == 0 && serviceOrder.getServed() == 0){
                    model.addAttribute("prepare", "ok");
                }else if(serviceOrder.getPrepare() == 1 && serviceOrder.getPrepared() == 1 && serviceOrder.getServed() == 0){
                    model.addAttribute("prepared", "ok");
                }else if (serviceOrder.getPrepare() == 1 && serviceOrder.getPrepared() == 1 && serviceOrder.getServed() == 1){
                    model.addAttribute("served", "ok");
                }
            }

            model.addAttribute("serviceOrdersByTableNumber", serviceOrdersByTableNumber);
            model.addAttribute("table", table);

            if(add){
                model.addAttribute("success", "ok");
            }

            return "viewOrders";

        }catch (NullPointerException ex){
            List<ServiceOrder> serviceOrderList = serviceOrders.getServiceOrderByUser(username);
            model.addAttribute("serviceOrderList", serviceOrderList);
        }
        return "viewOrders";

    }

    @RequestMapping(value = "/confirm_order")
    public String confirmOrder(Model model, @RequestParam long table){
        serviceOrders.saveOrderTable(table);
        return "redirect:/orders?table=" + table + "&add=true";
    }

    @RequestMapping(value = "/edit_order_table")
    public String editOrderTable(Model model, @RequestParam long id, boolean edit) {
        ServiceOrder serviceOrderById = serviceOrders.getServiceOrderById(id);

        List<MenuAccompaniment> menuAccompaniment = serviceMenuAccompaniment.getMenuAccompanimentList();
        List<MenuIncludes> menuIncludesList = serviceMenuIncludes.getMenuIncludesList();
        List<MenuOptional> menuOptionalList = serviceMenuOptional.getMenuOptional();
        List<String> menuAccompanimentDistinct = serviceMenuAccompaniment.getMenuAccompanimentDistinct();
        if (edit){
            model.addAttribute("success", "ok");
        }

        List<MenuPersonalForm> menuPersonalFormOptions = serviceMenuPersonalForm.getMenuPersonalFormByType(1);
        List<MenuPersonalForm> menuPersonalFormPrinciples = serviceMenuPersonalForm.getMenuPersonalFormByType(2);
        List<MenuPersonalForm> menuPersonalFormProteins = serviceMenuPersonalForm.getMenuPersonalFormByType(3);
        List<MenuPersonalForm> menuPersonalFormEntries = serviceMenuPersonalForm.getMenuPersonalFormByType(4);
        List<MenuPersonalForm> menuPersonalFormVegetables = serviceMenuPersonalForm.getMenuPersonalFormByType(5);
        List<MenuPersonalForm> menuPersonalFormSalad = serviceMenuPersonalForm.getMenuPersonalFormByType(6);
        List<MenuPersonalForm> menuPersonalFormDrinks = serviceMenuPersonalForm.getMenuPersonalFormByType(7);

        model.addAttribute("menuPersonalFormOptions", menuPersonalFormOptions);
        model.addAttribute("menuPersonalFormPrinciples", menuPersonalFormPrinciples);
        model.addAttribute("menuPersonalFormProteins", menuPersonalFormProteins);
        model.addAttribute("menuPersonalFormEntries", menuPersonalFormEntries);
        model.addAttribute("menuPersonalFormVegetables", menuPersonalFormVegetables);
        model.addAttribute("menuPersonalFormSalad", menuPersonalFormSalad);
        model.addAttribute("menuPersonalFormDrinks", menuPersonalFormDrinks);

        model.addAttribute("serviceOrderById", serviceOrderById);
        model.addAttribute("menuAccompaniment", menuAccompaniment);
        model.addAttribute("menuIncludesList", menuIncludesList);
        model.addAttribute("menuOptionalList", menuOptionalList);
        model.addAttribute("menuAccompanimentDistinct", menuAccompanimentDistinct);


        return "viewEditOrders";
    }

    @RequestMapping(value = "/edit_order_table_restaurant")
    public String editOrderTableRestaurant(Model model, @RequestParam long id, boolean edit) {
        ServiceOrder serviceOrderById = serviceOrders.getServiceOrderById(id);

        List<MenuAccompaniment> menuAccompaniment = serviceMenuAccompaniment.getMenuAccompanimentList();
        List<MenuIncludes> menuIncludesList = serviceMenuIncludes.getMenuIncludesList();
        List<MenuOptional> menuOptionalList = serviceMenuOptional.getMenuOptional();
        List<String> menuAccompanimentDistinct = serviceMenuAccompaniment.getMenuAccompanimentDistinct();
        if (edit){
            model.addAttribute("success", "ok");
        }
        model.addAttribute("serviceOrderById", serviceOrderById);
        model.addAttribute("menuAccompaniment", menuAccompaniment);
        model.addAttribute("menuIncludesList", menuIncludesList);
        model.addAttribute("menuOptionalList", menuOptionalList);
        model.addAttribute("menuAccompanimentDistinct", menuAccompanimentDistinct);

        return "viewEditOrdersRestaurant";
    }

    @RequestMapping(value = "/order_table")
    public String orderTable(Model model, @RequestParam long id, @RequestParam long table, boolean add, String username) {
        serviceOrders.saveOrderTableById(id);
        model.addAttribute("orderTable", "ok");
        return "redirect:/orders?table="  + table + "&add=" + add + "&username=" + username;
    }

    @RequestMapping(value = "/cancel_order_table")
    public String cancelOrderTable(Model model, @RequestParam long id, @RequestParam String username) {
        serviceOrders.orderTableCancel(id);
        model.addAttribute("orderTableCancel", "ok");
        return "redirect:/orders?table=0&username=" + username;
    }

    @RequestMapping(value = "/cancel_order")
    public String cancelOrder(Model model, @RequestParam long table, @RequestParam String username) {
        serviceOrders.cancelOrder(table);
        model.addAttribute("cancelOrder", "ok");
        return "redirect:/orders?table=0&username=" + username;
    }

    @RequestMapping(value = "/save_table")
    public String saveTable(Model model, ServiceOrder serviceOrder) {
        serviceOrders.saveOrder(serviceOrder);
        if (serviceOrder.getIdMenuType() == 2){
            model.addAttribute("saveTable", "ok");
            return "redirect:/edit_order_table_restaurant?id=" + serviceOrder.getId() + "&edit=true";
        }

        model.addAttribute("saveTable", "ok");
        return "redirect:/edit_order_table?id=" + serviceOrder.getId() + "&edit=true";
    }

    @RequestMapping(value = "/served")
    public String served(Model model, @RequestParam long id, @RequestParam long table ) {
        serviceOrders.saveOrderServed(id);
        model.addAttribute("served", "ok");
        return "redirect:/orders?table=" + table;
    }

    @RequestMapping(value = "/saveOrder")
    public String saveOrder(ServiceOrder serviceOrder){

        if (serviceOrder.getObservations().isEmpty()){
            serviceOrder.setObservations("Sin Observaciones");
        }

        serviceOrder.setOrdered(0);
        serviceOrder.setPrepared(0);
        serviceOrder.setPrepare(0);
        serviceOrder.setServed(0);
        serviceOrder.setClose(0);
        serviceOrder.setCancel(0);
        serviceOrder.setCancel(0);
        serviceOrder.setDiscount(0);
        serviceOrders.saveOrder(serviceOrder);
        return "redirect:/orders?table=0&success&username=" + serviceOrder.getUsername();
    }

    @RequestMapping(value = "/saveOrderPersonal")
    public String saveOrderPersonal(ServiceOrder serviceOrder){

        if (serviceOrder.getObservations().isEmpty()){
            serviceOrder.setObservations("Sin Observaciones");
        }
        serviceOrder.setOrdered(0);
        serviceOrder.setPrepared(0);
        serviceOrder.setPrepare(0);
        serviceOrder.setServed(0);
        serviceOrder.setClose(0);
        serviceOrder.setCancel(0);
        serviceOrder.setCancel(0);
        serviceOrder.setDiscount(0);
        serviceOrders.saveOrder(serviceOrder);
        return "redirect:/orders?table=0&success&username=" + serviceOrder.getUsername();
    }


    @RequestMapping(value = "/editOrderPersonal")
    public String editOrderPersonal(ServiceOrder serviceOrder){

        if (serviceOrder.getObservations().isEmpty()){
            serviceOrder.setObservations("Sin Observaciones");
        }

        serviceOrder.setOptions(serviceOrder.getOptions());
        serviceOrder.setPrinciples(serviceOrder.getPrinciples());
        serviceOrder.setProteins(serviceOrder.getProteins());
        serviceOrder.setEntries(serviceOrder.getProteins());
        serviceOrder.setVegetables(serviceOrder.getVegetables());
        serviceOrder.setSalad(serviceOrder.getSalad());
        serviceOrder.setDrinks(serviceOrder.getDrinks());

        serviceOrder.setOrdered(0);
        serviceOrder.setPrepared(0);
        serviceOrder.setPrepare(0);
        serviceOrder.setServed(0);
        serviceOrder.setClose(0);
        serviceOrder.setCancel(0);
        serviceOrder.setCancel(0);
        serviceOrder.setDiscount(0);
        serviceOrders.editOrderPersonal(serviceOrder);
        return "redirect:/orders?table=0&success&username=" + serviceOrder.getUsername();
    }

}
