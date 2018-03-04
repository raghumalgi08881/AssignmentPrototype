package com.assignment.travel.ui.home.pager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.assignment.travel.R;
import com.assignment.travel.di.NetworkModule;
import com.assignment.travel.model.Carousel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CarouselPagerAdapter extends PagerAdapter {
 
    private List<Carousel> carousels;
    private LayoutInflater inflater;
    private Context context;
 
    public CarouselPagerAdapter(Context context, List<Carousel> carousels) {
        this.context = context;
        this.carousels=carousels;
        inflater = LayoutInflater.from(context);
    }
 
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
 
    @Override
    public int getCount() {
        return carousels.size();
    }
 
    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View myImageLayout = inflater.inflate(R.layout.carousel_item_view, view, false);
        ImageView myImage = (ImageView) myImageLayout
                .findViewById(R.id.image);
        TextView title = (TextView) myImageLayout
                .findViewById(R.id.title);
        TextView tag = (TextView) myImageLayout
                .findViewById(R.id.tag);
        TextView subtitle = (TextView) myImageLayout
                .findViewById(R.id.subtitle);
        title.setText(carousels.get(position).title);
        subtitle.setText(carousels.get(position).subTitle);
        tag.setText(carousels.get(position).tagText);
        String image = NetworkModule.IMAGE_BASE_URL+ carousels.get(position).images.get(0).img.replace("{type}","w");
        Log.d("Clearrtrip","rl is "+image);

        Picasso.with(context).load(image).into(myImage);

        view.addView(myImageLayout, 0);
        return myImageLayout;
    }
 
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}