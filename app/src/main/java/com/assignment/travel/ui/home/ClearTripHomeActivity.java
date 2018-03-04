package com.assignment.travel.ui.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.assignment.travel.ClearTripAssigmentApplication;
import com.assignment.travel.R;
import com.assignment.travel.model.ApiResponse;
import com.assignment.travel.model.Carousel;
import com.assignment.travel.model.Categories;
import com.assignment.travel.model.Collections;
import com.assignment.travel.ui.home.adapter.EditorialRecyclerAdapter;
import com.assignment.travel.ui.home.adapter.ItemOffsetDecoration;
import com.assignment.travel.ui.home.pager.CarouselPagerAdapter;
import com.assignment.travel.ui.home.pager.CategoriesPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import me.relex.circleindicator.CircleIndicator;

public class ClearTripHomeActivity extends AppCompatActivity implements CleartripHomeContract.View{

    @Inject
     CleartripHomeContract.UserActionsListener presenter;
    private CoordinatorLayout coordinatorLayout;
    private ProgressBar progressBar;
    @Inject
    Categories category;
    private TextView cityName;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_activities:
                    return true;
                case R.id.navigation_eatout:
                    return true;
                case R.id.navigation_events:
                    return true;
                case R.id.navigation_you:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activities_layout);
        ((ClearTripAssigmentApplication)getApplication()).getAppComponent().inject(this);
        cityName = findViewById(R.id.city);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id
                .coordinatorLayout);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        presenter.setView(this);
        presenter.getApiResponse();
    }



    private void initAndLoadCarouselPager(@NonNull ApiResponse response) {
        List<Carousel> carousels =  presenter.filterCarousels(response.editorial.carousel,response.editorial.ttd.cp);
        ViewPager pager = findViewById(R.id.pager);
        pager.setClipToPadding(false);
        pager.setPageMargin(12);
        CircleIndicator indicator = findViewById(R.id.indicator);
        CarouselPagerAdapter adapter = new CarouselPagerAdapter(this, carousels);
        pager.setAdapter(adapter);
        indicator.setViewPager(pager);
        adapter.registerDataSetObserver(indicator.getDataSetObserver());

    }
    private void initAndLoadEditorialChoice(@NonNull ApiResponse response) {
        List<Collections> collections =  response.editorial.ttd.p.collection;
        RecyclerView recyclerView = findViewById(R.id.editorial_recyclerView);
        EditorialRecyclerAdapter adapter = new EditorialRecyclerAdapter(this, collections);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(this, R.dimen.spacing);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initAndLoadCategoryList(@NonNull final ApiResponse response){
        List<Collections> collections =  response.collections;
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        List<Categories> categories = new ArrayList<>();
        category.name = getString(R.string.all_categories);
        category.id = "0";
        categories.add(category);
        categories.addAll(response.categories);
        CategoriesPagerAdapter adapter = new CategoriesPagerAdapter(getSupportFragmentManager(),collections,categories);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }



    @Override
    public void setProgressIndicator(boolean active) {
        if(active){
            progressBar.setVisibility(View.VISIBLE);
        }else{
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void loadResponse(@NonNull ApiResponse response) {
       initAndLoadCarouselPager(response);
       initAndLoadEditorialChoice(response);
       initAndLoadCategoryList(response);
       cityName.setText(response.city.name);
        findViewById(R.id.editorialTv).setVisibility(View.VISIBLE);
        findViewById(R.id.navigation).setVisibility(View.VISIBLE);
        findViewById(R.id.deals).setVisibility(View.VISIBLE);
    }

    @Override
    public void failedToFetchResponse() {
        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, getString(R.string.failure_message), Snackbar.LENGTH_LONG);

        snackbar.show();
    }


}
