package com.pk.poker;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.pk.poker._8_media.MediaMenuFragment;
import com.pk.poker.base.BaseFragment;
import com.pk.poker.util.SingleFragmentHelper;

/**
 * Created by Poker on 2017/2/16.
 */

public class MainMenuFragment extends BaseFragment implements View.OnClickListener {

    private ScrollView mScrollView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pk_menu, container, false);
    }

    @Override
    public void initView() {
        mScrollView = (ScrollView) getView().findViewById(R.id.scroll);
    }

    @Override
    public void initEvent() {
        getView().findViewById(R.id.btn_test).setOnClickListener(this);
        getView().findViewById(R.id.btn_media).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btn_media:
                intent = SingleFragmentHelper.getStartIntent(view.getContext(), MediaMenuFragment.class.getName(), null);
                startActivity(intent);
                break;
            case R.id.btn_test:
                mScrollView.smoothScrollTo(0, 100);
                break;
        }
    }
}
