package com.unho.unhomeals.server.DTO;

import com.google.gson.annotations.SerializedName;
import com.unho.unhomeals.data.Rate;
import com.unho.unhomeals.server.ServerConnException;

import java.util.List;

public class GetUserRatesResponse extends ServerResponse {
    List<Rate> rates;
    @SerializedName("total_rate")
    Short totalRate;

    @Deprecated
    private GetUserRatesResponse(boolean isError) {
        super(isError);
    }

    public List<Rate> getRates() throws ServerConnException {
        check_error();
        return rates;
    }

    public Short getTotalRate() {
        check_error();
        return totalRate;
    }
}
