package com.example.lab2.domain.usecase;

import com.example.lab2.domain.AccountsRepository;
import com.example.lab2.domain.entity.RegistrationUser;

public class UserRegistrationUseCase {

    private final AccountsRepository repository;

    public boolean userRegistration (RegistrationUser registrationUser){
        return repository.userRegistration(registrationUser);
    }

    public UserRegistrationUseCase(AccountsRepository repository) {
        this.repository = repository;
    }
}
