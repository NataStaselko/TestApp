package com.e.testapp.utils;


import java.util.Objects;

public class GameItem {
    private int img_resource;
    private String city_name;

    public GameItem() {
    }

    public GameItem(int img_resource, String city_name) {
        this.img_resource = img_resource;
        this.city_name = city_name;
    }

    public GameItem(int img_resource) {
        this.img_resource = img_resource;
    }

    public GameItem(String city_name) {
        this.city_name = city_name;
    }

    public int getImg_resource() {
        return img_resource;
    }

    public void setImg_resource(int img_resource) {
        this.img_resource = img_resource;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameItem gameItem = (GameItem) o;
        return img_resource == gameItem.img_resource && Objects.equals(city_name, gameItem.city_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(img_resource, city_name);
    }
}
