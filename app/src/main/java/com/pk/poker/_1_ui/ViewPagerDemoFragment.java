package com.pk.poker._1_ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pk.poker.R;
import com.pk.poker.base.BaseFragment;
import com.viewpagerindicator.TabPageIndicator;

/**
 * Created by liuxiao on 2017/7/4.
 */

public class ViewPagerDemoFragment extends BaseFragment {

    private static final String[] TITLE = new String[]{"Page1", "Page2", "Page3"};
    private FragmentPagerAdapter mFragmentPagerAdapter;
    private ViewPager mViewPager;
    private TabPageIndicator mTab;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTheme(R.style.Theme_PageIndicatorDefaults);
        return inflater.inflate(R.layout.lx_view_pager_demo, null, false);
    }

    @Override
    public void initField() {
        mFragmentPagerAdapter = new TabPageIndicatorAdapter(getActivity().getSupportFragmentManager());
        mViewPager = (ViewPager) getView().findViewById(R.id.view_pager);
        mTab = (TabPageIndicator) getView().findViewById(R.id.tab);
    }

    @Override
    public void initView() {
        mViewPager.setAdapter(mFragmentPagerAdapter);
        mTab.setViewPager(mViewPager);
    }

    private class TabPageIndicatorAdapter extends FragmentPagerAdapter {
        public TabPageIndicatorAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = new ViewPagerItemFragment();
            Bundle args = new Bundle();
            args.putString("args", TITLE[position]);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLE[position % TITLE.length];
        }

        @Override
        public int getCount() {
            return TITLE.length;
        }
    }
}

