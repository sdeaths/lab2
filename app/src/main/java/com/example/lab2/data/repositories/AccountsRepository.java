package com.example.lab2.data.repositories;

import android.content.Context;

import com.example.lab2.data.protocols.AccountsProtocol;
import com.example.lab2.data.datasource.AccountsRemoteDataSource;
import com.example.lab2.data.models.LoginAdministrator;
import com.example.lab2.data.models.LoginUser;
import com.example.lab2.data.models.RegistrationUser;

public class AccountsRepository implements AccountsProtocol {
    private final Context context;
    private final AccountsRemoteDataSource dataSource;

    public AccountsRepository(Context context) {
        this.context = context;
        dataSource = new AccountsRemoteDataSource(context);
    }

    @Override
    public boolean adminLogin(LoginAdministrator loginAdministrator, boolean allowed) {
        return dataSource.checkLoginAdminValid(loginAdministrator, allowed);
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
