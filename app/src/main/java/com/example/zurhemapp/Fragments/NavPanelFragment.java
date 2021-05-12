
package com.example.zurhemapp.Fragments;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zurhemapp.R;
import com.example.zurhemapp.Adapter.CategoryAdapter;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class NavPanelFragment extends Fragment {

    ArrayList<String> categoryNames;
    ImageView close;
    LinearLayout suitsLayout, jacketLayout, tuxLayout;
    TextView group_item_suits, child_item_suits1, child_item_suits2;
    TextView group_item_jackets, child_item_jackets1, child_item_jackets2;
    TextView group_item_tux, child_item_tux1, child_item_tux2;
    String isSuitExpanded = "no";
    String isJacketExpanded = "no";
    String isTuxExpanded = "no";
    DiscreteScrollView categories;
    CategoryAdapter categoryAdapter;
    Timer timer;
    TimerTask timerTask;
    int position = 1;
    LinearLayoutManager linearLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nav_panel, container, false);

        close = view.findViewById(R.id.close);
        suitsLayout = view.findViewById(R.id.suitsLayout);
        group_item_suits = view.findViewById(R.id.group_item_suits);
        child_item_suits1 = view.findViewById(R.id.child_item_suits1);
        child_item_suits2 = view.findViewById(R.id.child_item_suits2);
        jacketLayout = view.findViewById(R.id.jacketLayout);
        group_item_jackets = view.findViewById(R.id.group_item_jackets);
        child_item_jackets1 = view.findViewById(R.id.child_item_jackets1);
        child_item_jackets2 = view.findViewById(R.id.child_item_jackets2);
        tuxLayout = view.findViewById(R.id.tuxLayout);
        group_item_tux = view.findViewById(R.id.group_item_tux);
        child_item_tux1 = view.findViewById(R.id.child_item_tux1);
        child_item_tux2 = view.findViewById(R.id.child_item_tux2);
        categories = view.findViewById(R.id.categories);

        categoryNames = new ArrayList<>();

        categoryNames.add("NEW IN");
        categoryNames.add("MEN");
        categoryNames.add("WOMEN");
        categoryNames.add("GIFTS");
        categoryNames.add("WORLD");
        categoryNames.add("RUNWAY");

        categoryAdapter = new CategoryAdapter(getContext(), categoryNames);
        categories.setAdapter(categoryAdapter);
        categories.setSlideOnFling(true);
        categories.setOverScrollEnabled(true);


        group_item_suits.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if (isJacketExpanded.equals("yes")){
                    ExpandJackets();
                }
                if (isTuxExpanded.equals("yes")){
                    ExpandTux();
                }
                ExpandSuits();
            }
        });
        group_item_jackets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSuitExpanded.equals("yes")){
                    ExpandSuits();
                }
                if (isTuxExpanded.equals("yes")){
                    ExpandTux();
                }
                ExpandJackets();
            }
        });
        group_item_tux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isJacketExpanded.equals("yes")){
                    ExpandJackets();
                }
                if (isSuitExpanded.equals("yes")){
                    ExpandSuits();
                }
                ExpandTux();
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_right_to_left, R.anim.exit_left_to_right).remove(NavPanelFragment.this).commit();
            }
        });

        Timer t = new Timer();

        t.schedule(new TimerTask() {
            @Override
            public void run() {

                categories.smoothScrollToPosition(position);
                position++;

            }

        },1000, 2000);

        return view;
    }

    private void ExpandTux() {
        if (isTuxExpanded.equals("no")){
            tuxLayout.setBackgroundColor(Color.WHITE);
            setTextViewDrawableColor(group_item_tux, R.color.gray);
            group_item_tux.setTextColor(Color.BLACK);
            child_item_tux1.setVisibility(View.VISIBLE);
            child_item_tux2.setVisibility(View.VISIBLE);
            isTuxExpanded = "yes";
        } else {
            tuxLayout.setBackgroundColor(Color.BLACK);
            setTextViewDrawableColor(group_item_tux, R.color.gray);
            group_item_tux.setTextColor(Color.WHITE);
            child_item_tux1.setVisibility(View.GONE);
            child_item_tux2.setVisibility(View.GONE);
            isTuxExpanded = "no";
        }
    }

    private void ExpandJackets() {
        if (isJacketExpanded.equals("no")){
            jacketLayout.setBackgroundColor(Color.WHITE);
            setTextViewDrawableColor(group_item_jackets, R.color.gray);
            group_item_jackets.setTextColor(Color.BLACK);
            child_item_jackets1.setVisibility(View.VISIBLE);
            child_item_jackets2.setVisibility(View.VISIBLE);
            isJacketExpanded = "yes";
        } else {
            jacketLayout.setBackgroundColor(Color.BLACK);
            setTextViewDrawableColor(group_item_jackets, R.color.gray);
            group_item_jackets.setTextColor(Color.WHITE);
            child_item_jackets1.setVisibility(View.GONE);
            child_item_jackets2.setVisibility(View.GONE);
            isJacketExpanded = "no";
        }
    }

    private void ExpandSuits() {
        if (isSuitExpanded.equals("no")){
            suitsLayout.setBackgroundColor(Color.WHITE);
            setTextViewDrawableColor(group_item_suits, R.color.gray);
            group_item_suits.setTextColor(Color.BLACK);
            child_item_suits1.setVisibility(View.VISIBLE);
            child_item_suits2.setVisibility(View.VISIBLE);
            isSuitExpanded = "yes";
        } else {
            suitsLayout.setBackgroundColor(Color.BLACK);
            setTextViewDrawableColor(group_item_suits, R.color.gray);
            group_item_suits.setTextColor(Color.WHITE);
            child_item_suits1.setVisibility(View.GONE);
            child_item_suits2.setVisibility(View.GONE);
            isSuitExpanded = "no";
        }
    }

    private void setTextViewDrawableColor(TextView textView, int color) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(textView.getContext(), color), PorterDuff.Mode.SRC_IN));
            }
        }
    }




    @Override
    public void onResume() {
        super.onResume();
//        runAutoScrollCategory();
    }


    @Override
    public void onPause() {
        super.onPause();
//        stopAutoScrollCategory();
    }

}