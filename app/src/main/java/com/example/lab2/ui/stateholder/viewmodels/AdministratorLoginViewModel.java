package com.example.lab2.ui.stateholder.viewmodels;

import androidx.lifecycle.ViewModel;

import com.example.lab2.data.models.LoginAdministrator;
import com.example.lab2.data.models.LoginUser;
import com.example.lab2.data.repositories.AccountsRepository;

public class AdministratorLoginViewModel extends ViewModel {

    private final AccountsRepository repository = new AccountsRepository();

    public boolean loginAccount(String login, String pass) {
        LoginAdministrator administrator = new LoginAdministrator(login, pass);
        return repository.adminLogin(administrator);
    }

}
