package com.pk.poker;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pk.poker.base.BaseFragment;
import com.pk.poker.util.SingleFragmentHelper;

/**
 * Created by Poker on 2017/2/16.
 */

public class MainMenuFragment extends BaseFragment {

    @Override
    public View onCreateViewPK(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pk_menu, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btn = (Button) view.findViewById(R.id.btn_test);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = SingleFragmentHelper.getStartIntent(view.getContext(), TestFragment.class.getName(), null);
                startActivity(intent);
            }
        });
    }
}
