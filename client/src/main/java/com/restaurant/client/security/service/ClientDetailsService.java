package com.restaurant.client.security.service;

import com.restaurant.client.security.entity.Clients;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class ClientDetailsService implements UserDetails {

    private Clients clients;

    public ClientDetailsService(Clients clients) {
        this.clients = clients;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(clients.getRole());
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {
        return clients.getPassword();
    }

    @Override
    public String getUsername() {
        return clients.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
