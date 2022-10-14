package com.unho.unhomeals.server.DTO;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

public class ApplicationDTO {
    @NonNull
    final String username;

    @NonNull
    @SerializedName("created_at")
    final LocalDateTime createdAt;

    @Deprecated
    private ApplicationDTO(@NonNull String username) {
        this.username = username;
        this.createdAt = LocalDateTime.now();
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    @NonNull
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
