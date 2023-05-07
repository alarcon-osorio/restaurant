package com.restaurant.client.web;

import com.restaurant.client.controller.web.MenuWeb;
import com.restaurant.client.entity.Menu;
import com.restaurant.client.entity.MenuType;
import com.restaurant.client.entity.menu_personal.MenuPersonalForm;
import com.restaurant.client.service.*;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MenuWebTest {

    @Mock
    ServiceMenu serviceMenu;

    @Mock
    ServiceMenuType serviceMenuType;

    @Mock
    ServiceOrders serviceOrders;

    @Mock
    ServiceMenuAccompaniment serviceMenuAccompaniment;

    @Mock
    ServiceMenuIncludes serviceMenuIncludes;

    @Mock
    ServiceMenuOptional serviceMenuOptional;

    @Mock
    ServiceMenuPersonalForm serviceMenuPersonalForm;

    @Mock
    ServiceMenuPersonalView serviceMenuPersonalView;

    @Mock
    Model model;

    MenuWeb menuWeb;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        menuWeb = new MenuWeb();
        menuWeb.serviceMenu = serviceMenu;
        menuWeb.serviceMenuType = serviceMenuType;
        menuWeb.serviceOrders = serviceOrders;
        menuWeb.serviceMenuAccompaniment = serviceMenuAccompaniment;
        menuWeb.serviceMenuIncludes = serviceMenuIncludes;
        menuWeb.serviceMenuOptional = serviceMenuOptional;
        menuWeb.serviceMenuPersonalForm = serviceMenuPersonalForm;
        menuWeb.serviceMenuPersonalView = serviceMenuPersonalView;
    }

    @Test
    public void testMenu() {
        //Arrange
        List<Menu> menu = new ArrayList<>();
        menu.add(new Menu(1,1,"Pizza","Pizza Rica","120000","ruta",1));
        Mockito.when(serviceMenu.getMenu()).thenReturn(menu);

        List<MenuType> menuTypeList = new ArrayList<>();
        menuTypeList.add(new MenuType(1L, "Tipo de menú"));
        Mockito.when(serviceMenuType.getMenuType()).thenReturn(menuTypeList);

        //Act
        Model model = new ExtendedModelMap();
        String viewName = menuWeb.menu(model);

        //Assert
        Assert.assertEquals("viewMenu", viewName);
        Assert.assertEquals(menu, model.getAttribute("menu"));
        Assert.assertEquals(menuTypeList, model.getAttribute("menuTypeList"));
    }




}
