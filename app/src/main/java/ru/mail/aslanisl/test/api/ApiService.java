package ru.mail.aslanisl.test.api;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.mail.aslanisl.test.model.api.ApiResponse;

/**
 * Created by Ivan on 31.01.2018.
 */

public interface ApiService {
    String BASE_URL = "http://tomato.city-club.net/";
    String IMAGE_URL = "http://tomato.city-club.net/static/images";

    @GET("/api/v1/action/list/1/")
    Call<ApiResponse> getShares();

    @GET("/api/v1/poster/list/1/")
    Call<ApiResponse> getEventsPosters();
}
