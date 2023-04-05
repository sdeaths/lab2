package com.example.lab2.ui.stateholder.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.lab2.data.models.LoginAdministrator;
import com.example.lab2.data.repositories.AccountsRepository;

public class AdministratorLoginViewModel extends AndroidViewModel {

    private final AccountsRepository repository = new AccountsRepository(getApplication());

    public AdministratorLoginViewModel(@NonNull Application application) {
        super(application);
    }

    public boolean loginAccount(String login, String pass, boolean allowed) {
        LoginAdministrator administrator = new LoginAdministrator(login, pass);
        return repository.adminLogin(administrator, allowed);
    }

}
