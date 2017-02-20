package com.pk.poker.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.pk.poker.base.SingleFragmentActivity;

/**
 * Created by Poker on 2017/2/16.
 */

public class SingleFragmentHelper {

    public static final String FROM_WHERE = "from_where";
    public static final String FRAGMENT_NAME = "fragment_name";
    public static final String FRAGMENT_TAG = "fragment_tag";
    public static final String FRAGMENT_ARGU = "fragment_argu";


    /**
     * 获取一个启动Intent
     * 传入的class应当是SingleFragmentActivity或其子类
     */
    public static Intent getStartIntent(Context context, String fragmentName, String fragmentTag,
                                        Bundle fragmentArgu, Class clazz) {
        Intent intent = new Intent(context, clazz);
        putSingleBundle(intent, fragmentName, fragmentTag, fragmentArgu);
        return intent;
    }

    /**
     * 获取一个启动SingleFragmentActivity Intent
     */
    public static Intent getStartIntent(Context context, String fragmentName, String fragmentTag, Bundle fragmentArgu) {
        return getStartIntent(context, fragmentName, fragmentTag, fragmentArgu, SingleFragmentActivity.class);
    }

    public static void putSingleBundle(Intent intent, String fragmentName, String fragmentTag,
                                       Bundle fragmentArgu) {
        if (intent == null) {
            return;
        }
        intent.putExtra(FRAGMENT_NAME, fragmentName);
        intent.putExtra(FRAGMENT_TAG, fragmentTag);
        intent.putExtra(FRAGMENT_ARGU, fragmentArgu);
    }

    public static Intent getStartIntent(Context context, String fragmentNameAndTag, Bundle fragmentArgu, Class clazz) {
        Intent intent = new Intent(context, clazz);
        putSingleBundle(intent, fragmentNameAndTag, fragmentArgu);
        return intent;
    }

    public static Intent getStartIntent(Context context, String fragmentNameAndTag, Bundle fragmentArgu) {
        return getStartIntent(context, fragmentNameAndTag, fragmentArgu, SingleFragmentActivity.class);
    }

    public static void putSingleBundle(Intent intent, String fragmentNameAndTag, Bundle fragmentArgu) {
        if (intent == null) {
            return;
        }
        intent.putExtra(FRAGMENT_NAME, fragmentNameAndTag);
        intent.putExtra(FRAGMENT_TAG, fragmentNameAndTag);
        intent.putExtra(FRAGMENT_ARGU, fragmentArgu);
    }

}
