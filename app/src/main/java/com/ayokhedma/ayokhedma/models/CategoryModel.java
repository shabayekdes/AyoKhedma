package com.ayokhedma.ayokhedma.models;

import java.util.List;

/**
 * Created by SevenTG on 04/04/2017.
 */

public class CategoryModel {
    // Category
    private String categoryId;
    private String categoryName;
    private int categoryImg; // String after
    // Objects
    private String objectName;
    private String region;
    private String phone;
    private String dayOff;
    private String startTimeA;
    private String endTimeA;
    private String startTimeB;
    private String endTimeB;
    private String streetName;
    private String beSides;
    private float rating;
    private int objectImg; // String after

    public CategoryModel() {
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryImg() {
        return categoryImg;
    }

    public void setCategoryImg(int categoryImg) {
        this.categoryImg = categoryImg;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDayOff() {
        return dayOff;
    }

    public void setDayOff(String dayOff) {
        this.dayOff = dayOff;
    }

    public String getStartTimeA() {
        return startTimeA;
    }

    public void setStartTimeA(String startTimeA) {
        this.startTimeA = startTimeA;
    }

    public String getEndTimeA() {
        return endTimeA;
    }

    public void setEndTimeA(String endTimeA) {
        this.endTimeA = endTimeA;
    }

    public String getStartTimeB() {
        return startTimeB;
    }

    public void setStartTimeB(String startTimeB) {
        this.startTimeB = startTimeB;
    }

    public String getEndTimeB() {
        return endTimeB;
    }

    public void setEndTimeB(String endTimeB) {
        this.endTimeB = endTimeB;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getBeSides() {
        return beSides;
    }

    public void setBeSides(String beSides) {
        this.beSides = beSides;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getObjectImg() {
        return objectImg;
    }

    public void setObjectImg(int objectImg) {
        this.objectImg = objectImg;
    }
}
