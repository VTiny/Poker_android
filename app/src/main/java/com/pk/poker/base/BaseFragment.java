package com.pk.poker.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Poker on 2017/2/16.
 */

public class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return onCreateViewPK(inflater, container, savedInstanceState);
    }

    public View onCreateViewPK(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }
}
