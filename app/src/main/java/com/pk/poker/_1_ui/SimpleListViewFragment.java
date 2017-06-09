package com.pk.poker._1_ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.pk.poker.R;
import com.pk.poker.base.BaseFragment;
import com.pk.poker.base.SimpleViewHolderAdapter;
import com.pk.poker.util.SingleFragmentHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Author: liuxiao
 * Date: 2017/6/9
 */

public abstract class SimpleListViewFragment extends BaseFragment {

    private ListView mListView;
    private List<String> mListViewContentList;
    private List<Class> mListViewClassList;
    private List<Pair<String, Class>> mDataList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.lx_simple_list_view, container, false);
    }

    @Override
    public void initField() {
        mListViewContentList = new ArrayList<>();
        mListViewClassList = new ArrayList<>();
        mDataList = getPairData();
        for (Pair<String, Class> item : mDataList) {
            addToMenu(item);
        }
    }

    @Override
    public void initView() {
        mListView = (ListView) getView().findViewById(R.id.list_view);
        mListView.setAdapter(new SimpleViewHolderAdapter(getContext(), mListViewContentList));
    }

    @Override
    public void initEvent() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = SingleFragmentHelper.getStartIntent(getContext(), mListViewClassList.get(position).getName(), null);
                startActivity(intent);
            }
        });
    }

    public abstract List<Pair<String, Class>> getPairData();

    private void addToMenu(Pair<String, Class> item) {
        mListViewContentList.add(item.first);
        mListViewClassList.add(item.second);
    }

}
