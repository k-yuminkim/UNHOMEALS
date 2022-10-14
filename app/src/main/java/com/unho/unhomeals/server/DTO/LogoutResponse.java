package com.unho.unhomeals.server.DTO;

import com.unho.unhomeals.server.ServerConnException;

public class LogoutResponse extends ServerResponse {
    String username;

    @Deprecated
    private LogoutResponse(boolean isError) {
        super(isError);
    }

    public String getUsername() throws ServerConnException {
        check_error();
        return username;
    }
}
