package com.pk.poker;

import android.util.Pair;

import com.pk.poker.base.SimpleListViewFragment;
import com.pk.poker.storage.MyApplication;

import java.util.List;

/**
 * Created by Poker on 2017/2/16.
 */

public class MainMenuFragment extends SimpleListViewFragment {

    @Override
    public List<Pair<String, Class>> getPairData() {
        return MyApplication.mMenuStorage.mMainMenu;
    }

}
