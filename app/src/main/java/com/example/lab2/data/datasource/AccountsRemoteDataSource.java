package com.example.lab2.data.datasource;

import com.example.lab2.domain.entity.LoginAdministrator;
import com.example.lab2.domain.entity.LoginUser;
import com.example.lab2.domain.entity.RegistrationUser;

public class AccountsRemoteDataSource {

    public boolean checkLoginUserValid(LoginUser loginUser){
        return !loginUser.getPhone().equals("") &&
                !loginUser.getPassword().equals("");
    }

    public boolean checkRegistrationValid(RegistrationUser registrationUser) {
        return !registrationUser.getName().equals("") &&
                !registrationUser.getPassword().equals("") &&
                !registrationUser.getPhone().equals("");
    }

    public boolean checkLoginAdminValid(LoginAdministrator loginAdministrator){
        return !loginAdministrator.getName().equals("") &&
                !loginAdministrator.getKey().equals("");
    }
}
