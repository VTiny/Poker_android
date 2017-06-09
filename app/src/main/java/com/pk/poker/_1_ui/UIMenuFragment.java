package com.pk.poker._1_ui;

import android.util.Pair;

import com.pk.poker.storage.MyApplication;

import java.util.List;

/**
 * Description:
 * Author: liuxiao
 * Date: 2017/6/9
 */

public class UIMenuFragment extends SimpleListViewFragment {
    @Override
    public List<Pair<String, Class>> getPairData() {
        return MyApplication.mUIMenuPairList;
    }
}
