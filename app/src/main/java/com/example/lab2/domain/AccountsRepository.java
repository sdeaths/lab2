package com.example.lab2.domain;

import com.example.lab2.domain.entity.LoginAdministrator;
import com.example.lab2.domain.entity.LoginUser;
import com.example.lab2.domain.entity.RegistrationUser;

public interface AccountsRepository {

    boolean adminLogin(LoginAdministrator loginAdministrator);

    boolean userLogin(LoginUser loginUser);

    boolean userRegistration (RegistrationUser registrationUser);
}
