package com.e.testapp.game_page;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.e.testapp.R;
import com.e.testapp.game_page.adapters.GameItemAdapter;
import com.e.testapp.utils.GameItem;
import com.e.testapp.utils.GameItemData;

import java.util.Collections;
import java.util.List;

public class MemoryListFragment extends Fragment {

    private List<GameItem> items;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_memory_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.items_list);
        items = GameItemData.getInstance().getList();
        Collections.shuffle(items);

        GameItemAdapter adapter = new GameItemAdapter(getContext(),items);
        recyclerView.setAdapter(adapter);
        return view;
    }
}