package com.example.zurhemapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.zurhemapp.adapter.MainRecyclerAdapter;
import com.example.zurhemapp.listener.FeatureProductsListener;
import com.example.zurhemapp.model.Datum;
import com.example.zurhemapp.fragments.NavPanelFragment;
import com.example.zurhemapp.model.MainActivityImage;
import com.example.zurhemapp.R;
import com.example.zurhemapp.viewmodel.FeatureProductViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FeatureProductsListener {
    private List<Datum> data = new ArrayList<>();
    private ArrayList<Integer> imagelist;
    private ArrayList<Integer> catList;
    private ArrayList<Integer> featuredList;
    private ArrayList<Integer> custom;
    private ArrayList<Integer> layout;
    private ArrayList<MainActivityImage> imagelistArrayList;
    private RecyclerView viewPagerRecycler;
    private MainRecyclerAdapter mainRecyclerAdapter;
    private ImageView imageView1;
    private ImageView imageView2;
    private FrameLayout navView;
    private Toolbar toolbar1;
    private Fragment fragment = null;
    private LinearLayoutManager layoutManager;
    boolean isLoading = false;

    private FeatureProductViewModel featureProductViewModel;
    private int currentPage = 1;
    private int totalAvailablePages = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        featureProductViewModel = ViewModelProviders.of(this).get(FeatureProductViewModel.class);
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

        imagelistArrayList.add(new MainActivityImage(imagelist));
        imagelistArrayList.add(new MainActivityImage(catList));
        imagelistArrayList.add(new MainActivityImage(custom));
        imagelistArrayList.add(new MainActivityImage(featuredList));
        imagelistArrayList.add(new MainActivityImage(layout));


        layoutManager = new LinearLayoutManager(MainActivity.this);
        viewPagerRecycler = findViewById(R.id.ViewPagerRecycler);
        mainRecyclerAdapter = new MainRecyclerAdapter(MainActivity.this, MainActivity.this, imagelistArrayList, data, this);
        viewPagerRecycler.setLayoutManager(layoutManager);
        viewPagerRecycler.setAdapter(mainRecyclerAdapter);

        getFeatureProduct();

    }

    public void getFeatureProduct(){
        featureProductViewModel.getFeatureProduct(currentPage).observe(this, FeatureProductsResponse ->{
            if (FeatureProductsResponse != null){
                totalAvailablePages = FeatureProductsResponse.getMeta().getLastPage();
                if (FeatureProductsResponse.getData() != null){
                    data.addAll(FeatureProductsResponse.getData());
                    mainRecyclerAdapter.notifyDataSetChanged();
                }
            }
        });

    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public void onScroll() {
        if (currentPage <= totalAvailablePages){
            currentPage += 1;
            getFeatureProduct();
        }
    }
}