package com.unho.unhomeals.server.DTO;

import androidx.annotation.NonNull;

import com.unho.unhomeals.server.ServerConnException;

public class ResponseError {
    @NonNull
    final String type;

    @NonNull
    final String content;

    @Deprecated
    private ResponseError(@NonNull String type, @NonNull String content) {
        this.type = type;
        this.content = content;
    }

    @NonNull
    public String getType() {
        return type;
    }

    @NonNull
    public String getContent() {
        return content;
    }

    public ServerConnException toException() {
        return new ServerConnException(type, content);
    }
}
