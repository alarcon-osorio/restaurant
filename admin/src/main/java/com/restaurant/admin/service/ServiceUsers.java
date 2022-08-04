package com.restaurant.admin.service;

import com.restaurant.admin.repository.RepositoryUsersAdmin;
import com.restaurant.admin.security.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUsers {

    @Autowired
    RepositoryUsersAdmin repositoryUsersAdmin;

    public List<Users> findUsers(){
        return repositoryUsersAdmin.findAll();
    }

}
