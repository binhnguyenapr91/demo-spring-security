package com.example.demospringsecurity.service;

import com.example.demospringsecurity.model.Roles;

public interface IRolesService {
    Roles findByName (String name);
}
