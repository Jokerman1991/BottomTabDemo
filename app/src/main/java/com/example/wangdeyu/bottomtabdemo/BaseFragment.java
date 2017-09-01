package com.example.wangdeyu.bottomtabdemo;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by wangdeyu on 17-9-1.
 */

public class BaseFragment extends Fragment {

    protected Activity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }
}
