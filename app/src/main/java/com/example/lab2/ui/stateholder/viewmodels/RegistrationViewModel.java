package com.example.lab2.ui.stateholder.viewmodels;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.lab2.data.models.LoginAdministrator;
import com.example.lab2.data.models.LoginUser;
import com.example.lab2.data.models.RegistrationUser;
import com.example.lab2.data.repositories.AccountsRepository;

public class RegistrationViewModel extends ViewModel {

    private final AccountsRepository repository = new AccountsRepository();

    public boolean registrationAccount(String name, String phone, String password) {
        RegistrationUser loginUser = new RegistrationUser(name, phone, password);
        return repository.userRegistration(loginUser);
    }

}
