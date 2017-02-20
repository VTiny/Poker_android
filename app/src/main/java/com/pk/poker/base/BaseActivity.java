package com.pk.poker.base;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by Poker on 2017/2/16.
 */

public class BaseActivity extends AppCompatActivity {



    @Override
    protected void onStart() {
        initField();
        initView();
        initEvent();
        super.onStart();
    }

    public void initField() {

    }

    public void initView() {

    }

    public void initEvent() {

    }

}
