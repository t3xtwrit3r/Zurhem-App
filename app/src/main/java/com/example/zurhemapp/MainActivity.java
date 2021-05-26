package com.example.zurhemapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.zurhemapp.Adapter.MainRecyclerAdapter;
import com.example.zurhemapp.Fragments.NavPanelFragment;
import com.example.zurhemapp.Model.Image;
import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> imagelist;
    ArrayList<Integer> catList;
    ArrayList<Integer> featuredList;
    ArrayList<Integer> custom;
    ArrayList<Integer> layout;
    ArrayList<Image> imagelistArrayList;
    RecyclerView viewPagerRecycler;
    MainRecyclerAdapter mainRecyclerAdapter;
    ImageView imageView1;
    ImageView imageView2;
    FrameLayout navView;
    Toolbar toolbar1;
    Fragment fragment = null;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        navView = findViewById(R.id.navView);
        toolbar1 = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new NavPanelFragment();
                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_right_to_left, R.anim.exit_left_to_right).replace(R.id.navView, fragment).commit();

            }
        });

        imagelist = new ArrayList<>();
        catList = new ArrayList<>();
        custom = new ArrayList<>();
        featuredList = new ArrayList<>();
        layout = new ArrayList<>();
        imagelistArrayList = new ArrayList<>();
        imagelistArrayList.clear();
        imagelist.clear();
        catList.clear();
        custom.clear();
        layout.clear();

        imagelist.add(R.drawable.slider_two);
        imagelist.add(R.drawable.slider_two);
        imagelist.add(R.drawable.slider_two);

        catList.add(R.drawable.men);
        catList.add(R.drawable.women);
        catList.add(R.drawable.gifts);

        custom.add(R.drawable.custom);

        layout.add(R.drawable.woman2);

        featuredList.add(R.drawable.man4);
        featuredList.add(R.drawable.woman1);
        featuredList.add(R.drawable.woman2);
        featuredList.add(R.drawable.man2);
        featuredList.add(R.drawable.man3);
        featuredList.add(R.drawable.woman3);
        featuredList.add(R.drawable.man1);
        featuredList.add(R.drawable.woman4);

        imagelistArrayList.add(new Image(imagelist));
        imagelistArrayList.add(new Image(catList));
        imagelistArrayList.add(new Image(custom));
        imagelistArrayList.add(new Image(featuredList));
        imagelistArrayList.add(new Image(layout));

        layoutManager = new LinearLayoutManager(MainActivity.this);
        viewPagerRecycler = findViewById(R.id.ViewPagerRecycler);
        mainRecyclerAdapter = new MainRecyclerAdapter(MainActivity.this, MainActivity.this, imagelistArrayList);
        viewPagerRecycler.setLayoutManager(layoutManager);
        viewPagerRecycler.setAdapter(mainRecyclerAdapter);


    }




    @Override
    public void onBackPressed() {

    }
}