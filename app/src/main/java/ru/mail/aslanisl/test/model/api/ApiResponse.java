package ru.mail.aslanisl.test.model.api;

import java.util.List;

/**
 * Created by Ivan on 31.01.2018.
 */

public class ApiResponse {
    private int status;
    private int moment;
    private List<ResultResponse> response;

    public int getStatus() {
        return status;
    }

    public int getMoment() {
        return moment;
    }

    public List<ResultResponse> getResponses() {
        return response;
    }
}
