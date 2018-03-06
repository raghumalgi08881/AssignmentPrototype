package com.assignment.travel.ui.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.assignment.travel.R;
import com.assignment.travel.model.Collections;
import com.assignment.travel.ui.home.adapter.CategoriesRecyclerAdapter;
import com.assignment.travel.ui.home.adapter.ItemOffsetDecoration;

import java.util.ArrayList;
import java.util.List;

public class CategoryListFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private List<Collections> collections = new ArrayList<>();
    private View view;


    public static CategoryListFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        CategoryListFragment fragment = new CategoryListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public void setCollections(List<Collections> collections){
        this.collections = collections;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_category_list, container, false);
          initAndLoadCategoryList();

        return view;
    }

    public void initAndLoadCategoryList(){



        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (position % 3 == 0 ? 2 : 1);
            }
        });

        RecyclerView recycler = (RecyclerView) view.findViewById(R.id.recyclerView);
        recycler.setLayoutManager(manager);
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(getActivity(), R.dimen.spacing);
        recycler.addItemDecoration(itemDecoration);
        recycler.setAdapter(new CategoriesRecyclerAdapter(getActivity(),collections));
    }
}