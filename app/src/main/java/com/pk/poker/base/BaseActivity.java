package com.pk.poker.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.pk.poker.constant.StringConstant;
import com.pk.poker.util.LogUtil;

/**
 * Created by Poker on 2017/2/16.
 */

public class BaseActivity extends AppCompatActivity {

    public final String TAG = getClass().getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        if (!"SingleFragmentActivity".equals(TAG)) {
            LogUtil.infoLog(TAG, StringConstant.LOG_ON_CREATE);
        }
    }

    @Override
    protected void onStart() {
        initField();
        initView();
        initEvent();
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!"SingleFragmentActivity".equals(TAG)) {
            LogUtil.infoLog(TAG, StringConstant.LOG_ON_DESTROY);
        }
    }

    /**
     * 初始化变量
     */
    public void initField() {

    }

    /**
     * 初始化视图
     */
    public void initView() {

    }

    /**
     * 初始化点击事件
     */
    public void initEvent() {

    }

}
