package com.e.testapp.hello_page;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.e.testapp.R;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButtonPlayFragment buttonPlayFragment = new ButtonPlayFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.page_1, buttonPlayFragment)
                .commit();
    }
}