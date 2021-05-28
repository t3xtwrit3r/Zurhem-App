package com.example.zurhemapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zurhemapp.customViewpager.CustomViewpager;
import com.example.zurhemapp.listener.FeatureProductsListener;
import com.example.zurhemapp.model.Datum;
import com.example.zurhemapp.model.MainActivityImage;
import com.example.zurhemapp.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder> {

    public static final int show_bottom = 0;
    public static final int showTop = 1;

    private Context context;
    private Activity activity;
    private ArrayList<MainActivityImage> imagelistArrayList;
    private List<Datum> data;
    FeatureProductsListener featureProductsListener;


    public MainRecyclerAdapter(Context context, Activity activity, ArrayList<MainActivityImage> imagelistArrayList, List<Datum> data, FeatureProductsListener featureProductsListener) {
        this.context = context;
        this.activity = activity;
        this.imagelistArrayList = imagelistArrayList;
        this.data = data;
        this.featureProductsListener = featureProductsListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == showTop){
            view = LayoutInflater.from(context).inflate(R.layout.viewpager_item, parent, false);
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.bottom_layout, parent, false);
        }

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(imagelistArrayList.get(position), context, position, data);
        featureProductsListener.onScroll();
        mainPagerAdapter.notifyDataSetChanged();
        if (position!=imagelistArrayList.size()-1){
            holder.pager.setAdapter(mainPagerAdapter);
        }

        if (position == 0){
            holder.dotsIndicator.setViewPager(holder.pager);
        }
        if (position == 1 ||position == 3){
            holder.sliderNav.setVisibility(View.VISIBLE);
            holder.btn_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.pager.setCurrentItem(holder.pager.getCurrentItem() + 1);
                }
            });
            holder.btn_prev.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.pager.setCurrentItem(holder.pager.getCurrentItem() - 1);
                }
            });
        }
        Timer timer = new Timer();
        if (position == 3){
            holder.pager.setPadding(0,110,0,0);
            timer.scheduleAtFixedRate(new MyTimerTask(holder.pager, data.size()),2000,3500);
            holder.featuredItems.setVisibility(View.VISIBLE);
        } else if (position == 0 || position == 1){
            timer.scheduleAtFixedRate(new MyTimerTask(holder.pager, 3),2000,3500);
        }



    }

    @Override
    public int getItemCount() {
        return imagelistArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        CustomViewpager pager;
        DotsIndicator dotsIndicator;
        TextView featuredItems;
        RelativeLayout sliderNav;
        LinearLayout btn_prev, btn_next;
        YouTubePlayerView youTubePlayerView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            youTubePlayerView = itemView.findViewById(R.id.youtube_player_view);
            pager = itemView.findViewById(R.id.pager);
            dotsIndicator = itemView.findViewById(R.id.dots_indicator);
            featuredItems = itemView.findViewById(R.id.featuredItems);
            sliderNav = itemView.findViewById(R.id.sliderNav);
            btn_prev = itemView.findViewById(R.id.btn_prev);
            btn_next = itemView.findViewById(R.id.btn_next);

        }
    }


    public class MyTimerTask extends TimerTask {
        CustomViewpager customViewpager;
        int size;

        public MyTimerTask(CustomViewpager customViewpager, int size) {
            this.customViewpager = customViewpager;
            this.size = size;
        }

        @Override
        public void run() {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (customViewpager.getCurrentItem() < size - 1) {
                        customViewpager.setCurrentItem(customViewpager.getCurrentItem() + 1, true);
                    } else {
                        customViewpager.setCurrentItem(0, true);
                    }

                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == imagelistArrayList.size()-1){
            return show_bottom;
        } else {
            return showTop;
        }
    }
}
