package com.unho.unhomeals.server.DTO;

import androidx.annotation.NonNull;

public class LoginRequestData {
    @NonNull
    final String username;
    /* TODO: use password
    @NonNull
    String password;
     */

    public LoginRequestData(@NonNull String username) {
        this.username = username;
    }
}
