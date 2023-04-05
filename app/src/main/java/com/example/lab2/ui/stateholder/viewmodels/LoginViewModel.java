package com.example.lab2.ui.stateholder.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.lab2.data.models.LoginUser;
import com.example.lab2.data.repositories.AccountsRepository;

public class LoginViewModel extends AndroidViewModel {

    private final AccountsRepository repository = new AccountsRepository(getApplication());

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public boolean loginAccount(String login, String pass) {
        LoginUser loginUser = new LoginUser(login, pass);
        return repository.userLogin(loginUser);
    }

}
