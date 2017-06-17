package com.pk.poker._1_ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pk.poker.R;
import com.pk.poker.base.BaseFragment;

/**
 * Description:
 * Author: liuxiao
 * Date: 2017/6/10
 */

public class RecyclerViewFragment extends BaseFragment {

    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.lx_recycler_view, container, false);
    }

    @Override
    public void initView() {
        mRecyclerView = (RecyclerView) getView().findViewById(R.id.recycler_view);
    }
}
