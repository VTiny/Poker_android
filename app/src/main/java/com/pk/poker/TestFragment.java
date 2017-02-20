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

    @Override
    public View onCreateViewPK(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pk_test, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
