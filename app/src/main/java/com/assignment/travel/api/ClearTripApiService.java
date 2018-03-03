package com.assignment.travel.api;


import com.assignment.travel.model.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ClearTripApiService {
    @GET("local/api/v1/ttd/search?sct=IN&editorial=true&city=chennai&scr=INR")
    Call<ApiResponse> getResponse();


}
