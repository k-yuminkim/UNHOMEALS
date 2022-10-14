package com.unho.unhomeals.server.DTO;

import com.unho.unhomeals.server.ServerConnException;

public class HasAppliedResponse extends ServerResponse {
    boolean applied;

    @Deprecated
    private HasAppliedResponse(boolean isError) {
        super(isError);
    }

    public boolean isApplied() throws ServerConnException {
        check_error();
        return applied;
    }
}
