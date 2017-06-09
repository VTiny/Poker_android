package com.pk.poker._8_media;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pk.poker.R;
import com.pk.poker.base.BaseFragment;
import com.pk.poker.util.SingleFragmentHelper;

/**
 * Created by Poker on 2017/2/20.
 */

public class MediaMenuFragment extends BaseFragment implements View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pk_media_menu, container, false);
    }

    @Override
    public void initEvent() {
        getView().findViewById(R.id.btn_take_photo).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btn_take_photo:
                intent = SingleFragmentHelper.getStartIntent(view.getContext(), PhotoFragment.class.getName(), null);
                startActivity(intent);
        }
    }
}
