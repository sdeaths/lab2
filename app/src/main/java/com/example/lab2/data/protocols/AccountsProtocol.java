package com.example.lab2.data.protocols;

import com.example.lab2.data.models.LoginAdministrator;
import com.example.lab2.data.models.LoginUser;
import com.example.lab2.data.models.RegistrationUser;

public interface AccountsProtocol {

    boolean adminLogin(LoginAdministrator loginAdministrator, boolean allowed);

    boolean userLogin(LoginUser loginUser);

    boolean userRegistration (RegistrationUser registrationUser);
}
