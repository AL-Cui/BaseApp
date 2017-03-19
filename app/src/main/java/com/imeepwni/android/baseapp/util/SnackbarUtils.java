package com.imeepwni.android.baseapp.util;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by GuoFeng on 2017/3/19.
 */

public class SnackbarUtils {
    public static void showSnackbar(View v, String msg) {
        Snackbar.make(v, msg, Snackbar.LENGTH_SHORT).show();
    }

    public static void showSnackbar(View v, int msg) {
        Snackbar.make(v, msg, Snackbar.LENGTH_SHORT).show();
    }
}
