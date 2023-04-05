package com.example.lab2.ui.stateholder.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.lab2.data.models.RegistrationUser;
import com.example.lab2.data.repositories.AccountsRepository;

public class RegistrationViewModel extends AndroidViewModel {

    private final AccountsRepository repository = new AccountsRepository(getApplication());

    public RegistrationViewModel(@NonNull Application application) {
        super(application);
    }

    public boolean registrationAccount(String name, String phone, String password) {
        RegistrationUser loginUser = new RegistrationUser(name, phone, password);
        return repository.userRegistration(loginUser);
    }

}
