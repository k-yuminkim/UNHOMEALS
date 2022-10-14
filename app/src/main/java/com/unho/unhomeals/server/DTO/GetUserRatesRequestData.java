package com.unho.unhomeals.server.DTO;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class GetUserRatesRequestData {
    @NonNull
    @SerializedName("session_id")
    final String sessionId;

    @NonNull
    final String username;

    public GetUserRatesRequestData(@NonNull String sessionId, @NonNull String username) {
        this.sessionId = sessionId;
        this.username = username;
    }
}
