package com.ayokhedma.ayokhedma.models;

/**
 * Created by SevenTG on 04/04/2017.
 */

public class CategoryModel {
    public String id;
    public String name;
    public int img;

    public CategoryModel() {
    }

    public CategoryModel(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
