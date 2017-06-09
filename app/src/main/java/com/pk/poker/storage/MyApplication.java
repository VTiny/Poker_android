package com.pk.poker.storage;

import android.app.Application;
import android.util.Pair;

import com.pk.poker.TestFragment;
import com.pk.poker._1_ui.UIMenuFragment;
import com.pk.poker._8_media.MediaMenuFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Author: liuxiao
 * Date: 2017/6/9
 */

public class MyApplication extends Application {

    public static List<Pair<String, Class>> mMainMenuPairList;
    public static List<Pair<String, Class>> mUIMenuPairList;


    static{
        mMainMenuPairList = new ArrayList<>();
        mMainMenuPairList.add(new Pair<String, Class>("多媒体", MediaMenuFragment.class));
        mMainMenuPairList.add(new Pair<String, Class>("UI", UIMenuFragment.class));

        mUIMenuPairList = new ArrayList<>();
        mUIMenuPairList.add(new Pair<String, Class>("RecycleView", TestFragment.class));
    }

}
