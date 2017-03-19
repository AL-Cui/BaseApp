package com.imeepwni.android.baseapp.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by GuoFeng on 2017/3/19.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.addActivity(this);
        initData();
        initViews(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        MyApplication.removeActivity(this);
        super.onDestroy();
    }

    /**
     * init data
     */
    protected abstract void initData();

    /**
     * init Views
     *
     * @param savedInstanceState
     */
    protected abstract void initViews(Bundle savedInstanceState);
}
