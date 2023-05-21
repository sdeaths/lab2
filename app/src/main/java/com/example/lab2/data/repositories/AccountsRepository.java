package com.example.lab2.data.repositories;

import android.content.Context;
import android.icu.text.PluralFormat;

import com.example.lab2.data.API.Api;
import com.example.lab2.data.API.PlaceHolderPost;
import com.example.lab2.data.API.RetrofitFactory;
import com.example.lab2.data.protocols.AccountsProtocol;
import com.example.lab2.data.datasource.AccountsRemoteDataSource;
import com.example.lab2.data.models.LoginAdministrator;
import com.example.lab2.data.models.LoginUser;
import com.example.lab2.data.models.RegistrationUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

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

    @Override
    public Call<PlaceHolderPost> getPost() {
        Retrofit retrofit = RetrofitFactory.getRetrofit();
        Api api = retrofit.create(Api.class);
        Call<PlaceHolderPost> call = api.getPost();
        return call;
    }

    @Override
    public Call<PlaceHolderPost> pushPost(PlaceHolderPost post) {
        Retrofit retrofit = RetrofitFactory.getRetrofit();
        Api api = retrofit.create(Api.class);
        Call<PlaceHolderPost> call = api.pushPost(post);
        return call;
    }

    @Override
    public Call<List<PlaceHolderPost>> getAllPosts() {
        Retrofit retrofit = RetrofitFactory.getRetrofit();
        Api api = retrofit.create(Api.class);
        Call<List<PlaceHolderPost>> call = api.getAllPosts();
        return call;
    }
}
