package com.restaurante.service.security.service;

import com.restaurante.service.security.entity.Users;
import com.restaurante.service.security.repository.RepositoryUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private RepositoryUsers repositoryUsers;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Users users = repositoryUsers.findByUsername(username);

        if (users == null) {
            throw new UsernameNotFoundException("No se puede encontrar usuario");
        }

        return new MyUserDetails(users);
    }


}
