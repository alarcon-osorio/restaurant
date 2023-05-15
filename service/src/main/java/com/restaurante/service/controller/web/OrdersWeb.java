package com.restaurante.service.controller.web;

import com.restaurante.service.entity.MenuAccompaniment;
import com.restaurante.service.entity.MenuIncludes;
import com.restaurante.service.entity.MenuOptional;
import com.restaurante.service.entity.ServiceOrder;
import com.restaurante.service.service.ServiceMenuAccompaniment;
import com.restaurante.service.service.ServiceMenuIncludes;
import com.restaurante.service.service.ServiceMenuOptional;
import com.restaurante.service.service.ServiceOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OrdersWeb {

    @Autowired
    ServiceOrders serviceOrders;

    @Autowired
    ServiceMenuAccompaniment serviceMenuAccompaniment;

    @Autowired
    ServiceMenuIncludes serviceMenuIncludes;

    @Autowired
    ServiceMenuOptional serviceMenuOptional;

    @RequestMapping(value = "/orders")
    public String orders(Model model, long table, boolean add){

        List<ServiceOrder> neatOrderList = serviceOrders.getNeatOrderByTable(table);
        if(!neatOrderList.isEmpty()){
            model.addAttribute("disableButton", "ok");
        }

        List<String> tableNumberList = serviceOrders.getTableNumber();
        model.addAttribute("tableNumberList", tableNumberList);

        if (table == 0){
            List<ServiceOrder> serviceOrderList = serviceOrders.getServiceOrder();
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
            List<ServiceOrder> serviceOrderList = serviceOrders.getServiceOrder();
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
    public String orderTable(Model model, @RequestParam long id, @RequestParam long table, boolean add) {
        serviceOrders.saveOrderTableById(id);
        model.addAttribute("orderTable", "ok");
        return "redirect:/orders?table="  + table + "&add=" + add;
    }

    @RequestMapping(value = "/cancel_order_table")
    public String cancelOrderTable(Model model, @RequestParam long id) {
        serviceOrders.orderTableCancel(id);
        model.addAttribute("orderTableCancel", "ok");
        return "redirect:/orders?table=0";
    }

    @RequestMapping(value = "/cancel_order")
    public String cancelOrder(Model model, @RequestParam long table) {
        serviceOrders.cancelOrder(table);
        model.addAttribute("cancelOrder", "ok");
        return "redirect:/orders?table=0";
    }

    @RequestMapping(value = "/save_table")
    public String saveTable(Model model, ServiceOrder serviceOrder) {
        serviceOrders.saveOrder(serviceOrder);
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

        if (serviceOrder.getIdMenu() == 0){
            serviceOrder.setIdMenu(1);
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
        return "redirect:/accompaniment?menuId=" + serviceOrder.getIdMenu() + "&table=" + serviceOrder.getTableNumber() + "&add=true";
    }

}
