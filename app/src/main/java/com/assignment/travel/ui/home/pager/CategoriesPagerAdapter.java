package com.assignment.travel.ui.home.pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.assignment.travel.model.Categories;
import com.assignment.travel.model.Collections;
import com.assignment.travel.ui.home.CategoryListFragment;

import java.util.ArrayList;
import java.util.List;

public class CategoriesPagerAdapter extends FragmentStatePagerAdapter {
    private List<Categories> categories = new ArrayList<>();
    private List<Collections> collections =new ArrayList<>();

    public CategoriesPagerAdapter(FragmentManager fm, List<Collections> collections, List<Categories> categories) {
        super(fm);
        this.collections = collections;
        this.categories = categories;
    }




    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Fragment getItem(int position) {
        CategoryListFragment fragment = CategoryListFragment.newInstance(position + 1);

        if(categories.get(position).id.equals("0")){
            fragment.setCollections(collections);
        }
        else {
            List<Collections> otherCallections = new ArrayList<>();
            for (Collections collection : collections) {
                if (collection.categories.size() > 0 &&
                        collection.categories.contains(categories.get(position).id)) {
                    otherCallections.add(collection);
                }
            }
            fragment.setCollections(otherCallections);

        }
        return fragment;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return categories.get(position).name;
    }
}