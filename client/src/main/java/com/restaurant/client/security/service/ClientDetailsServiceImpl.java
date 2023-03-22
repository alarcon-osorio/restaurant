package com.restaurant.client.security.service;

import com.restaurant.client.security.entity.Clients;
import com.restaurant.client.security.repository.RepositoryClientSecurity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

@Slf4j
public class ClientDetailsServiceImpl implements UserDetailsService {

    @Autowired
    RepositoryClientSecurity repositoryClientSecurity;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (!username.contains("@")){
            List<Clients> clientsList = repositoryClientSecurity.findLikeUsernameList(username);
            if (clientsList.size()==1){
                Clients clientsLike = repositoryClientSecurity.findLikeUsername(username);
                if (clientsLike == null) {
                    throw new UsernameNotFoundException("No se puede encontrar usuario");
                }
                log.info(clientsLike.getEmail());
                return new ClientDetailsService(clientsLike);
            } else if (clientsList.size()>1) {
                throw new UsernameNotFoundException("Intenta con @");
            }
        }else{
            Clients clients = repositoryClientSecurity.findByUsername(username);
            if (clients == null) {
                throw new UsernameNotFoundException("No se puede encontrar usuario");
            }
            log.info(clients.getUsername());
            return new ClientDetailsService(clients);
        }

        return null;
    }

}
