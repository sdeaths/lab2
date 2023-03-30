package com.example.lab2.domain.usecase;

import com.example.lab2.domain.AccountsRepository;
import com.example.lab2.domain.entity.LoginAdministrator;

public class AdminLoginUseCase {

    private final AccountsRepository repository;

    public boolean adminLogin(LoginAdministrator loginAdministrator){
        return repository.adminLogin(loginAdministrator);
    }

    public AdminLoginUseCase(AccountsRepository repository) {
        this.repository = repository;
    }
}
