package com.unho.unhomeals.server.DTO;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class LogoutRequestData {
    @NonNull
    final String username;

    @NonNull
    @SerializedName("session_id")
    final String sessionId;

    public LogoutRequestData(@NonNull String username, @NonNull String sessionId) {
        this.username = username;
        this.sessionId = sessionId;
    }
}
