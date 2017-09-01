package com.example.wangdeyu.bottomtabdemo;

import android.util.Log;

/**
 * Created by wangdeyu on 17-9-1.
 */

public class LogUtils {

    private static final String TAG = "SCROLL_TEST";

    public static void d(String msg) {
        d(TAG, msg);
    }

    public static void d(String tag, String msg) {
        d(tag, "", msg);
    }

    public static void d(String tag, String module, String msg) {
        d(tag, module, "", msg);
    }

    public static void d(String tag, String module, String method, String msg) {
        Log.d(tag, module + "::" + method + ": " + msg);
    }
}
