package com.assignment.travel.ui.home;

import com.assignment.travel.model.ApiResponse;
import com.assignment.travel.model.Carousel;

import java.util.List;


public interface CleartripHomeContract {

    interface View {

        void setProgressIndicator(boolean active);
        void loadResponse(ApiResponse response);
        void failedToFetchResponse();


    }

    interface UserActionsListener {
        void  getApiResponse();
        void  setView(CleartripHomeContract.View view);
        List<Carousel> filterCarousel(List<Carousel> carousels, List<Integer> ids);


    }
}
