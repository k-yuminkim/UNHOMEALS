package com.unho.unhomeals.data;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

public class User {
    public static User user;
    public static String SID;
    public static String UID;

    @NonNull
    @SerializedName("username")
    final String userId;
    @NonNull
    final String name;
    @NonNull
    @SerializedName("auto_apply")
    final Boolean autoApply;
    @NonNull
    @SerializedName("is_teacher")
    final Boolean isTeacher;
    @NonNull
    @SerializedName("created_at")
    final LocalDateTime createdAt;

    private User(@NonNull String username, @NonNull String name, boolean autoApply, boolean isTeacher, @NonNull LocalDateTime createdAt) {
        this.userId = username;
        this.name = name;
        this.autoApply = autoApply;
        this.isTeacher = isTeacher;
        this.createdAt = createdAt;
    }

    public static void loadDataFromSharedPf(AppCompatActivity activity) {
        UID = SharedPf.getString(activity, "UID");
        SID = SharedPf.getString(activity, "SID");
    }

    @NonNull
    public String getUserId() {
        return userId;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public Boolean getAutoApply() {
        return autoApply;
    }

    @NonNull
    public Boolean getTeacher() {
        return isTeacher;
    }

    @NonNull
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
