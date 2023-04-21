package com.restaurant.client.web;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

import com.restaurant.client.controller.web.OrdersWeb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.restaurant.client.entity.ServiceOrder;
import com.restaurant.client.service.ServiceMenuAccompaniment;
import com.restaurant.client.service.ServiceMenuIncludes;
import com.restaurant.client.service.ServiceMenuOptional;
import com.restaurant.client.service.ServiceOrders;
import org.springframework.ui.Model;

@RunWith(MockitoJUnitRunner.class)
public class OrdersWebTest {


    @InjectMocks
    private OrdersWeb ordersWeb;

    @Mock
    private ServiceOrders serviceOrders;

    @Mock
    private ServiceMenuAccompaniment serviceMenuAccompaniment;

    @Mock
    private ServiceMenuIncludes serviceMenuIncludes;

    @Mock
    private ServiceMenuOptional serviceMenuOptional;

    @Test
    public void testOrders() {
        long table = 1L;
        boolean add = false;
        List<ServiceOrder> neatOrderList = Arrays.asList(new ServiceOrder());
        when(serviceOrders.getNeatOrderByTable(table)).thenReturn(neatOrderList);
        List<String> tableNumberList = Arrays.asList("1");
        when(serviceOrders.getTableNumber()).thenReturn(tableNumberList);
        List<ServiceOrder> serviceOrdersByTableNumber = Arrays.asList(new ServiceOrder());
        when(serviceOrders.getByTableNumber(table)).thenReturn(serviceOrdersByTableNumber);
    }

    @Test
    public void testConfirmOrder() {
        long table = 1L;
        String result = ordersWeb.confirmOrder(null, table);
        assertEquals("redirect:/orders?table=1&add=true", result);
        verify(serviceOrders).saveOrderTable(table);
    }
}
