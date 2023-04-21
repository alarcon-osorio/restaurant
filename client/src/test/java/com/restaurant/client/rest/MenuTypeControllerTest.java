package com.restaurant.client.rest;

import com.restaurant.client.controller.rest.MenuTypeController;
import com.restaurant.client.entity.MenuType;
import com.restaurant.client.service.ServiceMenuType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MenuTypeControllerTest {

    @InjectMocks
    private MenuTypeController menuTypeController;

    @Mock
    private ServiceMenuType serviceMenuType;

    @Test
    public void testMenuTypeList() {
        List<MenuType> menuTypes = mock(List.class);
        when(serviceMenuType.getMenuType()).thenReturn(menuTypes);

        List<MenuType> result = menuTypeController.menuTypeList();

        verify(serviceMenuType, times(1)).getMenuType();
        assertEquals(menuTypes, result);
    }

    @Test
    public void testIdMenuType() {
        MenuType menuType = mock(MenuType.class);
        when(serviceMenuType.getMenuTypeId(1L)).thenReturn(menuType);

        MenuType result = menuTypeController.idMenuType(1L);

        verify(serviceMenuType, times(1)).getMenuTypeId(1L);
        assertEquals(menuType, result);
    }
}
