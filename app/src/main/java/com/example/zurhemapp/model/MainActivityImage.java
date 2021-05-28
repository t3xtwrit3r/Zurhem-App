package com.example.zurhemapp.model;

import java.util.List;

public class MainActivityImage {
    private List<Integer> drawableImage;

    public MainActivityImage(List<Integer> drawableImage) {
        this.drawableImage = drawableImage;
    }

    public List<Integer> getDrawableImage() {
        return drawableImage;
    }

    public void setDrawableImage(List<Integer> drawableImage) {
        this.drawableImage = drawableImage;
    }
}
