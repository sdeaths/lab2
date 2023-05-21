package com.example.lab2.data.API;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    @GET("posts/37")
    Call<PlaceHolderPost> getPost();

    @POST("posts")
    Call<PlaceHolderPost> pushPost(@Body PlaceHolderPost post);

    @GET("posts")
    Call<List<PlaceHolderPost>> getAllPosts();
}
