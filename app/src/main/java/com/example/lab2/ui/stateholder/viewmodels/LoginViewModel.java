package com.example.lab2.ui.stateholder.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.lab2.data.API.PlaceHolderPost;
import com.example.lab2.data.models.LoginUser;
import com.example.lab2.data.repositories.AccountsRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends AndroidViewModel {

    private final AccountsRepository repository = new AccountsRepository(getApplication());

    public LoginViewModel(@NonNull Application application) {
        super(application);
        repository.getPost().enqueue(new Callback<PlaceHolderPost>() {
            @Override
            public void onResponse(Call<PlaceHolderPost> call, Response<PlaceHolderPost> response) {
                if (response.isSuccessful()) {
                    PlaceHolderPost placeHolderPost = response.body();
                    postLiveData.setValue(placeHolderPost);
                }
            }

            @Override
            public void onFailure(Call<PlaceHolderPost> call, Throwable t) {

            }
        });
        repository.getAllPosts().enqueue(new Callback<List<PlaceHolderPost>>() {
            @Override
            public void onResponse(Call<List<PlaceHolderPost>> call, Response<List<PlaceHolderPost>> response) {
                if (response.isSuccessful()) {
                    List<PlaceHolderPost> listPlaceHolderPost = response.body();
                    listPostLiveData.setValue(listPlaceHolderPost);
                }
            }

            @Override
            public void onFailure(Call<List<PlaceHolderPost>> call, Throwable t) {

            }
        });
        repository.pushPost(new PlaceHolderPost(1, 1, "ура сессия", "скоро курсач")).enqueue(new Callback<PlaceHolderPost>() {
            @Override
            public void onResponse(Call<PlaceHolderPost> call, Response<PlaceHolderPost> response) {
                if (response.isSuccessful()) {
                    PlaceHolderPost placeHolderPost = response.body();
                    postLiveData.setValue(placeHolderPost);
                }
            }

            @Override
            public void onFailure(Call<PlaceHolderPost> call, Throwable t) {

            }
        });
    }

    private MutableLiveData<PlaceHolderPost> postLiveData = new MutableLiveData<>();

    public LiveData<PlaceHolderPost> getPostLiveData() {
        return postLiveData;
    }

    private MutableLiveData<PlaceHolderPost> pushPostLiveData = new MutableLiveData<>();

    public LiveData<PlaceHolderPost> getPushPostLiveData() {
        return pushPostLiveData;
    }

    private MutableLiveData<List<PlaceHolderPost>> listPostLiveData = new MutableLiveData<>();

    public LiveData<List<PlaceHolderPost>> getListPostLiveData() {
        return listPostLiveData;
    }

    public boolean loginAccount(String login, String pass) {
        LoginUser loginUser = new LoginUser(login, pass);
        return repository.userLogin(loginUser);
    }

}
