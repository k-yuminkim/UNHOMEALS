package com.unho.unhomeals.server;

import com.unho.unhomeals.server.DTO.ApplyRequestData;
import com.unho.unhomeals.server.DTO.GetApplicationsRequestData;
import com.unho.unhomeals.server.DTO.GetApplicationsResponse;
import com.unho.unhomeals.server.DTO.GetRatesResponse;
import com.unho.unhomeals.server.DTO.GetRatesRequestData;
import com.unho.unhomeals.server.DTO.GetUserRatesRequestData;
import com.unho.unhomeals.server.DTO.GetUserRatesResponse;
import com.unho.unhomeals.server.DTO.HasAppliedRequestData;
import com.unho.unhomeals.server.DTO.HasAppliedResponse;
import com.unho.unhomeals.server.DTO.LoginRequestData;
import com.unho.unhomeals.server.DTO.LoginResponse;
import com.unho.unhomeals.server.DTO.LogoutRequestData;
import com.unho.unhomeals.server.DTO.LogoutResponse;
import com.unho.unhomeals.server.DTO.PostRateRequestData;
import com.unho.unhomeals.server.DTO.RankRequestData;
import com.unho.unhomeals.server.DTO.RankResponse;
import com.unho.unhomeals.server.DTO.ServerResponse;
import com.unho.unhomeals.server.DTO.UserRequestData;
import com.unho.unhomeals.server.DTO.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface IService {
    @POST("/test")
    Call<Void> test();

    @POST("/login")
    Call<LoginResponse> login(@Body LoginRequestData body);

    @POST("/logout")
    Call<LogoutResponse> logout(@Body LogoutRequestData body);

    @POST("/apply")
    Call<ServerResponse> apply(@Body ApplyRequestData body);

    @POST("/applications")
    Call<GetApplicationsResponse> getApplications(@Body GetApplicationsRequestData body);

    @POST("/has_applied")
    Call<HasAppliedResponse> hasApplied(@Body HasAppliedRequestData body);

    @POST("/post_rate")
    Call<ServerResponse> postRate(@Body PostRateRequestData body);

    @POST("/get_rates")
    Call<GetRatesResponse> getRates(@Body GetRatesRequestData body);

    @POST("/get_user_rates")
    Call<GetUserRatesResponse> getUserRates(@Body GetUserRatesRequestData body);

    @POST("/rank")
    Call<RankResponse> rank(@Body RankRequestData body);

    @POST("/user")
    Call<UserResponse> user(@Body UserRequestData body);
}
