package com.example.zurhemapp.model.ProductDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SizeAndFit {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("product_id")
    @Expose
    private String productId;

    @SerializedName("size_and_fit")
    @Expose
    private String sizeAndFit;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public String getProductId() {
        return productId;
    }

    public String getSizeAndFit() {
        return sizeAndFit;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setSizeAndFit(String sizeAndFit) {
        this.sizeAndFit = sizeAndFit;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
