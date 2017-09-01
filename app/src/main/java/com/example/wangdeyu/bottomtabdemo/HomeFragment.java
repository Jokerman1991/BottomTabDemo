package com.example.wangdeyu.bottomtabdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wangdeyu on 17-8-31.
 */

public class HomeFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        SpringScrollView springScrollView = (SpringScrollView) root.findViewById(R.id.scroll);
        springScrollView.setOnSpringScrollChangeListener(new SpringScrollView.OnSpringScrollChangeListener() {
            @Override
            public void onSpringScrollChange(SpringScrollView springScrollView, int l, int t, int oldl, int oldt) {
                LogUtils.d("listener, l: " + l + ", t: " + l + ", oldl: " + oldl + ", oldt: " + oldt);
            }
        });
        return root;
    }


}
