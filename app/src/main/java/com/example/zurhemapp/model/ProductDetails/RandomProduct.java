package com.example.zurhemapp.model.ProductDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RandomProduct {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("product_code")
    @Expose
    private String productCode;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("category_slug")
    @Expose
    private String categorySlug;

    @SerializedName("subcategory_slug")
    @Expose
    private String subcategorySlug;

    @SerializedName("product_slug")
    @Expose
    private String productSlug;

    @SerializedName("price")
    @Expose
    private String price;

    @SerializedName("desc")
    @Expose
    private String desc;

    @SerializedName("cloth_name")
    @Expose
    private String clothName;

    @SerializedName("size")
    @Expose
    private Object size;

    @SerializedName("detail_and_care")
    @Expose
    private Object detailAndCare;

    @SerializedName("size_and_fit")
    @Expose
    private Object sizeAndFit;

    @SerializedName("feature")
    @Expose
    private Object feature;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getName() {
        return name;
    }

    public String getCategorySlug() {
        return categorySlug;
    }

    public String getSubcategorySlug() {
        return subcategorySlug;
    }

    public String getProductSlug() {
        return productSlug;
    }

    public String getPrice() {
        return price;
    }

    public String getDesc() {
        return desc;
    }

    public String getClothName() {
        return clothName;
    }

    public Object getSize() {
        return size;
    }

    public Object getDetailAndCare() {
        return detailAndCare;
    }

    public Object getSizeAndFit() {
        return sizeAndFit;
    }

    public Object getFeature() {
        return feature;
    }

    public String getStatus() {
        return status;
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

    public void setImage(String image) {
        this.image = image;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategorySlug(String categorySlug) {
        this.categorySlug = categorySlug;
    }

    public void setSubcategorySlug(String subcategorySlug) {
        this.subcategorySlug = subcategorySlug;
    }

    public void setProductSlug(String productSlug) {
        this.productSlug = productSlug;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setClothName(String clothName) {
        this.clothName = clothName;
    }

    public void setSize(Object size) {
        this.size = size;
    }

    public void setDetailAndCare(Object detailAndCare) {
        this.detailAndCare = detailAndCare;
    }

    public void setSizeAndFit(Object sizeAndFit) {
        this.sizeAndFit = sizeAndFit;
    }

    public void setFeature(Object feature) {
        this.feature = feature;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
