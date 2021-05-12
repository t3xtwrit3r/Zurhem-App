package com.example.zurhemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.zurhemapp.Adapter.ProductDetailsPagerAdapter;
import com.example.zurhemapp.CustomViewpager.CustomViewpager;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ProductDetails extends AppCompatActivity {

    ProductDetailsPagerAdapter adapter;
    ArrayList<Integer> imgList;
    CustomViewpager proDetailsPager;
    DotsIndicator proDetIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Timer timer= new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(),2000,3000);

        proDetailsPager = findViewById(R.id.proDetailsPager);
        proDetIndicator = findViewById(R.id.proDetIndicator);

        imgList = new ArrayList<>();

        imgList.add(R.drawable.man2);
        imgList.add(R.drawable.m1);
        imgList.add(R.drawable.m2);
        imgList.add(R.drawable.m3);

        adapter = new ProductDetailsPagerAdapter(ProductDetails.this, imgList);
        proDetailsPager.setAdapter(adapter);
        proDetIndicator.setViewPager(proDetailsPager);

    }

    public class MyTimerTask extends TimerTask{

        @Override
        public void run() {
            ProductDetails.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (proDetailsPager.getCurrentItem() < adapter.getCount() - 1) {
                        proDetailsPager.setCurrentItem(proDetailsPager.getCurrentItem() + 1, true);
                    } else {
                        proDetailsPager.setCurrentItem(0, true);
                    }
                }
            });
        }
    }

}