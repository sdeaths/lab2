package com.example.lab2.data;

import com.example.lab2.data.datasource.AccountsRemoteDataSource;
import com.example.lab2.domain.AccountsRepository;
import com.example.lab2.domain.entity.LoginAdministrator;
import com.example.lab2.domain.entity.LoginUser;
import com.example.lab2.domain.entity.RegistrationUser;

public class AccountsRepositoryImpl implements AccountsRepository {

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
