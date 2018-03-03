package com.assignment.travel.repository;

import android.content.Context;
import android.util.Log;

import com.assignment.travel.ClearTripAssigmentApplication;
import com.assignment.travel.api.ClearTripApiService;
import com.assignment.travel.model.ApiResponse;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ClearTripWebServiceInteractor {


    @Inject
    ClearTripApiService apiService;
    public ClearTripWebServiceInteractor(Context context){
        ((ClearTripAssigmentApplication)context).getAppComponent().inject(this);
    }


    public void getResponse(final ClearTripWebserviceListener listener){
        Call<ApiResponse> call = apiService.getResponse();
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                listener.onSuccess(response.body());

            }
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                listener.onFailure();
            }

        });

    }






}
