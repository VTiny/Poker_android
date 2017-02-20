package com.pk.poker.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Poker on 2017/2/20.
 */

public class PKToast {

    public static void makeTip(Context context, String content) {
        if (context == null) {
            return;
        }
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }

}
