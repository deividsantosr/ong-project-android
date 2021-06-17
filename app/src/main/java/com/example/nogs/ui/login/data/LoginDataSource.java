package com.example.nogs.ui.login.data;

import com.example.nogs.api.RetrofitConfig;
import com.example.nogs.api.User;
import com.example.nogs.api.ApiService;
import com.example.nogs.ui.login.data.model.LoggedInUser;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            LoggedInUser fakeUser = new LoggedInUser(java.util.UUID.randomUUID().toString(), username.replaceAll("((@.*)|[^a-zA-Z])+", " ").trim());

            return new Result.Success<>(fakeUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}