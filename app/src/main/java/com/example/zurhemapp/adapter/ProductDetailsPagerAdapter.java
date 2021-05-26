package com.example.zurhemapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.zurhemapp.R;

import java.util.ArrayList;

public class ProductDetailsPagerAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<Integer> imgList;

    public ProductDetailsPagerAdapter(Context context, ArrayList<Integer> imgList) {
        this.context = context;
        this.imgList = imgList;
    }

    @Override
    public int getCount() {
        return imgList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_details_slider, container, false);

        ImageView proDetImgView;

        proDetImgView = view.findViewById(R.id.proDetImgView);

        Integer img = imgList.get(position);

        if (img != null){
            Glide.with(context).load(img).into(proDetImgView);
        }


        container.addView(view, 0);


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}

