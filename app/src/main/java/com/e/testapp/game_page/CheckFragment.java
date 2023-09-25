package com.e.testapp.game_page;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.e.testapp.R;
import com.e.testapp.game_page.adapters.ImgTimeAdapter;
import com.e.testapp.game_page.adapters.NameTimeAdapter;
import com.e.testapp.utils.GameItem;
import com.e.testapp.utils.GameItemData;

import java.util.Collections;
import java.util.List;

public class CheckFragment extends Fragment {

    interface CounterListener {
        void clickCount(String s);
    }

    private CounterListener counterListener;
    private List<GameItem> img;
    private List<GameItem> name;

    private List<GameItem> data;

    private GameItem gameItem;

    private int counter = 0;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        counterListener = (CounterListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_check, container, false);

        img = GameItemData.getInstance().getImg_list();
        name = GameItemData.getInstance().getCity_list();
        data = GameItemData.getInstance().getList();
        gameItem = new GameItem(0, "");

        Collections.shuffle(img);
        Collections.shuffle(name);

        RecyclerView recyclerView1 = view.findViewById(R.id.img_list);
        RecyclerView recyclerView2 = view.findViewById(R.id.name_list);

        ImgTimeAdapter.OnClickImgTimeAdapter onClickImgTimeAdapter = new ImgTimeAdapter.OnClickImgTimeAdapter() {
            @Override
            public void itemOnClick(GameItem item, int position, View view) {
                if (gameItem.getImg_resource() == 0) {
                    gameItem.setImg_resource(item.getImg_resource());
                    view.setVisibility(View.INVISIBLE);
                }
                checkItem(gameItem);
            }
        };

        ImgTimeAdapter adapter1 = new ImgTimeAdapter(getContext(), img, onClickImgTimeAdapter);
        recyclerView1.setAdapter(adapter1);

        NameTimeAdapter.OnClickNameTimeAdapter onClickNameTimeAdapter = new NameTimeAdapter.OnClickNameTimeAdapter() {
            @Override
            public void itemOnClick(GameItem item, int position, View view) {
                if (gameItem.getCity_name().equals("")) {
                    gameItem.setCity_name(item.getCity_name());
                    view.setVisibility(View.INVISIBLE);
                }
                checkItem(gameItem);
            }
        };
        NameTimeAdapter adapter2 = new NameTimeAdapter(getContext(), name, onClickNameTimeAdapter);

        recyclerView2.setAdapter(adapter2);
        Button button = view.findViewById(R.id.button_check);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.page_2, new ResultFragment(), "finish")
                        .commit();
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        counterListener.clickCount(String.valueOf(counter));
    }

    private void checkItem(GameItem item) {
        if (item.getImg_resource() != 0 && !item.getCity_name().equals("")) {
            if (data.contains(item)) {
                counter++;
            } else {

                counter--;
            }
            gameItem.setImg_resource(0);
            gameItem.setCity_name("");
        }
    }
}