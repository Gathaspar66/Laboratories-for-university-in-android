package com.example.lab03.data;

import com.example.lab03.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {
        String[] tablica = {"user", "haslo"};
        LoggedInUser fakeUser;
     //   try {
            // TODO: handle loggedInUser authentication
            if ((tablica[0].equals(username)) && (tablica[1].equals(password))) {
                 fakeUser =
                        new LoggedInUser(
                                java.util.UUID.randomUUID().toString(),
                                "JAN KOWALSKI");
                return new Result.Success<>(fakeUser);
            }else{

                return new Result.Error(new IOException("Error logging in"));
            }

       // } catch (Exception e) {
         //   return new Result.Error(new IOException("Error logging in", e));
        }




    public void logout() {
        // TODO: revoke authentication
    }
}
