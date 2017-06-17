package com.pk.poker.storage;

import android.util.Pair;

import com.pk.poker._1_ui.RecyclerViewFragment;
import com.pk.poker._1_ui.UIMenuFragment;
import com.pk.poker._8_media.MediaMenuFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Author: liuxiao
 * Date: 2017/6/9
 */

public class MenuStorage {

    public static List<Pair<String, Class>> mMainMenu;
    public static List<Pair<String, Class>> mUIMenu;

    static{
        mMainMenu = new ArrayList<>();
        mMainMenu.add(new Pair<String, Class>("多媒体", MediaMenuFragment.class));
        mMainMenu.add(new Pair<String, Class>("UI", UIMenuFragment.class));

        mUIMenu = new ArrayList<>();
        mUIMenu.add(new Pair<String, Class>("RecycleView", RecyclerViewFragment.class));
    }


}
