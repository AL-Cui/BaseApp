package com.imeepwni.android.baseapp.util;

import android.widget.Toast;

import com.imeepwni.android.baseapp.app.MyApplication;

/**
 * Created by GuoFeng on 2017/3/19.
 */

public class ToastUtils {
    public static void showToast(String msg) {
        Toast.makeText(MyApplication.getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(int msg) {
        Toast.makeText(MyApplication.getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
