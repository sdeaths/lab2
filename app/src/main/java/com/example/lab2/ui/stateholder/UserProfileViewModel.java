package com.example.lab2.ui.stateholder;

import androidx.lifecycle.ViewModel;

import com.example.lab2.data.models.LoginUser;
import com.example.lab2.data.repositories.AccountsRepository;

public class UserProfileViewModel extends ViewModel {
    private final AccountsRepository repository = new AccountsRepository();

    public boolean loginAccount(String Phone, String Password){
        LoginUser user = new LoginUser(Phone, Password);
        return repository.userLogin(user);
    }

}
