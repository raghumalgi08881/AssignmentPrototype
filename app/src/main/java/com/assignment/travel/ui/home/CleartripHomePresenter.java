package com.assignment.travel.ui.home;

import android.content.Context;

import com.assignment.travel.ClearTripAssigmentApplication;
import com.assignment.travel.model.ApiResponse;
import com.assignment.travel.model.Carousel;
import com.assignment.travel.repository.ClearTripWebServiceInteractor;
import com.assignment.travel.repository.ClearTripWebserviceListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class CleartripHomePresenter implements CleartripHomeContract.UserActionsListener,ClearTripWebserviceListener {

    @Inject
     ClearTripWebServiceInteractor webServiceInteractor;

    private CleartripHomeContract.View  view;


    public CleartripHomePresenter(Context context) {
        ((ClearTripAssigmentApplication)context).getAppComponent().inject(this);

    }


    @Override
    public void setView(CleartripHomeContract.View view){
        this.view = view;
    }





    @Override
    public void onSuccess(ApiResponse response) {
        view.setProgressIndicator(false);
        view.loadResponse(response);
    }


    @Override
    public List<Carousel> filterCarousels(List<Carousel> carousels, List<Integer> ids){
        List<Carousel> carouselList = new ArrayList<>();
        for (Carousel carousel :carousels){
            if(ids.contains(carousel.id)){
                carouselList.add(carousel);
            }
        }

        return carouselList;

    }

    @Override
    public void onFailure() {
        view.setProgressIndicator(false);
        view.failedToFetchResponse();
    }

    @Override
    public void getApiResponse() {
        view.setProgressIndicator(true);
        webServiceInteractor.getResponse(this);
    }
}
