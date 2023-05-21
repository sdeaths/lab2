package com.example.lab2.data.protocols;

import com.example.lab2.data.API.PlaceHolderPost;
import com.example.lab2.data.models.LoginAdministrator;
import com.example.lab2.data.models.LoginUser;
import com.example.lab2.data.models.RegistrationUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AccountsProtocol {

    boolean adminLogin(LoginAdministrator loginAdministrator, boolean allowed);

    boolean userLogin(LoginUser loginUser);

    boolean userRegistration(RegistrationUser registrationUser);

    Call<PlaceHolderPost> getPost();

    Call<PlaceHolderPost> pushPost(@Body PlaceHolderPost post);

    Call<List<PlaceHolderPost>> getAllPosts();
}
