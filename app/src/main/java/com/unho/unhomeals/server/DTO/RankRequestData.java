package com.unho.unhomeals.server.DTO;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class RankRequestData {
    @NonNull
    @SerializedName("session_id")
    final String sessionId;

    public RankRequestData(@NonNull String sessionId) {
        this.sessionId = sessionId;
    }
}
