package com.example.demospringsecurity.service;

import com.example.demospringsecurity.model.Accounts;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class CustomUserDetails implements UserDetails {
    private Accounts accounts;
    List<GrantedAuthority> authorities=null;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    public void setAuthorities(List<GrantedAuthority> authorities)
    {
        this.authorities=authorities;
    }

    public void setAccounts(Accounts accounts){
        this.accounts = accounts;
    }
    @Override
    public String getPassword() {
        return accounts.getPassword();
    }

    @Override
    public String getUsername() {
        return accounts.getUsername();
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
