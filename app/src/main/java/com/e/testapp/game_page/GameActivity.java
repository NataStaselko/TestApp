package com.e.testapp.game_page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.e.testapp.R;

public class GameActivity extends AppCompatActivity implements CheckFragment.CounterListener {
    private String flag;
    public String getFlag() {
        return flag;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();
        flag = intent.getStringExtra("flag");
        if (flag.equals("casual")) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.page_2, TimerFragment.newInstance("casual"))
                    .add(R.id.page_2, new MemoryListFragment(), "list")
                    .add(R.id.page_2, new MemoryBtnFragment())
                    .commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.page_2, new MemoryListFragment(), "list")
                    .add(R.id.page_2, new MemoryBtnFragment())
                    .commit();
        }
    }

    @Override
    public void clickCount(String s) {
        ResultFragment fragment = (ResultFragment) getSupportFragmentManager().findFragmentByTag("finish");
        if (fragment != null){
            fragment.setCounter(s);
        }
    }
}