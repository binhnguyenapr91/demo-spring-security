package com.example.demospringsecurity.service;

import com.example.demospringsecurity.model.Accounts;
import com.example.demospringsecurity.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountsService implements IAccountsService {
    @Autowired
    AccountsRepository accountsRepository;

    @Override
    public Accounts findByUsername(String username) {
        return accountsRepository.findByUsername(username);
    }
}
