package com.example.demospringsecurity.repository;

import com.example.demospringsecurity.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Accounts,Long> {
    Accounts findByUsername(String username);
}
