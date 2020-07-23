package com.example.demospringsecurity.service;

import com.example.demospringsecurity.model.Accounts;

public interface IAccountsService {
    Accounts findByUsername(String username);
}
