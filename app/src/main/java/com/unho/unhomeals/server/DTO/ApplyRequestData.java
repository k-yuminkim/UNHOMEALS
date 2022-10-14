package com.unho.unhomeals.server.DTO;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;

public class ApplyRequestData {
    @NonNull
    @SerializedName("session_id")
    final String sessionId;

    final boolean apply;

    @NonNull
    @SerializedName("send_date")
    final LocalDate sendDate;

    public ApplyRequestData(@NonNull String sessionId, boolean apply) {
        this.sessionId = sessionId;
        this.apply = apply;
        this.sendDate = LocalDate.now();
    }
}
