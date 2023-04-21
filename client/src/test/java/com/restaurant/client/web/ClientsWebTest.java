package com.restaurant.client.web;

import com.restaurant.client.controller.web.ClientsWeb;
import com.restaurant.client.security.entity.Clients;
import com.restaurant.client.service.ServiceClients;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ClientsWebTest {

    @Mock
    private ServiceClients serviceClientsMock;

    @Mock
    private PasswordEncoder passwordEncoderMock;

    @Mock
    private Clients clientsMock;

    @Mock
    private BindingResult bindingResultMock;

    @Mock
    private Model modelMock;

    private ClientsWeb clientsWeb;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        clientsWeb = new ClientsWeb();
        clientsWeb.serviceClients = serviceClientsMock;
        clientsWeb.passwordEncoder = passwordEncoderMock;
    }

    @Test
    public void testCreateClients() {
        String viewName = clientsWeb.createClients(modelMock);
        assertEquals("register", viewName);
    }

    @Test
    public void testRegistrationSuccess() {
        when(clientsMock.getEmail()).thenReturn("test@example.com");
        when(serviceClientsMock.getClientByEmail("test@example.com")).thenReturn(null);
        when(passwordEncoderMock.encode(anyString())).thenReturn("encodedPassword");

        String viewName = clientsWeb.registration(clientsMock, bindingResultMock, modelMock);

        assertEquals("redirect:/register?success", viewName);
        clientsMock.getEmail();
        clientsMock.getEmail();
        clientsMock.setUsername("test@example.com");
        clientsMock.getPassword();
        clientsMock.setPassword(null);
    }

    @Test
    public void testRegistrationEmailExists() {
        when(clientsMock.getEmail()).thenReturn("test@example.com");
        when(serviceClientsMock.getClientByEmail("test@example.com")).thenReturn(new Clients());

        clientsMock.getEmail();
        clientsMock.getEmail();
        clientsMock.setUsername("test@example.com");
        clientsMock.getPassword();
        clientsMock.setPassword(null);
    }
}