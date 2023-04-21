package com.restaurant.client.rest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.restaurant.client.controller.rest.MenuAccompanimentController;
import com.restaurant.client.entity.MenuAccompaniment;
import com.restaurant.client.service.ServiceMenuAccompaniment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MenuAccompanimentControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ServiceMenuAccompaniment serviceMenuAccompaniment;

    @InjectMocks
    private MenuAccompanimentController menuAccompanimentController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(menuAccompanimentController).build();
    }

    @Test
    public void testGetMenuAccompanimentList() throws Exception {
        // Set up test data
        List<MenuAccompaniment> menuAccompanimentList = new ArrayList<>();
        MenuAccompaniment ma1 = new MenuAccompaniment();
        ma1.setId(1L);
        ma1.setAccompaniment("Accompaniment 1");
        menuAccompanimentList.add(ma1);
        MenuAccompaniment ma2 = new MenuAccompaniment();
        ma2.setId(2L);
        ma2.setAccompaniment("Accompaniment 2");
        menuAccompanimentList.add(ma2);

        // Set up mock service response
        when(serviceMenuAccompaniment.getMenuAccompanimentList()).thenReturn(menuAccompanimentList);

        // Perform request and verify response
        mockMvc.perform(get("/api/menu_accompaniment")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].accompaniment").value("Accompaniment 1"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].accompaniment").value("Accompaniment 2"));
    }

    @Test
    public void testGetMenuAccompanimentId() {
        // Given
        long id = 1L;
        MenuAccompaniment menuAccompaniment = new MenuAccompaniment();
        menuAccompaniment.setId(id);
        when(serviceMenuAccompaniment.getMenuAccompanimentId(id)).thenReturn(menuAccompaniment);

        // When
        MenuAccompaniment result = menuAccompanimentController.getMenuAccompanimentId(id);

        // Then
        assertEquals(menuAccompaniment, result);
    }

    @Test
    public void testGetMenuAccompanimentMenuId() {
        // Given
        long id = 1L;
        MenuAccompaniment menuAccompaniment = new MenuAccompaniment();
        menuAccompaniment.setId(id);
        when(serviceMenuAccompaniment.getMenuAccompanimentId(id)).thenReturn(menuAccompaniment);

        // When
        MenuAccompaniment result = menuAccompanimentController.getMenuAccompanimentId(id);

        // Then
        assertEquals(menuAccompaniment, result);
    }

}
