package com.example.demospringsecurity.service;

import com.example.demospringsecurity.model.Roles;
import com.example.demospringsecurity.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesService implements IRolesService {
    @Autowired
    RolesRepository rolesRepository;

    @Override
    public Roles findByName(String name) {
        return rolesRepository.findByName(name);
    }
}
