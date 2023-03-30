package com.example.lab2.domain.usecase;

import com.example.lab2.domain.AccountsRepository;
import com.example.lab2.domain.entity.LoginUser;

public class UserLoginUseCase {

    private final AccountsRepository repository;

    public boolean userLogin(LoginUser loginUser){
        return repository.userLogin(loginUser);
    }

    public UserLoginUseCase(AccountsRepository repository) {
        this.repository = repository;
    }
}
