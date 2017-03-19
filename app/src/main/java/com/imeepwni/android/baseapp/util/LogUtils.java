package com.imeepwni.android.baseapp.util;

import android.util.Log;

/**
 * Created by GuoFeng on 2017/3/19.
 */

public class LogUtils {
    // 正式发布改为-1
    public static final int CURRENT_SEE_LEVEL = 4;

    public static final int VERBOSE = 0;
    public static final int DEBUG = 1;
    public static final int INFO = 2;
    public static final int WARN = 3;
    public static final int ERROR = 4;

    public static void v(String tag, String msg) {
        if (CURRENT_SEE_LEVEL >= VERBOSE) {
            Log.d(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (CURRENT_SEE_LEVEL >= DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (CURRENT_SEE_LEVEL >= INFO) {
            Log.d(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (CURRENT_SEE_LEVEL >= WARN) {
            Log.d(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (CURRENT_SEE_LEVEL >= ERROR) {
            Log.d(tag, msg);
        }
    }

}
