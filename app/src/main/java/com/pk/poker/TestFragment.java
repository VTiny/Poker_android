package com.pk.poker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pk.poker.base.BaseFragment;

/**
 * Created by Poker on 2017/2/16.
 */

public class TestFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.lx_test, container, false);
    }


    @Override
    public void initField() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initEvent() {

    }
}
