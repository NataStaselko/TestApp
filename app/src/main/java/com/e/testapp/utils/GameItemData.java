package com.e.testapp.utils;

import com.e.testapp.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameItemData {
    private static GameItemData instance;
    private List<GameItem> list = new ArrayList<>();
    private List<GameItem> img_list = new ArrayList<>();

    private List<GameItem> city_list = new ArrayList<>();

    private GameItemData() {
        createList();
        createImgList();
        createCityList();
    }
    public static synchronized GameItemData getInstance() {
        if (instance == null) {
            instance = new GameItemData();
        }
        return instance;
    }

    private void createList(){
        list.add(new GameItem(R.drawable.london, "LONDON"));
        list.add(new GameItem(R.drawable.los_angeles, "LOS ANGELES"));
        list.add(new GameItem(R.drawable.madrid, "MADRID"));
        list.add(new GameItem(R.drawable.moscow, "MOSCOW"));
        list.add(new GameItem(R.drawable.new_york, "NEW YORK"));
        list.add(new GameItem(R.drawable.tokio, "TOKIO"));
        list.add(new GameItem(R.drawable.hong_kong, "HONG KONG"));
        list.add(new GameItem(R.drawable.bern, "BERN"));
        list.add(new GameItem(R.drawable.sydney, "SYDNEY"));
        Collections.unmodifiableList(list);
    }

    private void createImgList(){
        img_list.add(new GameItem(R.drawable.london));
        img_list.add(new GameItem(R.drawable.los_angeles));
        img_list.add(new GameItem(R.drawable.madrid));
        img_list.add(new GameItem(R.drawable.moscow));
        img_list.add(new GameItem(R.drawable.new_york));
        img_list.add(new GameItem(R.drawable.tokio));
        img_list.add(new GameItem(R.drawable.hong_kong));
        img_list.add(new GameItem(R.drawable.bern));
        img_list.add(new GameItem(R.drawable.sydney));
        Collections.unmodifiableList(img_list);
    }

    private void createCityList(){
        city_list.add(new GameItem("LONDON"));
        city_list.add(new GameItem("LOS ANGELES"));
        city_list.add(new GameItem("MADRID"));
        city_list.add(new GameItem("MOSCOW"));
        city_list.add(new GameItem("NEW YORK"));
        city_list.add(new GameItem("TOKIO"));
        city_list.add(new GameItem("HONG KONG"));
        city_list.add(new GameItem("BERN"));
        city_list.add(new GameItem("SYDNEY"));
        Collections.unmodifiableList(city_list);
    }

    public List<GameItem> getList() {
        return list;
    }

    public List<GameItem> getImg_list() {
        return img_list;
    }

    public List<GameItem> getCity_list() {
        return city_list;
    }
}
