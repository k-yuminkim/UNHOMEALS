package com.unho.unhomeals.server.DTO;

import com.google.gson.annotations.SerializedName;
import com.unho.unhomeals.data.Rate;
import com.unho.unhomeals.server.ServerConnException;

import java.util.List;

public class GetRatesResponse extends ServerResponse {
    List<Rate> rates;

    @SerializedName("total_avg_rate")
    float totalAvgRate;

    @Deprecated
    private GetRatesResponse(boolean isError) {
        super(isError);
    }

    public List<Rate> getRates() throws ServerConnException {
        check_error();
        return rates;
    }

    public float getTotalAvgRate() {
        return totalAvgRate;
    }
}
