package com.pk.poker;

import android.os.Bundle;

import com.pk.poker.base.SingleFragmentActivity;
import com.pk.poker.util.SingleFragmentHelper;

public class MainMenuActivity extends SingleFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SingleFragmentHelper.putSingleBundle(getIntent(), MainMenuFragment.class.getName(), null);
        super.onCreate(savedInstanceState);
    }



}
