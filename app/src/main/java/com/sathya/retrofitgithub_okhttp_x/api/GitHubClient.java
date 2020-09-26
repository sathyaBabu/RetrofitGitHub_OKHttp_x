package com.sathya.retrofitgithub_okhttp_x.api;

import com.sathya.retrofitgithub_okhttp_x.model.GitHubUser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubClient {

    @GET("users/{user}")
    Call<GitHubUser> getFeed(@Path("user") String user);
    //String user is for passing values from the EditText e.g. user="sathyaBabu", "google"



}
