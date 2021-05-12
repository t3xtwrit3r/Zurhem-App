package com.example.zurhemapp.Model;

import java.util.List;

public class Image {
    private List<Integer> drawableImage;

    public Image(List<Integer> drawableImage) {
        this.drawableImage = drawableImage;
    }

    public List<Integer> getDrawableImage() {
        return drawableImage;
    }

    public void setDrawableImage(List<Integer> drawableImage) {
        this.drawableImage = drawableImage;
    }
}
