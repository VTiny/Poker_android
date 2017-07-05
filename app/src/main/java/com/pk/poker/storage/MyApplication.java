package com.pk.poker.storage;

import android.app.Application;

/**
 * Description:
 * Author: liuxiao
 * Date: 2017/6/9
 */

public class MyApplication extends Application {

    private static String TAG = MyApplication.class.getName();

    //    public static final MenuStorage mMenuStorage = new MenuStorage();
    private static MyApplication instance;
    private MenuStorage menuStorage;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        if (menuStorage == null) {
            menuStorage = new MenuStorage();
        }
    }

    public static MyApplication getInstance() {
        return instance;
    }

    public MenuStorage getMenuStorage() {
        return menuStorage;
    }
}
