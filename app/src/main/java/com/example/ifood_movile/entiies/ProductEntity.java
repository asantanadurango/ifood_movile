package com.example.ifood_movile.entiies;

import java.util.ArrayList;

public class ProductEntity {

    private String id;
    private String name;
    private int price;
    private String imgUrl;
    private ArrayList<String> tags;

    public ProductEntity() {
        this.id = null;
        this.tags = new ArrayList <> ();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }
}
