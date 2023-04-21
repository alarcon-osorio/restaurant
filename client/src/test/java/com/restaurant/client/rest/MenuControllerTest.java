package com.restaurant.client.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.restaurant.client.entity.Menu;
import com.restaurant.client.service.ServiceMenu;
import com.restaurant.client.controller.rest.MenuController;

@ExtendWith(MockitoExtension.class)
public class MenuControllerTest {

    @Mock
    private ServiceMenu serviceMenu;

    @InjectMocks
    private MenuController menuController;

    @Test
    public void testGetMenu() {

        //creamos los datos que se retornaran
        List<Menu> menuList = new ArrayList<>();
        menuList.add(new Menu(1,1,"Hola","Hola","120000","ruta",1));
        menuList.add(new Menu(2,1,"Hola","Hola","120000","ruta2",1));

        //simulamos el comportamiento del service
        when(serviceMenu.getMenu()).thenReturn(menuList);

        //probamos el endpoint del controller
        List<Menu> result = menuController.menu();

        //verificamos que se retorne la lista esperada
        assertEquals(menuList, result);
    }

    @Test
    public void testGetMenuId() {

        //creamos un id de menu
        long id = 1L;

        //creamos el menu que se retornara
        Menu menu = new Menu(1,1,"Hola","Hola","120000","ruta",1);

        //simulamos el comportamiento del service
        when(serviceMenu.getMenuId(id)).thenReturn(menu);

        //probamos el endpoint del controller
        Menu result = menuController.idMenu(id);

        //verificamos que se retorne el menu esperado
        assertEquals(menu, result);
    }

    @Test
    public void testOrdered() {
        Menu menu = mock(Menu.class);
        when(serviceMenu.getMenuId(1L)).thenReturn(menu);
        when(serviceMenu.ordered(menu)).thenReturn(menu);

        Menu result = menuController.Ordered(1L);

        assertEquals(menu, result);
    }


}