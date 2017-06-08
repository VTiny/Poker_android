package com.pk.poker.util;

import android.util.Log;

/**
 * Description:
 * Author: liuxiao
 * Date: 2017/6/8
 */

public class LogUtil {

    public static void errorLog(String tag, String message) {
        Log.e(tag, message);
    }

    public static void infoLog(String tag, String message) {
        Log.i(tag, message);
    }

}
