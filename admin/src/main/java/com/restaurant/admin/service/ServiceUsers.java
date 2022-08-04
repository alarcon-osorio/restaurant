package com.restaurant.admin.service;

import com.restaurant.admin.repository.RepositoryUsers;
import com.restaurant.admin.security.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUsers {

    @Autowired
    RepositoryUsers repositoryUsers;

    public List<Users> findUsers(){
        return repositoryUsers.findAll();
    }

}
