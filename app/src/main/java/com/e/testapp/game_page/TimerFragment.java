package com.e.testapp.game_page;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.e.testapp.R;

public class TimerFragment extends Fragment {

    private static final String TIMER_TEXT = "text";
    private String text;
    private TextView textView;
    private CountDownTimer downTimer;
    private final int seconds = 11;

    public TimerFragment() {
    }

    public static TimerFragment newInstance(String param1) {
        TimerFragment fragment = new TimerFragment();
        Bundle args = new Bundle();
        args.putString(TIMER_TEXT, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            text = getArguments().getString(TIMER_TEXT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timer, container, false);
        textView = view.findViewById(R.id.timer);
        downTimer = new CountDownTimer(seconds * 1000, 1000) {
            @Override
            public void onTick(long l) {
                int sec = (int) (l / 1000);
                if (sec < 10) {
                    textView.setText("00:0" + String.valueOf(sec));
                } else {
                    textView.setText("00:" + String.valueOf(sec));
                }
            }

            @Override
            public void onFinish() {
                if (text.equals("casual")) {
                    textView.setText("");
                    Fragment fragment = getActivity().getSupportFragmentManager().findFragmentByTag("list");
                    getParentFragmentManager().beginTransaction()
                            .remove(fragment)
                            .add(R.id.page_2, new LetsGoFragment())
                            .commit();
                } else if (text.equals("")) {
                    getParentFragmentManager().beginTransaction()
                            .replace(R.id.page_2, new ResultFragment(), "finish")
                            .commit();
                }
            }
        };
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        textView.setText("00:10");
        downTimer.start();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        downTimer.cancel();
    }
}