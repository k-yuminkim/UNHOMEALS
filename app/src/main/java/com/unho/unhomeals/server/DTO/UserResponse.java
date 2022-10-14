package com.unho.unhomeals.server.DTO;

import com.unho.unhomeals.data.User;
import com.unho.unhomeals.server.ServerConnException;

public class UserResponse extends ServerResponse {
    User user;

    @Deprecated
    private UserResponse(boolean isError) {
        super(isError);
    }

    public User getUser() throws ServerConnException {
        check_error();
        return user;
    }
}
