package com.example.zurhemapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {

    @SerializedName("current_page")
    @Expose
    private Integer currentPage;
    @SerializedName("from")
    @Expose
    private Integer from;
    @SerializedName("last_page")
    @Expose
    private Integer lastPage;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("per_page")
    @Expose
    private Integer perPage;
    @SerializedName("to")
    @Expose
    private Integer to;
    @SerializedName("total")
    @Expose
    private Integer total;


    public Integer getCurrentPage() {
        return currentPage;
    }


    public Integer getFrom() {
        return from;
    }


    public Integer getLastPage() {
        return lastPage;
    }


    public String getPath() {
        return path;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public Integer getTo() {
        return to;
    }


    public Integer getTotal() {
        return total;
    }


}
