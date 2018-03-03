package com.assignment.travel.repository;


import com.assignment.travel.model.ApiResponse;

public interface ClearTripWebserviceListener {
     void onSuccess(ApiResponse response);
    void onFailure();

}
