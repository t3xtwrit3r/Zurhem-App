package com.example.zurhemapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.zurhemapp.CustomViewpager.CustomViewpager;
import com.example.zurhemapp.R;
import com.example.zurhemapp.adapter.ProductDetailsPagerAdapter;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ProductDetailsActivity extends AppCompatActivity {

    private ProductDetailsPagerAdapter adapter;
    private ArrayList<Integer> imgList;
    private CustomViewpager proDetailsPager;
    private DotsIndicator proDetIndicator;
    private ImageView productImage1, productImage2, productImage3, productImage4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Timer timer= new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(),2000,3000);

        proDetailsPager = findViewById(R.id.proDetailsPager);
        proDetIndicator = findViewById(R.id.proDetIndicator);
        productImage1 = findViewById(R.id.productImage1);
        productImage2 = findViewById(R.id.productImage2);
        productImage3 = findViewById(R.id.productImage3);
        productImage4 = findViewById(R.id.productImage4);

        imgList = new ArrayList<>();

        imgList.add(R.drawable.man2);
        imgList.add(R.drawable.m1);
        imgList.add(R.drawable.m2);
        imgList.add(R.drawable.m3);

        adapter = new ProductDetailsPagerAdapter(ProductDetailsActivity.this, imgList);
        proDetailsPager.setAdapter(adapter);
        proDetIndicator.setViewPager(proDetailsPager);

        Glide.with(this).load(R.drawable.man2).into(productImage1);
        Glide.with(this).load(R.drawable.m1).into(productImage2);
        Glide.with(this).load(R.drawable.m2).into(productImage3);
        Glide.with(this).load(R.drawable.m3).into(productImage4);

    }

    public class MyTimerTask extends TimerTask{

        @Override
        public void run() {
            ProductDetailsActivity.this.runOnUiThread(new Runnable() {
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