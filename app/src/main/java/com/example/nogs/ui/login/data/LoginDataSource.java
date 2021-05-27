package com.example.nogs.ui.login.data;

import com.example.nogs.ui.login.data.model.LoggedInUser;

import java.io.IOException;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            LoggedInUser fakeUser =
                    new LoggedInUser(java.util.UUID.randomUUID().toString(), username.replaceAll("((@.*)|[^a-zA-Z])+", " ").trim());
            return new Result.Success<>(fakeUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}