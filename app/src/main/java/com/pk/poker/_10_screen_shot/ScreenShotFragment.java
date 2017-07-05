package com.pk.poker._10_screen_shot;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;

import com.pk.poker.base.BaseFragment;

/**
 * Created by liuxiao on 2017/7/4.
 */

public class ScreenShotFragment extends BaseFragment {

    private MediaContentObserver mInternalObserver;
    private MediaContentObserver mExternalObserver;

    @Override
    public void initEvent() {

    }

    private void initMediaContentObserver() {
        final Handler uiHandler = new Handler(Looper.getMainLooper());
        mInternalObserver = new MediaContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, uiHandler);
        mExternalObserver = new MediaContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, uiHandler);
        getContext().getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, false, mInternalObserver);
        getContext().getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, false, mExternalObserver);

    }

    private class MediaContentObserver extends ContentObserver {
        private Uri mediaContentUri;

        public MediaContentObserver(Uri mediaContentUri, Handler handler) {
            super(handler);
            this.mediaContentUri = mediaContentUri;
        }

        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);

        }
    }

}
