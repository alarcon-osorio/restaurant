package com.restaurant.admin.security.service;

import com.restaurant.admin.security.entity.Users;
import com.restaurant.admin.security.repository.RepositoryUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private RepositoryUsers repositoryUsers;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = repositoryUsers.findByUsername(username);

        if (users == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(users);
    }


}
