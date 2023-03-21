package com.restaurant.client.security.service;

import com.restaurant.client.security.entity.Clients;
import com.restaurant.client.security.repository.RepositoryClientSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ClientDetailsServiceImpl implements UserDetailsService {

    @Autowired
    RepositoryClientSecurity repositoryClientSecurity;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Clients clients = repositoryClientSecurity.findByUsername(username);

        if (clients == null) {
            throw new UsernameNotFoundException("No se puede encontrar usuario");
        }

        return new ClientDetailsService(clients);
    }
}
