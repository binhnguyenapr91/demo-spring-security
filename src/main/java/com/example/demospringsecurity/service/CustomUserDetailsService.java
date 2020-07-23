package com.example.demospringsecurity.service;

import com.example.demospringsecurity.model.Accounts;
import com.example.demospringsecurity.repository.AccountsRepository;
import com.example.demospringsecurity.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    AccountsRepository accountsRepository;
    @Autowired
    RolesRepository rolesRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Accounts accounts = this.accountsRepository.findByUsername(username);
        if (accounts == null) {
            System.out.println("User not found! " + username);
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
        System.out.println("Found User: " + accounts);

        String roleNames = this.accountsRepository.findByUsername(username).getRole().getName();
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        GrantedAuthority authority = new SimpleGrantedAuthority(roleNames);
        grantList.add(authority);


        UserDetails userDetails = (UserDetails) new Accounts(accounts.getUsername(), accounts.getPassword(), grantList);

        return userDetails;
    }
}
