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

    ScrollView scrollView;

    @Override
    public View onCreateViewPK(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pk_menu, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.btn_test).setOnClickListener(this);
        view.findViewById(R.id.btn_media).setOnClickListener(this);

        scrollView = (ScrollView) view.findViewById(R.id.scroll);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.smoothScrollTo(0, 200);
            }
        });
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
                scrollView.smoothScrollTo(0, 100);
                break;
        }
    }
}
