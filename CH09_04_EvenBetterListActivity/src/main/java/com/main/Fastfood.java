package com.main;

/**
 * Created by ki264 on 2016/11/23.
 */

public class Fastfood {
    private String name;
    private int price;
    private int imageID;

    public Fastfood(String name, int price, int imageID) {
        setName(name);
        setPrice(price);
        setImageID(imageID);
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

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}
