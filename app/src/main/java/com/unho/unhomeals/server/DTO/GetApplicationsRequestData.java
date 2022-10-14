package com.unho.unhomeals.server.DTO;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class GetApplicationsRequestData {
    @NonNull
    @SerializedName("session_id")
    final String sessionId;

    public GetApplicationsRequestData(@NonNull String sessionId) {
        this.sessionId = sessionId;
    }
}
