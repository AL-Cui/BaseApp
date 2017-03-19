package com.imeepwni.android.baseapp.app;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GuoFeng on 2017/3/19.
 */

public class MyApplication extends Application {
    // 请将manifests的<application name:>修改为本类
    private static Context sContext;
    private static List<BaseActivity> sActivities;
    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        sActivities = new ArrayList<BaseActivity>();
    }

    public static Context getContext() {
        return sContext;
    }

    public static void addActivity(BaseActivity baseActivity) {
        sActivities.add(baseActivity);
    }

    public static void removeActivity(BaseActivity baseActivity) {
        sActivities.remove(baseActivity);
    }

    public static void finishAllActivities() {
        int size = sActivities.size();
        for (int i = 0; i < size; i++) {
            BaseActivity baseActivity = sActivities.get(i);
            if (!baseActivity.isFinishing()) {
                baseActivity.finish();
            }
        }
    }
}
