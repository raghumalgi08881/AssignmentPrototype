package com.assignment.travel.di;


import com.assignment.travel.repository.ClearTripWebServiceInteractor;
import com.assignment.travel.ui.home.ClearTripHomeActivity;
import com.assignment.travel.ui.home.CleartripHomePresenter;

import javax.inject.Singleton;

import dagger.Component;



    @Singleton
    @Component(modules = {AppModule.class, PresenterModule.class,NetworkModule.class,ModelModule.class})
    public interface AppComponent {

        void inject(ClearTripHomeActivity clearTripHomeActivity);
        void inject(ClearTripWebServiceInteractor webServiceInteractor);
        void inject(CleartripHomePresenter homePresenter);
    }


