package com.unho.unhomeals.server;

import androidx.annotation.NonNull;

public class ServerConnException extends RuntimeException {
    private static final long serialVersionUID = 8520561434237787827L;

    public enum ExceptionKind {
        CannotConnect,
        RustlsError,
        ConfigError,
        BlockingError,
        DBError,
        DBConnectionError,
        ActixWebError,
        NotFoundOnDB,
        LoginError,
        TokenError,
        TokenExpired,
        AlreadyLoggedIn,
        NoSuchSession,
        DateChanged,
        Unprivileged,
        IO,
    }

    @NonNull
    final ExceptionKind kind;

    @NonNull
    final String message;

    public ServerConnException(@NonNull String type, @NonNull String message) {
        this.kind = ExceptionKind.valueOf(type);
        this.message = message;
    }

    @NonNull
    public ExceptionKind getKind() {
        return kind;
    }

    @NonNull
    @Override
    public String getMessage() {
        return message;
    }
}
