package com.pk.poker.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;

import com.pk.poker.R;
import com.pk.poker.util.SingleFragmentHelper;

/**
 * Created by Poker on 2017/2/16.
 */

public class SingleFragmentActivity extends BaseActivity {

    private Fragment mFragment;
    private int mContainerViewId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);
        mContainerViewId = R.id.container;
        ensureFragment();
    }

    private void ensureFragment() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        String fragmentTag = intent.getStringExtra(SingleFragmentHelper.FRAGMENT_TAG);
        mFragment = getSupportFragmentManager().findFragmentByTag(fragmentTag);
        if (mFragment == null) {
            String fragmentName = intent.getStringExtra(SingleFragmentHelper.FRAGMENT_NAME);
            if (!TextUtils.isEmpty(fragmentName)) {
                Bundle argu = intent.getBundleExtra(SingleFragmentHelper.FRAGMENT_ARGU);
                mFragment = addFragmentByTa(getContainerViewId(), fragmentName, fragmentTag, argu);
            }
        }
    }

    private Fragment addFragmentByTa(int container, String clazz, String tag, Bundle argu) {
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentByTag(tag);
        if (fragment == null) {
            FragmentTransaction transaction = manager.beginTransaction();
            fragment = Fragment.instantiate(this, clazz, argu);
            transaction.add(container, fragment, tag);
            transaction.commit();
        } else if (fragment.isDetached()) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.attach(fragment);
            transaction.commit();
        }
        return fragment;
    }

    protected final int getContainerViewId(){
        return mContainerViewId;
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }
}
