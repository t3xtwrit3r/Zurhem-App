
package com.example.zurhemapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("id")
    @Expose
    private Integer id;
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
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("href")
    @Expose
    private Href href;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategorySlug() {
        return categorySlug;
    }

    public void setCategorySlug(String categorySlug) {
        this.categorySlug = categorySlug;
    }

    public String getSubcategorySlug() {
        return subcategorySlug;
    }

    public void setSubcategorySlug(String subcategorySlug) {
        this.subcategorySlug = subcategorySlug;
    }

    public String getProductSlug() {
        return productSlug;
    }

    public void setProductSlug(String productSlug) {
        this.productSlug = productSlug;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getClothName() {
        return clothName;
    }

    public void setClothName(String clothName) {
        this.clothName = clothName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Href getHref() {
        return href;
    }

    public void setHref(Href href) {
        this.href = href;
    }

}
