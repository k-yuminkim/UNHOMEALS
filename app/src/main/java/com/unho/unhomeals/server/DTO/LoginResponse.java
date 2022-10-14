package com.unho.unhomeals.server.DTO;

import com.google.gson.annotations.SerializedName;
import com.unho.unhomeals.server.ServerConnException;

public class LoginResponse extends ServerResponse {
    @SerializedName("session_id")
    String sessionId;

    @Deprecated
    private LoginResponse(boolean isError) {
        super(isError);
    }

    public String getSessionId() throws ServerConnException {
        check_error();
        return sessionId;
    }
}
