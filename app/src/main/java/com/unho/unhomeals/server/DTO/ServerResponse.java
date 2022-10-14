package com.unho.unhomeals.server.DTO;

import com.google.gson.annotations.SerializedName;
import com.unho.unhomeals.server.ServerConnException;

public class ServerResponse {
    @SerializedName("is_error")
    final boolean isError;
    ResponseError error;

    public ServerResponse(boolean isError) {
        this.isError = isError;
    }

    public void check_error() throws ServerConnException {
        if (isError) {
            throw new ServerConnException(error.type, error.content);
        }
    }

    public boolean isError() {
        return isError;
    }

    public ResponseError getError() {
        return error;
    }
}
