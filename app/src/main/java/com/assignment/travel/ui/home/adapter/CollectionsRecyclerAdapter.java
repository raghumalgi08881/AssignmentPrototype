package com.assignment.travel.ui.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.assignment.travel.R;
import com.assignment.travel.di.NetworkModule;
import com.assignment.travel.model.Collections;
import com.squareup.picasso.Picasso;

import java.util.List;


public class CollectionsRecyclerAdapter extends RecyclerView.Adapter<CollectionsRecyclerAdapter.CollectionsListViewHolder> {

    private List<Collections> itemList;
    private Context context;

    public CollectionsRecyclerAdapter(Context context, List<Collections> itemList) {
        this.itemList = itemList;
        this.context = context;

    }

    @Override
    public CollectionsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.category_item_view, parent, false);
        return new CollectionsListViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(CollectionsListViewHolder holder, int position) {
        Collections item = getItem(position);
        holder.title.setText(item.collection_name);
        holder.subtitle.setText(item.count_text);
        String image = NetworkModule.IMAGE_BASE_URL+ item.image.replace("{type}","w");

        Picasso.with(context).load(image).into(holder.image);


    }



    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public Collections getItem(int position) {
        return itemList.get(position);
    }


    class CollectionsListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView image;
        public TextView title;
        public TextView subtitle;


        public View divider;

        public CollectionsListViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            image = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
            subtitle = (TextView) itemView.findViewById(R.id.subtitle);


        }

        @Override
        public void onClick(View view) {

        }


    }
}