package com.example.demospringsecurity.repository;

import com.example.demospringsecurity.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles,Long> {
    Roles findByName(String name);
}
