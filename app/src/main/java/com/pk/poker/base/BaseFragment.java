package com.pk.poker.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.pk.poker.constant.StringConstant;
import com.pk.poker.util.LogUtil;

/**
 * Created by Poker on 2017/2/16.
 */

public class BaseFragment extends Fragment {

    public final String TAG = getClass().getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.infoLog(TAG, StringConstant.LOG_ON_CREATE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.infoLog(TAG, StringConstant.LOG_ON_DESTROY);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initField();
        initView();
        initEvent();
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
