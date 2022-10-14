package com.unho.unhomeals.server.DTO;

import com.unho.unhomeals.server.ServerConnException;

import java.util.Map;

public class RankResponse extends ServerResponse {
    Map<String, Integer> rank;

    @Deprecated
    private RankResponse(boolean isError) {
        super(isError);
    }

    public Map<String, Integer> getRank() throws ServerConnException {
        check_error();
        return rank;
    }
}
