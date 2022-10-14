package com.unho.unhomeals.data;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Rate {
    @NonNull
    @SerializedName("food_name")
    final String foodName;

    final short level;

    public Rate(@NonNull String food_name, short level) {
        this.foodName = food_name;
        this.level = level;
    }
}
