package com.restaurant.client.web;

import com.restaurant.client.controller.web.HomeWeb;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class HomeWebTest {

    @InjectMocks
    HomeWeb homeWeb;

    @Test
    void testIndex() {
        String viewName = homeWeb.index();
        assertEquals("login", viewName);
    }

}
