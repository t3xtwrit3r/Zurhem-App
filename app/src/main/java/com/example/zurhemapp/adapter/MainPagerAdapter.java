package com.example.zurhemapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.zurhemapp.activity.CategoryItemActivity;
import com.example.zurhemapp.model.Datum;
import com.example.zurhemapp.model.Image;
import com.example.zurhemapp.R;

import java.util.List;

public class MainPagerAdapter extends PagerAdapter {

    private Image image;
    private Context context;
    private int value;
    private List<Datum> data;

    public MainPagerAdapter(Image image, Context context, int value, List<Datum> data) {
        this.image = image;
        this.context = context;
        this.value = value;
        this.data = data;
    }

    @Override
    public int getCount() {
        if (value!=3){
            return image.getDrawableImage().size();
        } else {
            return data.size();
        }

    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_slider_item, container, false);
        if (value == 0){
            ImageView images = view.findViewById(R.id.image_view);
            Glide.with(context).load(image.getDrawableImage().get(position)).into(images);
        } else if(value == 1){
            LinearLayout layout = view.findViewById(R.id.linearLayout);
            layout.setVisibility(View.VISIBLE);
            LinearLayout btnCollection = view.findViewById(R.id.btnCollection);
            TextView text = view.findViewById(R.id.text);
            ImageView images = view.findViewById(R.id.image_view);
            if (position == 0){
                TextView textView = view.findViewById(R.id.catName);
                textView.setText("MEN");
                btnCollection.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnCollection.setBackgroundResource(R.drawable.btn_bg2);
                        text.setTextColor(Color.parseColor("#FFC107"));
                        Intent intent = new Intent(v.getContext(), CategoryItemActivity.class);
                        v.getContext().startActivity(intent);
                        ((Activity)context).finish();
                    }
                });
            } else if (position == 1){
                TextView textView = view.findViewById(R.id.catName);
                textView.setText("WOMEN");
            } else if (position == 2){
                TextView textView = view.findViewById(R.id.catName);
                textView.setText("GIFTS");
            }
            Glide.with(context)
                    .load(image.getDrawableImage().get(position))
                    .into(images);
        } else if (value == 2){
            LinearLayout layout = view.findViewById(R.id.linearLayout);
            layout.setVisibility(View.VISIBLE);
            TextView textView = view.findViewById(R.id.catName);
            TextView text = view.findViewById(R.id.text);
            TextView customise = view.findViewById(R.id.customise);
            customise.setVisibility(View.VISIBLE);
            LinearLayout btnCollection = view.findViewById(R.id.btnCollection);
            btnCollection.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnCollection.setBackgroundResource(R.drawable.btn_bg2);
                    text.setTextColor(Color.parseColor("#FFC107"));
                }
            });
            textView.setText("ZURHEM BESPOKE");
            text.setText("Design Now");
            ImageView images = view.findViewById(R.id.image_view);
            Glide.with(context)
                    .load(image.getDrawableImage().get(position))
                    .into(images);
        } else if (value == 3){
            LinearLayout featuredSlider = view.findViewById(R.id.featuredSlider);
            TextView dressName = view.findViewById(R.id.dressName);
            TextView price = view.findViewById(R.id.price);
            ImageView images = view.findViewById(R.id.image_view);
            Glide.with(context).load(context.getString(R.string.imgUrl).concat(data.get(position).getImage())).into(images);
            dressName.setText(data.get(position).getName());
            price.setText(data.get(position).getPrice());
            images.setPadding(0,0,0,220);
            featuredSlider.setVisibility(View.VISIBLE);
        }
        container.addView(view, 0);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

}