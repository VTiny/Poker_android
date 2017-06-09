package com.pk.poker.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Description:
 * Author: liuxiao
 * Date: 2017/6/9
 */

public class ToastUtil {

    public static void show(Context context, Object message) {
        Toast.makeText(context, message.toString(), Toast.LENGTH_SHORT).show();
    }

}
