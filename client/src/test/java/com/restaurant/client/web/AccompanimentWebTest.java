package com.restaurant.client.web;

import com.restaurant.client.controller.web.AccompanimentWeb;
import com.restaurant.client.entity.*;
import com.restaurant.client.service.ServiceMenu;
import com.restaurant.client.service.ServiceMenuAccompaniment;
import com.restaurant.client.service.ServiceMenuIncludes;
import com.restaurant.client.service.ServiceMenuOptional;
import com.restaurant.client.service.ServiceRestaurantTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AccompanimentWebTest {

    @Mock
    private ServiceMenu serviceMenu;

    @Mock
    private ServiceMenuAccompaniment serviceMenuAccompaniment;

    @Mock
    private ServiceRestaurantTable serviceRestaurantTable;

    @Mock
    private ServiceMenuIncludes serviceMenuIncludes;

    @Mock
    private ServiceMenuOptional serviceMenuOptional;

    @Mock
    private Model model;

    @InjectMocks
    private AccompanimentWeb accompanimentWeb;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAccompaniment() {
        // Set up test data
        long menuIdPersonal = 1L;
        long menuId = 1L;
        String table = "Table 1";
        boolean add = true;
        List<MenuAccompaniment> menuAccompanimentList = new ArrayList<>();
        List<MenuAccompaniment> menuAccompanimentIdMenu = new ArrayList<>();
        List<MenuIncludes> menuIncludeByIdMenu = new ArrayList<>();
        Menu menu = new Menu(1,1,"Hola","Hola","120000","ruta",1);
        List<RestaurantTable> listRestaurantTable = new ArrayList<>();
        List<MenuIncludes> menuIncludesList = new ArrayList<>();
        List<MenuOptional> menuOptionalList = new ArrayList<>();

        // Configure mocks
        when(serviceMenu.getMenuId(menuId)).thenReturn(menu);
        when(serviceMenuAccompaniment.getMenuAccompanimentList()).thenReturn(menuAccompanimentList);
        when(serviceMenuAccompaniment.getMenuAccompanimentMenuId(menuId)).thenReturn(menuAccompanimentIdMenu);
        when(serviceMenuIncludes.getMenuIncludesIdMenu(menuId)).thenReturn(menuIncludeByIdMenu);
        when(serviceRestaurantTable.getRestaurantTableList()).thenReturn(listRestaurantTable);
        when(serviceMenuIncludes.getMenuIncludesList()).thenReturn(menuIncludesList);
        when(serviceMenuOptional.getMenuOptionalByIdMenu(menuId)).thenReturn(menuOptionalList);

        // Call the method being tested
        String viewName = accompanimentWeb.accompaniment(model, menuId, menuIdPersonal, table, add);

        // Verify the model attributes were set correctly
        verify(model).addAttribute("menuName", menu.getName());
        verify(model).addAttribute("menuDescription", menu.getDescription());
        verify(model).addAttribute("menuImage", menu.getImage());
        verify(model).addAttribute("menuTypeId", menu.getIdMenuType());
        verify(model).addAttribute("menuPrice", menu.getPrice());
        verify(model).addAttribute("menuId", menu.getId());
        verify(model).addAttribute("listRestaurantTable", listRestaurantTable);
        verify(model).addAttribute("menuIncludesList", menuIncludesList);

        // Verify the view name
        assertEquals("viewAccompaniment", viewName);
    }
}
