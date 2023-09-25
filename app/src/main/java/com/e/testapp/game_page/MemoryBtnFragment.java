package com.e.testapp.game_page;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.e.testapp.R;

public class MemoryBtnFragment extends Fragment {

    private Button btn_next;
    private Button btn_for_time;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_memory_btn, container, false);
        btn_next = view.findViewById(R.id.btn_next);
        btn_for_time = view.findViewById(R.id.btn_for_time);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.page_2, new CheckFragment())
                        .add(R.id.page_2, TimerFragment.newInstance(""))
                        .commit();
            }
        });

        btn_for_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.page_2, new CheckFragment())
                        .commit();
            }
        });
        return view;
    }
}