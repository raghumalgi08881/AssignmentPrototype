package com.assignment.travel.di;


import com.assignment.travel.model.Categories;

import dagger.Module;
import dagger.Provides;

@Module
public class ModelModule {

  @Provides
  Categories provideSendPasses() {
    return new Categories();
  }


}