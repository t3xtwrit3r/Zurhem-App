package com.example.zurhemapp.responses;

import com.example.zurhemapp.model.ProductDetails.Category;
import com.example.zurhemapp.model.ProductDetails.DetailsCare;
import com.example.zurhemapp.model.ProductDetails.Feature;
import com.example.zurhemapp.model.ProductDetails.Image;
import com.example.zurhemapp.model.ProductDetails.Product;
import com.example.zurhemapp.model.ProductDetails.RandomProduct;
import com.example.zurhemapp.model.ProductDetails.Size;
import com.example.zurhemapp.model.ProductDetails.SizeAndFit;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductDetailsResponse {

    @SerializedName("STATUS")
    @Expose
    private String status;

    @SerializedName("product")
    @Expose
    private Product product;

    @SerializedName("size")
    @Expose
    private List<Size> size = null;

    @SerializedName("detailscare")
    @Expose
    private List<DetailsCare> detailsCare = null;

    @SerializedName("size_and_fit")
    @Expose
    private List<SizeAndFit> sizeAndFit = null;

    @SerializedName("features")
    @Expose
    private List<Feature> features = null;

    @SerializedName("images")
    @Expose
    private List<Image> images = null;

    @SerializedName("category")
    @Expose
    private Category category;

    @SerializedName("category_name")
    @Expose
    private String categoryName;

    @SerializedName("subcategory_name")
    @Expose
    private String subcategoryName;

    @SerializedName("random_products")
    @Expose
    private List<RandomProduct> randomProducts = null;

    public String getStatus() {
        return status;
    }

    public Product getProduct() {
        return product;
    }

    public List<Size> getSize() {
        return size;
    }

    public List<DetailsCare> getDetailsCare() {
        return detailsCare;
    }

    public List<SizeAndFit> getSizeAndFit() {
        return sizeAndFit;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public List<Image> getImages() {
        return images;
    }

    public Category getCategory() {
        return category;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public List<RandomProduct> getRandomProducts() {
        return randomProducts;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setSize(List<Size> size) {
        this.size = size;
    }

    public void setDetailsCare(List<DetailsCare> detailsCare) {
        this.detailsCare = detailsCare;
    }

    public void setSizeAndFit(List<SizeAndFit> sizeAndFit) {
        this.sizeAndFit = sizeAndFit;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public void setRandomProducts(List<RandomProduct> randomProducts) {
        this.randomProducts = randomProducts;
    }
}
