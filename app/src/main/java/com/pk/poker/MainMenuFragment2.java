package com.pk.poker;

import android.util.Pair;

import com.pk.poker._1_ui.SimpleListViewFragment;
import com.pk.poker.storage.MyApplication;

import java.util.List;

/**
 * Created by Poker on 2017/2/16.
 */

public class MainMenuFragment2 extends SimpleListViewFragment {

    @Override
    public List<Pair<String, Class>> getPairData() {
        return MyApplication.mMainMenuPairList;
    }

}
