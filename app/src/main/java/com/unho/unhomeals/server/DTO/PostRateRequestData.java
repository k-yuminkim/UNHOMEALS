package com.unho.unhomeals.server.DTO;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import com.unho.unhomeals.data.Rate;

import java.time.LocalDate;
import java.util.List;

public class PostRateRequestData {
    @NonNull
    @SerializedName("session_id")
    final String sessionId;

    @NonNull
    final List<Rate> rates;

    @SerializedName("total_rate")
    final short totalRate;

    @NonNull
    @SerializedName("send_date")
    final LocalDate sendDate;

    public PostRateRequestData(@NonNull String sessionId, @NonNull List<Rate> rates, short totalRate) {
        this.sessionId = sessionId;
        this.rates = rates;
        this.totalRate = totalRate;
        this.sendDate = LocalDate.now();
    }
}
