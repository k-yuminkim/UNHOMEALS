package com.unho.unhomeals.server.DTO;

import com.unho.unhomeals.server.ServerConnException;

import java.util.List;


public class GetApplicationsResponse extends ServerResponse {
    List<ApplicationDTO> applications;

    @Deprecated
    private GetApplicationsResponse(boolean isError) {
        super(isError);
    }

    public List<ApplicationDTO> getApplications() throws ServerConnException {
        check_error();
        return applications;
    }
}
