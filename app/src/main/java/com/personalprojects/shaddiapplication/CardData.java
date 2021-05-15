package com.personalprojects.shaddiapplication;

public class CardData {

    private String imageSource;

    public CardData(String imageSource) {
        this.imageSource = imageSource;
    }
    public String getImageId() {
        return imageSource;
    }
    public void setImageId(String imageId) {
        this.imageSource = imageId;
    }
}
