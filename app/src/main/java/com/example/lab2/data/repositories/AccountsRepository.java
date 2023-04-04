package com.example.lab2.data.repositories;

import com.example.lab2.data.protocols.AccountsProtocol;
import com.example.lab2.data.datasource.AccountsRemoteDataSource;
import com.example.lab2.data.models.LoginAdministrator;
import com.example.lab2.data.models.LoginUser;
import com.example.lab2.data.models.RegistrationUser;

public class AccountsRepository implements AccountsProtocol {

    private final AccountsRemoteDataSource dataSource = new AccountsRemoteDataSource();

    @Override
    public boolean adminLogin(LoginAdministrator loginAdministrator) {
        return dataSource.checkLoginAdminValid(loginAdministrator);
    }

    @Override
    public boolean userLogin(LoginUser loginUser) {
        return dataSource.checkLoginUserValid(loginUser);
    }

    @Override
    public boolean userRegistration(RegistrationUser registrationUser) {
        return dataSource.checkRegistrationValid(registrationUser);
    }
}
