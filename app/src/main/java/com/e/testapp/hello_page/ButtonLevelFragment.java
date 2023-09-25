package com.e.testapp.hello_page;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.e.testapp.R;
import com.e.testapp.game_page.GameActivity;

public class ButtonLevelFragment extends Fragment {
    Button casual;
    Button for_time;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_button_level, container, false);
        casual = view.findViewById(R.id.casual);
        casual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createIntent("casual");
            }
        });

        for_time = view.findViewById(R.id.for_time);
        for_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createIntent("for_time");
            }
        });
        return view;
    }

    private void createIntent(String s){
        Intent intent = new Intent(getActivity(), GameActivity.class);
        intent.putExtra("flag", s);
        startActivity(intent);
    }
}