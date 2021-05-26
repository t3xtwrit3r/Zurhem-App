package com.example.zurhemapp.responses;

import com.example.zurhemapp.model.Datum;
import com.example.zurhemapp.model.Meta;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryItemResponse {

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    @SerializedName("meta")
    @Expose
    private Meta meta;

    public List<Datum> getData() {
        return data;
    }

    public Meta getMeta() {
        return meta;
    }

}
