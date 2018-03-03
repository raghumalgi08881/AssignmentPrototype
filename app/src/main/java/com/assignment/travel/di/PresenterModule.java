package com.assignment.travel.di;

import android.content.Context;

import com.assignment.travel.repository.ClearTripWebServiceInteractor;
import com.assignment.travel.ui.home.CleartripHomeContract;
import com.assignment.travel.ui.home.CleartripHomePresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

  @Provides
  @Singleton
  CleartripHomeContract.UserActionsListener provideRoomsListPresenter(Context context) {
    return new CleartripHomePresenter(context);
  }


  @Provides
  @Singleton
  ClearTripWebServiceInteractor provideRoomsRepo(Context context) {
    return new ClearTripWebServiceInteractor(context);
  }
}